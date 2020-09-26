package com.company.ticketservice.service.impl;

import com.company.ticketservice.dto.TicketDTO;
import com.company.ticketservice.enums.PriorityType;
import com.company.ticketservice.enums.TicketStatus;
import com.company.ticketservice.exception.TicketNotFoundException;
import com.company.ticketservice.model.Ticket;
import com.company.ticketservice.model.es.TicketModel;
import com.company.ticketservice.repository.TicketRepository;
import com.company.ticketservice.repository.es.TicketElasticRepository;
import com.company.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticRepository ticketElasticRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public TicketDTO save(TicketDTO ticketDTO) {
        // TicketDTO to Ticket
        Ticket ticket = new Ticket();
        // TODO: Check from Account API
        //  ticket.setAssignee();

        if (ticketDTO.getDescription() == null)
            throw new TicketNotFoundException("Description can't be null");

        ticket.setNotes(ticketDTO.getNotes());
        ticket.setTicketDate(ticketDTO.getTicketDate());
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDTO.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDTO.getPriorityType()));

        // save to MySQL
        ticket = ticketRepository.save(ticket);
        // TicketDTO to TicketModel
        TicketModel ticketModel = TicketModel.builder()
                                    .description(ticket.getDescription())
                                    .notes(ticket.getNotes())
                                    .id(ticket.getId())
                                    .priorityType(ticket.getPriorityType().getLabel())
                                    .ticketStatus(ticket.getTicketStatus().getLabel())
                                    .ticketDate(ticket.getTicketDate()).build();

        // save to Elastic
        ticketElasticRepository.save(ticketModel);
        // return TicketDTO
        ticketDTO.setId(ticket.getId());

        return ticketDTO;
    }

    @Override
    public TicketDTO update(String id, TicketDTO ticketDTO) {
        return null;
    }


    @Override
    public TicketDTO getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDTO> getPagination(Pageable pageable) {
        return null;
    }
}

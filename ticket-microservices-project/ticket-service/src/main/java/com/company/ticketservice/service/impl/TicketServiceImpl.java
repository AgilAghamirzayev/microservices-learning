package com.company.ticketservice.service.impl;

import com.company.ticketservice.dto.TicketDTO;
import com.company.ticketservice.repository.TicketRepository;
import com.company.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public TicketDTO save(TicketDTO ticket) {
        return null;
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

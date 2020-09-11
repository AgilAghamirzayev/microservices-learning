package com.company.ticketservice.controller;

import com.company.ticketservice.dto.TicketDTO;
import com.company.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getById(@RequestBody String id) {
        TicketDTO getTicket = ticketService.getById(id);
        return ResponseEntity.ok(getTicket);
    }

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO save = ticketService.save(ticketDTO);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable String id, @RequestBody TicketDTO ticketDTO) {
        TicketDTO update = ticketService.update(id, ticketDTO);
        return ResponseEntity.ok(update);
    }

    @GetMapping
    public ResponseEntity<Page<TicketDTO>> getAll(@RequestBody Pageable pageable) {
        Page<TicketDTO> pagination = ticketService.getPagination(pageable);
        return ResponseEntity.ok(pagination);
    }


}

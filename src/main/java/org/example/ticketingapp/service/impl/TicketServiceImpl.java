package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.TicketDTO;
import org.example.ticketingapp.entity.Ticket;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.TicketMapper;
import org.example.ticketingapp.repository.TicketRepository;
import org.example.ticketingapp.service.TicketService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Override
    public void createTicket(TicketDTO ticketDTO) {
        Ticket ticket = TicketMapper.mapToTicket(ticketDTO);
        ticketRepository.save(ticket);
    }

    @Override
    public TicketDTO getTicketByEventName(String eventName) {
        Ticket ticket = ticketRepository.findByEventName(eventName)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found under: " + eventName));
        return TicketMapper.mapToTicketDto(ticket);
    }
}

package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.dto.TicketDTO;
import org.example.ticketingapp.entity.Ticket;
import org.example.ticketingapp.entity.VendorEventConfig;
import org.example.ticketingapp.exception.ResourceCapacityException;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.TicketMapper;
import org.example.ticketingapp.repository.TicketRepository;
import org.example.ticketingapp.repository.VendorEventConfigRepository;
import org.example.ticketingapp.service.TicketService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private VendorEventConfigRepository vendorEventConfigRepository;

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

    @Override
    public TicketDTO decreaseTicket(TicketDTO ticketDTO, int ticketCount) {

        Ticket ticket = ticketRepository.findByEventName(ticketDTO.getEventName())
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found under: " + ticketDTO.getEventName()));

        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(ticketDTO.getEventName())
                .orElseThrow(() -> new ResourceNotFoundException("Vendor Event Config not found under: " + ticketDTO.getEventName()));

        if (ticket.getTotalTickets() < ticketCount) {
            throw new ResourceCapacityException("Not enough tickets available for: " + ticketDTO.getEventName());
        } else {
            vendorEventConfig.setTotalTickets(vendorEventConfig.getTotalTickets() - ticketCount);
            ticket.setTotalTickets(ticket.getTotalTickets() - ticketCount);

            vendorEventConfigRepository.save(vendorEventConfig);
            Ticket updatedTicket = ticketRepository.save(ticket);

            return TicketMapper.mapToTicketDto(updatedTicket);
        }

    }

//    @Override
//    public TicketDTO updateTicket(TicketDTO ticketDTO, int ticketCount) {
//        Ticket ticket = ticketRepository.findByEventName(ticketDTO.getEventName())
//                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found under: " + ticketDTO.getEventName()));
//
//        VendorEventConfig vendorEventConfig = vendorEventConfigRepository.findByEventName(ticketDTO.getEventName())
//                .orElseThrow(() -> new ResourceNotFoundException("Vendor Event Config not found under: " + ticketDTO.getEventName()));
//
//        if (vendorEventConfig.getMaxTicketCapacity() < ticketCount) {
//            throw new ResourceCapacityException("Too many tickets: " + ticketDTO.getEventName());
//        } else {
//            ticket.setTotalTickets(ticketCount);
//            Ticket updatedTicket = ticketRepository.save(ticket);
//            return TicketMapper.mapToTicketDto(updatedTicket);
//        }
//    }

    @Override
    public boolean existsByEventName(String eventName) {
        return ticketRepository.existsByEventName(eventName);
    }
}

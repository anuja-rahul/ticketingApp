package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.configuration.executor.PriorityTask;
import org.example.ticketingapp.dto.CustomerTicketDTO;
import org.example.ticketingapp.dto.CustomerTicketDtoOut;
import org.example.ticketingapp.entity.CustomerTicket;
import org.example.ticketingapp.entity.CustomerTicketID;
import org.example.ticketingapp.exception.ResourceNotFoundException;
import org.example.ticketingapp.mapper.CustomerTicketMapper;
import org.example.ticketingapp.repository.CustomerTicketRepository;
import org.example.ticketingapp.service.CustomerService;
import org.example.ticketingapp.service.CustomerTicketService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CustomerTicketServiceImpl implements CustomerTicketService {

    private final CustomerTicketRepository customerTicketRepository;
    private final Executor ticketExecutor;
    private CustomerService customerService;
    private final Lock lock = new ReentrantLock();

    @Async("customerExecutor")
    @Override
    public CompletableFuture<CustomerTicketDtoOut> createCustomerTicket(CustomerTicketDTO customerTicketDTO) {
        CustomerTicket customerTicket = CustomerTicketMapper.mapToCustomerTicket(customerTicketDTO);
        CustomerTicket savedCustomerTicket =  customerTicketRepository.save(customerTicket);
        CustomerTicketDtoOut result = CustomerTicketMapper.mapToCustomerTicketDtoOut(savedCustomerTicket);
        return CompletableFuture.completedFuture(result);
    }

    // TODO: Review this sh*t
    @Override
    public CustomerTicketDtoOut getCustomerTicketByCustomerTicketID(CustomerTicketID customerTicketID) {
        CustomerTicket customerTicket = customerTicketRepository.findById(customerTicketID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer ticket not found: " + customerTicketID));
        return CustomerTicketMapper.mapToCustomerTicketDtoOut(customerTicket);
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<List<CustomerTicketDtoOut>> getCustomerTicketsByEmail(String email) {
        List<CustomerTicket> customerTickets = customerTicketRepository.getCustomerTicketByCustomerEmail(email);
        List<CustomerTicketDtoOut> result =  customerTickets.stream()
                .map(CustomerTicketMapper::mapToCustomerTicketDtoOut)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(result);
    }

    @Override
    @Async("ticketExecutor")
    @Transactional
    public CompletableFuture<CustomerTicketDtoOut> updateCustomerTicket(
            CustomerTicketID customerTicketID,
            CustomerTicketDTO customerTicketDTO,
            int ticketRetrievalRate) {

        boolean priority = customerService.getCustomerPriority(customerTicketDTO.getCustomerEmail());

        if (priority) {
            int threadPriority = Thread.MAX_PRIORITY;
            Callable<CustomerTicketDtoOut> task = () -> updateTicket(customerTicketID, ticketRetrievalRate).get();
            PriorityTask<CustomerTicketDtoOut> priorityTask = new PriorityTask<>(threadPriority, task);

            ticketExecutor.execute(priorityTask);
            return priorityTask.getFuture();

        } else {
            int threadPriority = Thread.NORM_PRIORITY;
            Callable<CustomerTicketDtoOut> task = () -> updateTicket(customerTicketID, ticketRetrievalRate).get();
            PriorityTask<CustomerTicketDtoOut> normPriorityTask = new PriorityTask<>(threadPriority, task);
            ticketExecutor.execute(normPriorityTask);
            return normPriorityTask.getFuture();
        }
    }

@Transactional
public CompletableFuture<CustomerTicketDtoOut> updateTicket(CustomerTicketID customerTicketID, int ticketRetrievalRate) {
    lock.lock();
    try {
        CustomerTicket customerTicket = customerTicketRepository.findById(customerTicketID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer ticket not found: " + customerTicketID));

        String email = customerTicketID.getCustomerEmail();

        customerTicket.setTicketsBought(customerTicket.getTicketsBought() + ticketRetrievalRate);
        CustomerTicket updatedCustomerTicket = customerTicketRepository.save(customerTicket);
        CustomerTicketDtoOut result = CustomerTicketMapper.mapToCustomerTicketDtoOut(updatedCustomerTicket);

        // Check/set for VIP eligibility of the customer based on his purchases
        if (customerTicketRepository
                .findTotalTicketsBoughtByCustomerEmail(email) >= 100 && !customerService.getCustomerPriority(email))
        {
            customerService.updateCustomerPriority(email);
        }
        return CompletableFuture.completedFuture(result);

    } finally {
        lock.unlock();
    }
}

    @Override
    public boolean existsById(CustomerTicketID customerTicketID) {
        return customerTicketRepository.existsById(customerTicketID);
    }
}

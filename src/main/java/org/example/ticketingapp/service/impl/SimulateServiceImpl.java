package org.example.ticketingapp.service.impl;

import lombok.AllArgsConstructor;
import org.example.ticketingapp.service.SimulateService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimulateServiceImpl implements SimulateService {

    @Override
    public boolean simulate(int userCount) {
        System.out.println("This is from service layer");
        System.out.println("Simulating " + userCount + " users\n");

        return true;
    }
}

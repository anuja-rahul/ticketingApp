package org.example.ticketingapp.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface SimulateService {
    boolean simulate(int userCount) throws IOException, ExecutionException, InterruptedException;

    // validate
    boolean checkUserExistence(String userName);
    String getToken(String credentials);
    boolean checkEventExistence(String eventName);


    // create
    String createVendor(String credentials);
    String createCustomer(String credentials);
    void createEvent(String vendorEmail, String eventName) throws IOException, ExecutionException, InterruptedException;
    void addTickets(String eventName) throws IOException, ExecutionException, InterruptedException;
}

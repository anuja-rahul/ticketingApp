package org.example.ticketingapp.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface SimulateService {
    boolean simulate(int userCount, int rate, int cycles) throws IOException, ExecutionException, InterruptedException;

    // validate
    boolean checkUserExistence(String userName);
    String getToken(String credentials);
    boolean checkEventExistence(String eventName);


    // create
    String createVendor(String credentials);
    String createCustomer(String credentials);
    void createEvent(String vendorEmail, String eventName) throws IOException, ExecutionException, InterruptedException;

    // producer consumer pattern
    void addTickets(String eventName, int rate, int cycles) throws IOException, ExecutionException, InterruptedException;
    void buyTickets(String eventName, String email, int rate) throws IOException, ExecutionException, InterruptedException;

    // run everything
    void runSimulation(int rate, int cycles) throws IOException, ExecutionException, InterruptedException;
}

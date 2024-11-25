package org.example.ticketingapp.utility;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseUtils {

    /**
     * Divides two numbers and returns the whole number result,
     * rounding up if there's any decimal value.
     *
     * @param customerRetrievalRate The number to be divided.
     * @param ticketReleaseRate The number to divide by.
     * @return The whole number result of the division, rounded up.
     * @throws ArithmeticException if the divisor is zero.
     * (Never throws this as the divisor comes validated never to be zero)
     */
    public static int divideAndCeil(int ticketReleaseRate, int customerRetrievalRate) {
        if (customerRetrievalRate == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        int result = ticketReleaseRate / customerRetrievalRate;
        if (ticketReleaseRate % customerRetrievalRate != 0) {
            result += 1;
        }
        return result;
    }

    /**
     * Returns formatted datetime by the minute,
     *
     * @return String representation of a formatted datetime stamp.
     */
    public static String getFormattedTimeByMinutes() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        return now.format(formatter);
    }
}

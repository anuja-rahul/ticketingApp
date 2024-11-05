package org.example.ticketingapp.utility;


public class BaseUtils {

    /**
     * Divides two numbers and returns the whole number result,
     * rounding up if there's any decimal value.
     *
     * @param customerRetrievalRate The number to be divided.
     * @param ticketReleaseRate The number to divide by.
     * @return The whole number result of the division, rounded up.
     * @throws ArithmeticException if the divisor is zero.
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
}

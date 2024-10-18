package org.example.ticketingapp.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @After("@annotation(Logger) || @annotation(MethodLogger)")
    @After("@annotation(MethodLogger)")
    public void logMethodExecution(JoinPoint joinPoint) {

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String logFileName = "ticketingapp-" + currentDate + ".log";

        String logMessage = String.format("Class: [%s], Method: [%s] executed at %s", className, methodName, timestamp);

        logger.info(logMessage);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true))) {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            logger.error("Failed to write log to file", e);
        }
    }
}

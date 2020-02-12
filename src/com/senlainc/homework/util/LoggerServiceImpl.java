package com.senlainc.homework.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerServiceImpl implements LoggerService, Serializable {

    private final String FILE_PATH = "logs/log.txt";

    @Override
    public void info(Object obj, String message) {
        message = "[INFO] " + message;
        writeToLogFile(obj, message);
    }

    @Override
    public void error(Object obj, String message) {
        message = "[ERROR] " + message;
        writeToLogFile(obj, message);
    }

    @Override
    public void warning(Object obj, String message) {
        message = "[WARN] " + message;
        writeToLogFile(obj, message);
    }

    @Override
    public void debug(Object obj, String message) {
        message = "[DEBUG] " + message;
        writeToLogFile(obj, message);
    }

    private void writeToLogFile(Object obj, String message) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            out.write(dateTime.format(formatter)
                    + " " + obj.getClass().getName() + " - " + message + '\n');
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }


}

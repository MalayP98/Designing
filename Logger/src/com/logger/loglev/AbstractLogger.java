package com.logger.loglev;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.logger.LogLevel;

public abstract class AbstractLogger {

    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    protected final String RED = "\u001B[31m";

    protected final String GREEN = "\u001B[32m";

    protected final String YELLOW = "\u001B[33m";

    protected static final String ANSI_RESET = "\u001B[0m";

    private LogLevel logLevel;

    private AbstractLogger nextLogger;

    protected AbstractLogger(LogLevel logLevel, AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
        this.logLevel = logLevel;
    }

    public void log(LogLevel logLevel, String msg, Class<?> clazz) {
        if (logLevel.equals(this.logLevel)) {
            print(msg, clazz);
            return;
        }
        nextLogger.log(logLevel, msg, clazz);
    }

    public void printDateAndTime() {
        System.out.print(DTF.format(LocalDateTime.now()) + " ");
    }

    public abstract void print(String msg, Class<?> clazz);

}

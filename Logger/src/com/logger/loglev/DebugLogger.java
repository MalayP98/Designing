package com.logger.loglev;

import com.logger.LogLevel;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(AbstractLogger nextLogger) {
        super(LogLevel.DEBUG, nextLogger);
    }

    @Override
    public void print(String msg, Class<?> clazz) {
        printDateAndTime();
        System.out.println(YELLOW + LogLevel.DEBUG.toString() + ANSI_RESET + " " + clazz.getName()
                + ": " + msg);
    }
}

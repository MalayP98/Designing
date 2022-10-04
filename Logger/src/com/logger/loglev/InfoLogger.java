package com.logger.loglev;

import com.logger.LogLevel;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(AbstractLogger nextLogger) {
        super(LogLevel.INFO, nextLogger);
    }

    @Override
    public void print(String msg, Class<?> clazz) {
        printDateAndTime();
        System.out.println(
                GREEN + LogLevel.INFO.toString() + ANSI_RESET + " " + clazz.getName() + ": " + msg);
    }
}

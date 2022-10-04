package com.logger.loglev;

import com.logger.LogLevel;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(AbstractLogger nextLogger) {
        super(LogLevel.ERROR, nextLogger);
    }

    @Override
    public void print(String msg, Class<?> clazz) {
        printDateAndTime();
        System.out.println(
                RED + LogLevel.ERROR.toString() + ANSI_RESET + " " + clazz.getName() + ": " + msg);
    }
}

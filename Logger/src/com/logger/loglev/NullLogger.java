package com.logger.loglev;

import com.logger.LogLevel;

public class NullLogger extends AbstractLogger {

    public NullLogger() {
        super(LogLevel.NULL, null);
    }

    @Override
    public void print(String msg, Class<?> clazz) {
        return;
    }
}

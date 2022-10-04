package com.logger;

import com.logger.loglev.AbstractLogger;
import com.logger.loglev.DebugLogger;
import com.logger.loglev.ErrorLogger;
import com.logger.loglev.InfoLogger;
import com.logger.loglev.NullLogger;

public class Logger {

    private Class<?> clazz;

    private AbstractLogger logger;

    private Logger(Class<?> clazz) {
        this.clazz = clazz;
        logger = new InfoLogger(new ErrorLogger(new DebugLogger(new NullLogger())));
    }

    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }

    public void log(String level, String msg) {
        switch (level) {
            case "INFO":
                logger.log(LogLevel.INFO, msg, clazz);
                break;
            case "ERROR":
                logger.log(LogLevel.ERROR, msg, clazz);
                break;
            case "DEBUG":
                logger.log(LogLevel.DEBUG, msg, clazz);
                break;
            default:
                logger.log(LogLevel.NULL, msg, clazz);
        }
    }
}

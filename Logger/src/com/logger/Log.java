package com.logger;

public class Log {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getLogger(Log.class);
        logger.log("INFO", "This is a info log.");
        logger.log("ERROR", "This is a error log.");
        logger.log("DEBUG", "This is a debug log.");
        logger.log("RANDOM", "This log won't print.");
    }
}

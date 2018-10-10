package com.kodilla.patterns.singleton;

import java.util.logging.Level;

public class Logger {
    private java.util.logging.Logger javaLogger =
            java.util.logging.Logger.getLogger(java.util.logging.Logger.class.getName());
    private static Logger logger = null;
    private String lastLog = "";

    private Logger() {

    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void log(String log) {
        lastLog = log;
        javaLogger.log(Level.INFO, log);
    }

    public String getLastLog() {
        return lastLog;
    }
}

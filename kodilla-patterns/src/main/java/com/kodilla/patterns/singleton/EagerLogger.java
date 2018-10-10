package com.kodilla.patterns.singleton;

import java.util.logging.Level;

public class EagerLogger {
    private java.util.logging.Logger javaLogger =
            java.util.logging.Logger.getLogger(java.util.logging.Logger.class.getName());
    private static EagerLogger logger;
    private String lastLog = "";

    private EagerLogger() {

    }

    static {
        try {
            logger = new EagerLogger();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EagerLogger getInstance() {
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


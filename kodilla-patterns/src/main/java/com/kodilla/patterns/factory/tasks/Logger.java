package com.kodilla.patterns.factory.tasks;

import java.util.logging.Level;

public final class Logger {
    private static final java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(java.util.logging.Logger.class.getName());
    private static Logger ourInstance = new Logger();

    public static Logger getInstance() {
        return ourInstance;
    }

    private Logger() {
    }

    public void logInfo(String info){
        log.log(Level.INFO, info);
    }

    public void logError(String error){
        log.log(Level.WARNING, error);
    }
}

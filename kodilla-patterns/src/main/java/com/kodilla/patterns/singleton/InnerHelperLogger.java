package com.kodilla.patterns.singleton;

import java.util.logging.Level;

public class InnerHelperLogger {
    private java.util.logging.Logger javaLogger =
        java.util.logging.Logger.getLogger(java.util.logging.Logger.class.getName());
    private static InnerHelperLogger logger = null;
    private String lastLog = "";

    private InnerHelperLogger() {

    }

    private static class InnerHelper{
        private static final InnerHelperLogger LOGGER_INSTANCE = new InnerHelperLogger();
    }

    public static InnerHelperLogger getInstance() {
        return InnerHelper.LOGGER_INSTANCE;
    }

    public void log(String log) {
        lastLog = log;
        javaLogger.log(Level.INFO, log);
    }

    public String getLastLog() {
        return lastLog;
    }
}

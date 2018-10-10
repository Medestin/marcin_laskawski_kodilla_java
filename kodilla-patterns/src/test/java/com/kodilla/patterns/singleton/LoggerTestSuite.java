package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeClass
    public static void initLogger(){
        logger = Logger.getInstance();
    }

    @Test
    public void testGetLastLog(){
        logger.log("Log number 1");
        logger.log("Log number 2");
        logger.log("Log number 3");
        logger.log("Log number 4");

        String lastLog = logger.getLastLog();
        Assert.assertEquals("Log number 4", lastLog);
    }
}

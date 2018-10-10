package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    private static Logger logger;
    private static EagerLogger eagerLogger;
    private static InnerHelperLogger innerHelperLogger;

    @BeforeClass
    public static void initLogger(){
        logger = Logger.getInstance();
        eagerLogger = EagerLogger.getInstance();
        innerHelperLogger = InnerHelperLogger.getInstance();
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

    @Test
    public void testEagerGetLastLog(){
        eagerLogger.log("Log number 5");
        eagerLogger.log("Log number 6");
        eagerLogger.log("Log number 7");
        eagerLogger.log("Log number 8");

        String lastLog = eagerLogger.getLastLog();
        Assert.assertEquals("Log number 8", lastLog);
    }

    @Test
    public void testInnerGetLastLog(){
        innerHelperLogger.log("Log number 9");
        innerHelperLogger.log("Log number 10");
        innerHelperLogger.log("Log number 11");
        innerHelperLogger.log("Log number 12");

        String lastLog = innerHelperLogger.getLastLog();
        Assert.assertEquals("Log number 12", lastLog);
    }
}

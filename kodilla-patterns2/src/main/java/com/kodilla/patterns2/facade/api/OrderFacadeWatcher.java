package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId)")
    public void logEvent(OrderDto orderDto, Long userId){
        LOGGER.info("Begin processing order for userId: " + userId);
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result;
        Long begin = System.currentTimeMillis();
        try{
            result = proceedingJoinPoint.proceed();
            Long end = System.currentTimeMillis();

            LOGGER.info("Processing order took: " + (end - begin) + "ms.");
        }catch (Throwable t){
            LOGGER.error(t.getMessage());
            Long end = System.currentTimeMillis();

            LOGGER.info("Processing order took: " + (end - begin) + "ms.");
            throw t;
        }
        return result;
    }
}

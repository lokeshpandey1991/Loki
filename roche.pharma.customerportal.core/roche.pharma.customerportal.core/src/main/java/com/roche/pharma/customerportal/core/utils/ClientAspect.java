package com.roche.pharma.customerportal.core.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ClientAspect {
    
    /**
     * Logger for this class
     */
    private static final Logger LOG = LoggerFactory.getLogger(ClientAspect.class);
    
    @After(value = "anyCallMethod()")
    public void after(JoinPoint joinPoint) {
        LOG.info("After, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", method: "
                + joinPoint.getSignature().getName());
    }

    /** To be changed afterwards for all methods under services */
    @Pointcut("execution(* com.roche.pharma.customerportal.core.models.BasePageModel.getDefaultPersonaTag(..))")
    void anyCallMethod() {}

    @Before(value = "anyCallMethod()")
    public void befor(JoinPoint joinPoint) {
        LOG.info("Before, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", method: "
                + joinPoint.getSignature().getName());
    }
}

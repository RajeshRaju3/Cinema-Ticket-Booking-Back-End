package com.mph.logging;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Enumeration;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Aspect
@Component
public class LoggingAspect {
	Logger log = LogManager.getLogger(this.getClass());
	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller()
	{
		
	}
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }
    
    @Pointcut("execution(* .(..))")
    protected void allMethod() {
    }
 
    @Pointcut("execution(public * *(..))")
    protected void loggingPublicOperation() {
    }
 
    @Pointcut("execution(* .(..))")
    protected void loggingAllOperation() {
    }
 
    @Pointcut("within(com.mph.logging..*)")
    private void logAnyFunctionWithinResource() {
    }
 
   
    @Before("controller() && allMethod() && restController() && args(..,request)")
    public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {
 
        log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
        log.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        log.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
        log.debug("Target class : " + joinPoint.getTarget().getClass().getName());
 
        if (null != request) {
            log.debug("Start Header Section of request ");
            log.debug("Method Type : " + request.getMethod());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = (String) headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                log.debug("Header Name: " + headerName + " Header Value : " + headerValue);
            }
            log.debug("Request Path info :" + request.getServletPath());
            log.debug("End Header Section of request ");
        }
    }
    @AfterReturning(pointcut = "controller() && allMethod() && restController()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        String returnValue = this.getValue(result);
        log.debug("Method Return value : " + returnValue);
    }
    @AfterThrowing(pointcut = "controller() && allMethod() && restController()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
        log.error("Cause : " +  exception.getCause());
    }
    @Around("controller() && allMethod() && restController()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
         
        long start = System.currentTimeMillis();
        try {
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            log.debug("Method " + className + "." + methodName + " ()" + " execution time : "
                    + elapsedTime + " ms");         
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }
  private String getValue(Object result) {
        String returnValue = null;
        if (null != result) {
            if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
                returnValue = ReflectionToStringBuilder.toString(result);
            } else {
                returnValue = result.toString();
            }
        }
        return returnValue;
    }
}
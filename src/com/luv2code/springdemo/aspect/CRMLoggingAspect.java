package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.xml.internal.bind.XmlAccessorFactory;



@Aspect
@Component
public class CRMLoggingAspect {
	
	//SETUP LOGGER
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {	
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {	
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {	
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	//add @Before
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method calling
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>> in @Before: calling :"+ theMethod);
		
		//display the arguments
		
		//get the argument
		Object[] args =theJoinPoint.getArgs();
		
		//loop thru and display
		for (Object tempArgs : args) {
			myLogger.info("===>>>argument : "+tempArgs);
		}
	}
	
	//add @AfterReturning
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display method we are returning
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>> in @AfterReturning: calling :"+ theMethod);
		
		//display data returned
		myLogger.info("+++>>>result : "+theResult);
	}
	
}

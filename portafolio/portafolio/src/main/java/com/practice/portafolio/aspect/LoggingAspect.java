package com.practice.portafolio.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger; // where is logback?
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // Indica que es un aspecto
@Component //Es para ser reconocido en el contexto
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.practice.portafolio.service.*.*(..))") //PointCut
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable { // 🔹 Nos da control sobre la ejecución del método interceptado.
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        logger.info("AOP - TESTING PURPOSES - Método: {} executed in {} ms", joinPoint.getSignature(), executionTime);
        return result;
    }
}

package io.github.arnabmaji19.crmsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("io.github.arnabmaji19.crmsystem.aspect.AOPDeclarations.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        /*
         * Add logging before calling a method
         */

        var method = joinPoint.getSignature().toShortString();
        logger.info("Calling method: " + method);
    }

    @AfterReturning(
            pointcut = "io.github.arnabmaji19.crmsystem.aspect.AOPDeclarations.forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        /*
         * Add logging after returning from a method
         */

        var method = joinPoint.getSignature().toShortString();
        logger.info("Returning from: " + method);
    }

}

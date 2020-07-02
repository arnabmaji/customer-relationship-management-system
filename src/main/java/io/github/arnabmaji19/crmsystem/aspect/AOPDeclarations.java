package io.github.arnabmaji19.crmsystem.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPDeclarations {

    @Pointcut("execution(* io.github.arnabmaji19.crmsystem.controller.*.*(..))")
    public void forControllerPackage() {
    }

    @Pointcut("execution(* io.github.arnabmaji19.crmsystem.service.*.*(..))")
    public void forServicePackage() {
    }

    @Pointcut("execution(* io.github.arnabmaji19.crmsystem.dao.*.*(..))")
    public void forDAOPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    public void forAppFlow() {
    }

}

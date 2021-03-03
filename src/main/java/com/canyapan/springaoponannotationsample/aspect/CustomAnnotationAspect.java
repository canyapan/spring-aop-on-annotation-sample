package com.canyapan.springaoponannotationsample.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class CustomAnnotationAspect {

    @Around("@annotation(com.canyapan.springaoponannotationsample.annotation.CustomAnnotation)")
    public void executionLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        final Instant start = Instant.now();

        joinPoint.proceed();

        log.info("Method with the CustomAnnotation executed! took: {}", Duration.between(start, Instant.now()));
    }

}

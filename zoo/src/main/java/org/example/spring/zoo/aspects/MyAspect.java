package org.example.spring.zoo.aspects;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@RequiredArgsConstructor
public class MyAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Pointcut — это срез, запрос точек присоединения
    @Pointcut("execution(public * org.example.spring.zoo.controller.ControllerJson.*(..))")
    public void callAtMyServicePublic() {
    }

    @Pointcut("@annotation(org.example.spring.zoo.aspects.AspectAnnotation)")
    public void callAtMyServiceAnnotation() {
    }

    @Around("callAtMyServicePublic()")
    public Object aroundCallAt(ProceedingJoinPoint call) throws Throwable {
        StopWatch clock = new StopWatch(call.toString());
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            logger.info("clock: " + clock.prettyPrint());
        }
    }

    @Before("callAtMyServiceAnnotation()")
    public void beforeCallAt(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("before " + jp + ", args=[" + args + "]");
    }

    //Advice — набор инструкций выполняемых на точках среза (Pointcut).
    // Инструкции можно выполнять по событию разных типов:
    //Before — перед вызовом метода
    //After — после вызова метода
    //After returning — после возврата значения из функции
    //After throwing — в случае exception
    //After finally — в случае выполнения блока finally
    //Around — можно сделать пред., пост., обработку перед вызовом метода,
    // а также вообще обойти вызов метода.

    //JoinPoint это не обязательный параметр который,
    // предоставляет дополнительную информацию, но если он используется,
    // то он должен быть первым.
    @Before("callAtMyServicePublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        logger.info("before " + jp + ", args=[" + args + "]");
    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }


}
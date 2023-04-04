package day2.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
    @Pointcut("execution(* day2..*Impl.*(..))")
    public void allPointcut(){}

    @Around("allPointcut()")
    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
        String method = pjp.getSignature().getName();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object obj = pjp.proceed();
        stopWatch.stop();
        System.out.println(method + "() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
//        System.out.println("[Before]: 비즈니스 메소드 수행 전에 처리할 내용..");
//        Object returnObj = pjp.proceed();
//        System.out.println("[After]: 비즈니스 메소드 수행 후에 처리할 내용..");
        return obj;
    }
}
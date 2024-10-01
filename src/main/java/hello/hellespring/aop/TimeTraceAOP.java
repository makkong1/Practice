package hello.hellespring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAOP {

    @Around("execution(* hello.hellespring..*(..)) && !target(hello.hellespring.SpringConfig)" )
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Start: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("time: " + elapsedTime + " ms");
            System.out.println("Start: " + joinPoint.toString() + " " + elapsedTime + " ms");
        }

    }
}

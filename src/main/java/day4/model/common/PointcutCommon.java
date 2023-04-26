package day4.model.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {

    @Pointcut("execution(* day2..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* day2..*Impl.get*(..))")
    public void getPointcut() {
    }
}

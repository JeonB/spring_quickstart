package day4.model.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {

    @Pointcut("execution(* day4..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* day4..*Impl.get*(..))")
    public void getPointcut() {
    }
}

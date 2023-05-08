package day4.model.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {

    @Pointcut("execution(* day4..*Impl.*(..))")
    public void allPointcut() {
        System.out.println("모든 Impl클래스 공통 관심사 메소드 포인트컷");
    }

    @Pointcut("execution(* day4..*Impl.get*(..))")
    public void getPointcut() {
    }
}

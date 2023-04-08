package day3.view.common;//package day2.common;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Service;
//
//@Service
//@Aspect // Aspect == Pointcut + Advice
//public class LogAdvice {
//	@Pointcut("execution(* day2..*Impl.*(..))")
//	public void allPointcut(){} //bean등록한 포인트컷의 id처럼 속빈 강정인 참조 메소드를 이용
//
//	@Before("allPointcut()")
//	public void printLog(){
//		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
//	}
//
//	@Pointcut("execution(* day2..*Impl.get*(..))")
//	public void getPointcut(){}
//
////	public void printLog(JoinPoint jp) {
////		System.out.println("[공통 로그] 비즈니스 수행 전 동작");	}
//}

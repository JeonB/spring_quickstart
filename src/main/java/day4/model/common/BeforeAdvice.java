package day4.model.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

    @Before("day4.model.common.PointcutCommon.allPointcut()")
    public void beforeLog(JoinPoint jp){
        String method = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        System.out.println("[사전 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());

    }

/*    public void beforeLog(JoinPoint jp){ // JoinPoint는 클라이언트가 호출하는 모든 비즈니스 메소드
        String method = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("[사전 처리]" + method +"() 메소드 ARGS 정보: " + args[0].toString());
    }

 */
}

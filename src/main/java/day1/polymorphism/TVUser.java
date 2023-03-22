package day1.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
//        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); //컨테이너 생성 및 bean 객체 생성
//        TV tv = (TV) factory.getBean("tv");
//        TV tv2 = (TV) factory.getBean("tv2");
//        TV tv3 = (TV) factory.getBean("tv3");
        /*tv3.turnOn();;
        tv3.soundUp();
        tv3.soundDown();
        tv3.turnOff();*/
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
        TV tv = (TV) factory.getBean("lgTV");
        tv.soundUp();
        tv.soundDown();


        factory.close();
    }
}

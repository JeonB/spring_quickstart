package day1.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {

        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext_day1.xml");
        TV tv = (TV) factory.getBean("appTv");
        TV tv2 = (TV) factory.getBean("tv2");
        TV tv3 = (TV) factory.getBean("LgTV");

        tv.soundUp();
        tv.soundDown();

        tv2.soundUp();
        tv2.soundDown();

        tv3.soundUp();
        tv3.soundDown();

        factory.close();
    }
}

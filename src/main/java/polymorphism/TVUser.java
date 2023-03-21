package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
        TV tv = (TV) factory.getBean("tv");
        TV tv2 = (TV) factory.getBean("tv");
        TV tv3              = (TV) factory.getBean("tv");
        tv.turnOn();;
        tv.soundUp();
        tv.soundDown();
        tv.turnOff();

        factory.close();
    }
}

package day1.ioc_injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class CollectionBeanClient {

    public static void main(String[] args) {
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("applicationContext_day1.xml");
        CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
        List<String> addressList = bean.getAddressList();
        for (String address : addressList) {
            System.out.println(address.toString());
        }
        factory.close();
    }
}

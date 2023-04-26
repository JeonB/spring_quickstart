package day2.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext(
                "applicationContext_day2.xml");

        UserService userService = (UserService) container.getBean("userService");

        UserVO vo = new UserVO();
        vo.setId("test");
        vo.setPassword("1234");
        UserVO user = userService.getUser(vo);
        if (user != null) {
            System.out.println(user.getName() + "님 환영합니다. 직책: " + user.getRole());
        } else {
            System.out.println("로그인 실패");
        }

        container.close();
    }
}

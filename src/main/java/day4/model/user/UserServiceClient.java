package day4.model.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class UserServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext(
                "applicationContext_day4.xml");

        UserService userService = (UserService) container.getBean("userService");

        UserVO vo = new UserVO();
        vo.setId("ende");
        vo.setPassword("12345");
        vo.setName("jeo");
        vo.setRole("roto1");

        userService.insertUser(vo);

        List<UserVO> userList = userService.getUserList();
        for (UserVO userlist : userList) {
            System.out.println("-->" + userlist.toString());
        }
/*
        vo.setId("test");
        vo.setPassword("1234");
        UserVO user = userService.getUser(vo);
        if (user != null) {
            System.out.println(user.getName() + "님 환영합니다. 직책: " + user.getRole() );
        }
        else {
            System.out.println("로그인 실패");
        }
*/

        container.close();
    }
}

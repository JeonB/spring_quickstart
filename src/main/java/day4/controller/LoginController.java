package day4.controller;


import day4.model.user.UserVO;
import day4.model.user.impl.UserDAO;
import day4.model.user.impl.UserDAOSpring;
import day4.model.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(UserVO vo) {
        System.out.println("로그인 화면 이동");
        vo.setId("test");
        vo.setPassword("1234");
        return "login";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(UserVO vo, HttpSession session) {
        System.out.println("로그인 인증 처리");

        if(vo.getId() == null || vo.getId().equals("")){
            throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
        }
        UserVO user = userService.getUser(vo);
        if (user != null) {
            session.setAttribute("userName", user.getName());
            return "redirect:getBoardList.do";
        } else {
            return "login";
        }
    }
}

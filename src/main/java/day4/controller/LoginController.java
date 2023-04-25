package day4.controller;


import day4.model.user.UserVO;
import day4.model.user.impl.UserDAO;
import day4.model.user.impl.UserDAOSpring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController{
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(UserVO vo) {
        System.out.println("로그인 화면 이동");
        vo.setId("test");
        vo.setPassword("1234");
        return "login";
    }
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
        System.out.println("로그인 인증 처리");
        UserVO user = userDAO.getUser(vo);
        if(user!=null){
            session.setAttribute("userName",user.getName());
            return "redirect:getBoardList.do";
        }
        else return "login";
    }
}

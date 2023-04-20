package day4.controller;


import day4.model.user.UserVO;
import day4.model.user.impl.UserDAO;
import day4.model.user.impl.UserDAOSpring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class LoginController implements Controller {
    @Override
    @GetMapping("/login.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.printf("로그인 처리");

        // 1. 사용자 입력 정보 추출
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 2. DB 연동 처리
        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPassword(password);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(vo);

        // 3. 화면 네비게이션
        ModelAndView mav = new ModelAndView();
        if(user != null){
            mav.setViewName("redirect:getBoardList.do");
        }
        else {
            mav.setViewName("login");
        }
        return mav;
    }
}

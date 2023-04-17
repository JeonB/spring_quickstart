package day4.controller;


import day4.model.user.UserVO;
import day4.model.user.impl.UserDAO;
import day4.model.user.impl.UserDAOSpring;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.printf("로그인 처리");

        // 1. 사용자 입력 정보 추출
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 2. DB 연동 처리
        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPassword(password);

        UserDAOSpring userDAO = new UserDAOSpring();
        UserVO user = userDAO.getUser(vo);

        // 3. 화면 네비게이션
        ModelAndView mav = new ModelAndView();
        if(user != null){
            mav.setViewName("getBoardList.do");
        }
        else {
            mav.setViewName("WEB-INF/views/login.jsp");
        }
        return mav;
    }
}

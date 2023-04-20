package day4.controller;


import day4.model.board.BoardVO;
import day4.model.board.impl.BoardDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class InsertBoardController implements Controller {
    @Override
    @GetMapping("/insertBoard.do")
    @PostMapping("/insertBoard.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 등록 처리");

        // 1. 사용자 입력 정보 추출
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setWriter(writer);
        vo.setContent(content);
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insertBoard(vo);

        // 3. 화면 네비게이션
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:getBoardList.do");
        return mav;
    }
}

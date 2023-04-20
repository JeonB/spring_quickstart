package day4.controller;



import day4.model.board.BoardVO;
import day4.model.board.impl.BoardDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class GetBoardController implements Controller {
    @Override
    @GetMapping("/getBoard.do")
    @PostMapping("/getBoard.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 상세 조회 처리");
        // 1. 검색할 게시글 번호 추출
        String seq = request.getParameter("seq");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));
        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(vo);

        // 3. 검색 결과를 ModelAndView에 저장하고 리턴
        ModelAndView mav = new ModelAndView();
        mav.addObject("board", board); //Model 정보 저장
        mav.setViewName("getBoard");           // View 정보 저장
        return mav;
    }
}

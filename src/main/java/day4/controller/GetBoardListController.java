package day4.controller;


import day4.model.board.BoardVO;
import day4.model.board.impl.BoardDAO;
import day4.model.board.impl.BoardDAOSpring;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/getBoardList.do")
public class GetBoardListController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 목록 검색 처리");
        // 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(vo);

        // 3. 검색 결과를 ModelAndView에 저장하여 리턴
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardList", boardList); // Model 정보 저장
        mav.setViewName("getBoardList"); // view 정보 저장
        return mav;
    }
}

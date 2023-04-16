package day4.controller;

import day3.controller.Controller;
import day3.view.board.BoardVO;
import day3.view.board.impl.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetBoardListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 목록 검색 처리");
        // 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(vo);

        // 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동
        HttpSession session =request.getSession();
        session.setAttribute("boardList", boardList);
        return "getBoardList";
    }
}

package day3.controller;

import day3.view.board.BoardVO;
import day3.view.board.impl.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetBoardController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 상세 조회 처리");
        // 1. 검색할 게시글 번호 추출
        String seq = request.getParameter("seq");

        // 2. DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));
        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(vo);

        // 3. 검색 결과를 세션에 저장하고 상세 화면으로 이동
        HttpSession session =request.getSession();
        session.setAttribute("board",board);
        return "getBoard";
    }
}

<%@page import="day3.view.board.impl.BoardDAO" %>
<%@page import="day3.view.board.BoardVO" %>
<%@page contentType="text/html; charset=EUC-KR" %>

<%
    // 1. 사용자 입력 정보 추출
    request.setCharacterEncoding("EUC-KR");
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
    response.sendRedirect("getBoardList");
%>
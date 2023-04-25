package day4.controller;

import day4.model.board.BoardVO;
import day4.model.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }
    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAO boardDAO) {//spring컨테이너가 매개변수의 객체를 자동 생성하여 전달해줌
        System.out.println("글 등록 처리");
        boardDAO.insertBoard(vo);
        return "insertBoard";
    }
    @RequestMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 수정 처리");
        boardDAO.updateBoard(vo);

        return "redirect:getBoardList.do";
    }
    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 삭제 처리");
        boardDAO.deleteBoard(vo);

        return "redirect:getBoardList.do";
    }
    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
        System.out.println("글 상세 조회 처리");

        model.addAttribute("board", boardDAO.getBoard(vo)); //Model 정보 저장
        return "getBoard";
    }
    @RequestMapping("/getBoardList.do")
    public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
        System.out.println("글 목록 검색 처리");
        model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
        return "getBoardList"; // view 정보 저장
    }
}

package day4.controller;

import day4.model.board.BoardVO;
import day4.model.board.impl.BoardDAO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("board")
public class BoardController {
    //검색 조건 목록 설정, @RequestParam대신 사용
    @ModelAttribute("conditonMap")
    public Map<String,String> searchConditionMap(){
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("제목", "TITLE");
        conditionMap.put("내용", "CONTENT");
        return conditionMap;
    }

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAO boardDAO) {//spring컨테이너가 매개변수의 객체를 자동 생성하여 전달해줌
        System.out.println("글 등록 처리");
        boardDAO.insertBoard(vo);
        return "insertBoard";
    }

    @RequestMapping("/updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
        System.out.println("번호 : " + vo.getSeq());
        System.out.println("제목 : " + vo.getTitle());
        System.out.println("작성자 : " + vo.getWriter());
        System.out.println("내용 : " + vo.getContent());
        System.out.println("등록일 : " + vo.getRegDate());
        System.out.println("조회수 : " + vo.getCnt());
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
    public String getBoardList(@RequestParam(value = "searchCondition",defaultValue = "TITLE", required = false)String condtion,@RequestParam(value = "searchKeyword",defaultValue = "",required = false)String keyword, BoardDAO boardDAO, Model model,BoardVO vo) {
//        System.out.println("글 목록 검색 처리");
        System.out.println("검색 조건 : " + condtion);
        System.out.println("검색 단어 : " + keyword);
        model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
        return "getBoardList"; // view 이름 리턴
    }
}

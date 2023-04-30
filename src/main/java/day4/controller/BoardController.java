package day4.controller;

import day4.model.board.BoardService;
import day4.model.board.BoardVO;
import day4.model.board.impl.BoardDAO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

//기존 컨트롤러는 직접 DAD 객체를 이용하는 문제 있음. 유지보수가 어려움
@Controller
@SessionAttributes("board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }
    
    //BoardDAO 객체를 직접 참조하는 기존 코드 수정
    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo) throws IOException {//spring컨테이너가 매개변수의 객체를 자동 생성하여 전달해줌
        //파일 업로드 처리
        MultipartFile uploadFile = vo.getUploadFile();
        if(!uploadFile.isEmpty()){
            String fileName = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("D:/" + fileName));
        }

        System.out.println("글 등록 처리");
        if(vo.getWriter() != null || vo.getTitle() != null || vo.getContent() != null)
            boardService.insertBoard(vo);
        return "getBoardList";
    }

    @RequestMapping("/updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO vo) {
        System.out.println("번호 : " + vo.getSeq());
        System.out.println("제목 : " + vo.getTitle());
        System.out.println("작성자 : " + vo.getWriter());
        System.out.println("내용 : " + vo.getContent());
        System.out.println("등록일 : " + vo.getRegDate());
        System.out.println("조회수 : " + vo.getCnt());
        boardService.updateBoard(vo);

        return "redirect:getBoardList.do";
    }

    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo) {
        System.out.println("글 삭제 처리");
        boardService.deleteBoard(vo);

        return "redirect:getBoardList.do";
    }

    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, Model model) {
        System.out.println("글 상세 조회 처리");

        model.addAttribute("board", boardService.getBoard(vo)); //Model 정보 저장
        return "getBoard";
    }

    //검색 조건 목록 설정, @RequestParam대신 사용
    @ModelAttribute("conditonMap")
    public Map<String,String> searchConditionMap(){
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("제목", "TITLE");
        conditionMap.put("내용", "CONTENT");
        return conditionMap;
    }
    @RequestMapping("/getBoardList.do")
    public String getBoardList(Model model,BoardVO vo) {
        System.out.println("글 목록 검색 처리");
        if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
        if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
        model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
        return "getBoardList"; // view 이름 리턴
    }
}

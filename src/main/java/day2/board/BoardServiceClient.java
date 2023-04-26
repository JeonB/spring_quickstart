package day2.board;

import day2.common.aoptest.AopTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext(
                "applicationContext_day2.xml");

        BoardService boardService = (BoardService) container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setSeq(100);
        vo.setTitle("임시 제목");
        vo.setWriter("홍길동");
        vo.setContent("springjdbc,.,,,,,,,,,,");
        boardService.insertBoard(vo);

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO board : boardList) {
            System.out.println("--> " + board.toString());
        }
        AopTest test = new AopTest();
        test.testMethod();

        container.close();
    }
}

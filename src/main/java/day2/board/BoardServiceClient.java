package day2.board;

import day2.common.aoptest.AopTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext_day2.xml");

        BoardService boardService = (BoardService) container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setTitle("데이터");
        vo.setWriter("gogoring");
        vo.setContent("springjdbc");
        boardService.insertBoard(vo);

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for(BoardVO board : boardList){
            System.out.println("--> " + board.toString());
        }
        AopTest test = new AopTest();
        test.testMethod();

        container.close();
    }
}

package day2.board;

import day2.common.aoptest.AopTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

        BoardService boardService = (BoardService) container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setTitle("데이터 넣기");
        vo.setWriter("jeonB1234");
        vo.setContent("개재미없네");
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

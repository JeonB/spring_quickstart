package day3.board;

import day3.common.aoptest.AopTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("C:\\Users\\tj\\Desktop\\projects\\spring_quickstart\\web\\WEB-INF\\spring\\applicationContext_day3.xml");

        BoardService boardService = (BoardService) container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setSeq(15);
        vo.setTitle("테스트게시물");
        vo.setWriter("가보자");
        vo.setContent("테스트");
        boardService.insertBoard(vo);

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for(BoardVO board : boardList){
            System.out.println("--> " + board.toString());
        }

        container.close();
    }
}

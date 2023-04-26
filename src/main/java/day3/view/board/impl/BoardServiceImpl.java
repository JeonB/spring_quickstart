package day3.view.board.impl;

import day3.view.board.BoardService;
import day3.view.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAOSpring boardDAO;

    //	private BoardDAO boardDAO;
    public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0){
//			throw new IllegalArgumentException("0번글은 등록 불가");
//		}
        boardDAO.insertBoard(vo);
    }

    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }

    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        return boardDAO.getBoardList(vo);
    }
}
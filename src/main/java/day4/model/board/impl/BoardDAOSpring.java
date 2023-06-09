package day4.model.board.impl;

import day4.model.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("boardDAO")
public class BoardDAOSpring {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    private final String BOARD_INSERT = "insert into board(seq,title,writer, content) " +
            "values((select nvl(max(seq),0)+1 from board),?,?,?)"; //(select nvl(max(seq),0)+1 from board)
    private final String BOARD_UPDATE = "update board set title=?,content=? where seq=?";
    private final String BOARD_DELETE = "delete board where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST_T = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' order by seq desc";
    private final String BOARD_LIST_C = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' order by seq desc";

//    @Autowired
//    public void setSuperDataSource(DataSource dataSource){
//        super.setDataSource(dataSource);
//    }

    //CRUD 기능의 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
        jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    // 글 수정
    public void updateBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
        jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
    }

    // 글 삭제
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
        jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
    }

    // 글 상세 조회
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
        Object[] args = {vo.getSeq()};
        return jdbcTemplate.queryForObject(BOARD_GET, args, new
                BoardRowMapper());
    }

    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
        Object[] args = {vo.getSearchKeyword()};
        if (vo.getSearchCondition().equals("TITLE")) {
            return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
        } else if (vo.getSearchCondition().equals("CONTENT")) {
            return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
        }
        return null;
    }

}

class BoardRowMapper implements RowMapper<BoardVO> {

    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardVO board = new BoardVO();
        board.setSeq(rs.getInt("SEQ"));
        board.setTitle(rs.getString("TITLE"));
        board.setWriter(rs.getString("WRITER"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDate(rs.getDate("REGDATE"));
        board.setCnt(rs.getInt("CNT"));
        return board;
    }
}

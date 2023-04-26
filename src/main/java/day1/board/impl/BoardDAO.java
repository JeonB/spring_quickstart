package day1.board.impl;

import day1.board.BoardVO;
import day1.common.JDBCUtill;
import org.springframework.stereotype.Repository;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BoardDAO extends JDBCUtill {

    private Connection conn;
    private PreparedStatement pstmt; // 사전에 컴파일된 SQL문을 나타내는 객체(PreparedStatement는 인터페이스)
    private ResultSet rs; //쿼리문을 실행할 때 생성되는 데이터베이스 result set

    // BoardDAO 생성자
    public BoardDAO() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    // 글 작성 기능
    public void insert(BoardVO vo) {
        String sql = "INSERT INTO board (seq, title, writer, content) VALUES (?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql); //DB에 SQL문을 보내기 위한 객체가 prreparedStatement
            pstmt.setInt(1, vo.getSeq());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getWriter());
            pstmt.setString(4, vo.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 글 수정 기능
    public void update(BoardVO vo) {
        String sql = "UPDATE board SET title = ?, content = ? WHERE seq = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setInt(3, vo.getSeq());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 글 삭제 기능
    public void delete(int seq) {
        String sql = "DELETE FROM board WHERE seq = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, seq);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
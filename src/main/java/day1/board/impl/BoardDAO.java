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
public class BoardDAO extends JDBCUtill{
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // BoardDAO 생성자
    public BoardDAO() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    // 글 작성 기능
    public void insert(BoardVO vo) {
        String sql = "INSERT INTO board (seq, title, writer, content) VALUES (?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
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
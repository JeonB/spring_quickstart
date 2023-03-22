package day1.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtill {

        public static String url = "jdbc:postgresql://localhost:5432/board";
        public static String username = "jeon";
        public static String password = "1234";
    public static void main(String[] args) throws SQLException {


        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            System.out.println("Connected to PostgreSQL database!");

            // SQL 쿼리를 준비합니다.
            String sql = "SELECT * FROM board WHERE title = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "test");

            // 쿼리를 실행하고 결과를 받아옵니다.
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.printf("%s %s\n", result.getString("title"), result.getString("writer"));
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}

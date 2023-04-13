package day3.view.user.impl;

import day3.view.board.BoardVO;
import day3.view.common.JDBCUtil;
import day3.view.user.UserVO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// DAO(Data Access Object)
@Repository("userDAO")
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private final String USER_GET = "select * from users where id=? and password=?";
	private final String USER_INSERT = "insert into users(id,password,name,role) values(?,?,?,?)";
	private final String USER_DELETE = "DELETE USERS WHERE ID=?";
	private final String USER_UPDATE = "UPDATE USERS SET PASSWORD=? WHERE ID=?";
	private final String USER_LIST = "select * from users order by id";

	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 getUser() 메소드 호출");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}

	public void insertUser(UserVO vo){
		System.out.println("===> JDBC로 insertUser() 처리");
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt,conn);
		}
	}

	public void updateUser(UserVO vo){
		System.out.println("===> JDBC로 updateUser() 처리 ");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1,vo.getPassword());
			stmt.setString(2,vo.getId());
			stmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt,conn);
		}
	}

	public void deleteUser(UserVO vo){
		System.out.println("===> JDBC로 delelteUser() 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1,vo.getId());
			stmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt,conn);
		}
	}

	public List<UserVO> getUserList(){
		System.out.println("===> JDBC로 getUserList() 처리");
		List<UserVO> userList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return userList;
	}
}
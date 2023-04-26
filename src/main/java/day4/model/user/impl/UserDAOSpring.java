package day4.model.user.impl;

import day4.model.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOSpring {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String USER_GET = "select * from users where id =? and password=?";
    private final String USER_INSERT = "insert into users(id,password,name,role) values(?,?,?,?)";
    private final String USER_DELETE = "DELETE USERS WHERE ID=?";
    private final String USER_UPDATE = "UPDATE USERS SET PASSWORD=? WHERE ID=?";
    private final String USER_LIST = "select * from users order by id";

    public UserVO getUser(UserVO vo) {
        System.out.println("===> Spring JDBC로 getUser() 기능 처리");
        if (jdbcTemplate == null) {
            throw new IllegalStateException("jdbcTemplate is null");
        }
        Object[] args = {vo.getId(), vo.getPassword()};
        return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
    }

    public List<UserVO> getUserList() {
        System.out.println("===> Spring JDBC로 getUserList() 기능 처리");
        return jdbcTemplate.query(USER_LIST, new UserRowMapper());
    }

    public void insertUser(UserVO vo) {
        System.out.println("===> Spring JDBC로 insertUser() 기능 처리");
        jdbcTemplate.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
    }

    public void updateUser(UserVO vo) {
        System.out.println("===> Spring JDBC로 updateUser() 기능 처리");
        jdbcTemplate.update(USER_UPDATE, vo.getPassword(), vo.getId());
    }

    public void deleteUser(UserVO vo) {
        System.out.println("===> Spring JDBC로 deleteUser() 기능 처리");
        jdbcTemplate.update(USER_DELETE, vo.getId());
    }
}


class UserRowMapper implements RowMapper<UserVO> {

    public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));
        return user;
    }
}

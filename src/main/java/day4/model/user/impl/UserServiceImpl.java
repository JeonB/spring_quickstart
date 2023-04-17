package day4.model.user.impl;

import day4.model.user.UserService;
import day4.model.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAOSpring userDAO;


	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}

	public List<UserVO> getUserList(){return userDAO.getUserList();}

}

package day3.view.user.impl;

import day3.view.user.UserVO;
import day3.view.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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

    public List<UserVO> getUserList() {
        return userDAO.getUserList();
    }

}

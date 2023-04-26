package day3.view.user;

import java.util.List;

public interface UserService {

    public UserVO getUser(UserVO vo);

    public void insertUser(UserVO vo);

    public void deleteUser(UserVO vo);

    public void updateUser(UserVO vo);

    public List<UserVO> getUserList();
}

package dao;

import entity.User;

import java.util.List;

public interface IUserDao {
    int insertUser(User user);

    int deleteUser(User user);

    int updateUserPwd(String name, String pwd);

    List<User> findUser(String name);

}

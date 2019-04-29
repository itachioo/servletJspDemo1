package dao.impl;

import dao.IUserDao;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;



public class UserDaoImplTest {

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("zoulj");
        user.setPassword("123456");
        IUserDao userDao = new UserDaoImpl();
        userDao.insertUser(user);
    }

    @Test
    public void updateUserPwd() {
        String name = "zoulj";
        String pwd = "666666";
        IUserDao userDao = new UserDaoImpl();
        System.out.println(userDao.updateUserPwd(name,pwd));
    }

    @Test
    public void findUser() {
    String name = "zoulj";
    IUserDao userDao = new UserDaoImpl();
    System.out.println(userDao.findUser(name));
    }
}

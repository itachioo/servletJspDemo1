package service;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import entity.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    @Override
    public boolean loginSauth(User user) {
        String name = user.getName();
        String password = user.getPassword();
        IUserDao userDao = new UserDaoImpl();
        List<User> res = userDao.findUser(name);
        if (res.isEmpty()) return false;
        else {
            return password.equals(res.get(0).getPassword());
        }
    }
}

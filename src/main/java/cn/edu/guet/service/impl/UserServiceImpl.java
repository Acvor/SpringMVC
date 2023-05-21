package cn.edu.guet.service.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.dao.impl.UserDaoImpl;
import cn.edu.guet.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String saveUser(User user) {
        userDao.saveUser(user);
        return null;
    }

    @Override
    public List<User> viewUser() {
        return userDao.viewUser();
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(String id, String username, String address) {
        userDao.updateUser(id,username,address);
    }
}

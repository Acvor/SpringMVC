package cn.edu.guet.dao;

import cn.edu.guet.bean.User;

import java.util.List;

public interface UserDao {
    int saveUser(User user);
    List<User> viewUser();
    void deleteUser(String id);
    void updateUser(String id, String username, String address);
}

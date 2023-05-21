package cn.edu.guet.service;

import cn.edu.guet.bean.User;

import java.util.List;

public interface UserService {
    String saveUser(User user);
    List<User> viewUser();
    void deleteUser(String id);
    void updateUser(String id,String username,String address);
}

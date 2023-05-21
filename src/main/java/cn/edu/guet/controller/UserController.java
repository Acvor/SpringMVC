package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpCookie;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("保存用户");
        userService.saveUser(user);
        return "redirect:/viewUser.do";
    }

    @RequestMapping("/viewUser")
    public String viewUser(HttpServletRequest request){
        System.out.println("查看用户");
        List<User> userList = userService.viewUser();
        System.out.println(userList);
        request.setAttribute("userList", userList);
        return "viewUser.jsp";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request){
        System.out.println("删除用户");
        String id=request.getParameter("id");
        userService.deleteUser(id);
        return "redirect:/viewUser.do";
    }

}

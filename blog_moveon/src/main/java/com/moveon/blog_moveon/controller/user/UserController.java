package com.moveon.blog_moveon.controller.user;

import com.moveon.blog_moveon.entity.user.User;
import com.moveon.blog_moveon.service.user.UserService;
import com.moveon.blog_moveon.utils.ResultMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public ResultMap hello(String name){
        User user = new User();
        user.setUsername(name);
        return ResultMap.buildSuccessResult("success",user);
    }

    @RequestMapping("/login")
    public ResultMap loginUser(@Param("username") String username, @Param("password") String password) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            return ResultMap.buildSuccessResult("登陆成功",user);
        }else {
            return ResultMap.buildFailureResult("登陆失败");
        }
    }

    @RequestMapping("/registerUser")
    public ResultMap registerUser(User user) {
        try {
            int i = userService.registerUser(user);
            if (i != 0) {
                return ResultMap.buildSuccessResult("注册成功",i);
            }else {
                return ResultMap.buildFailureResult("注册失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResultMap.buildFailureResult("注册失败");
        }
    }

    @RequestMapping("/deleteUser")
    public ResultMap deleteUser(String username, String password) {
        try {
            int i = userService.deleteUser(username, password);
            if (i != 0) {
                return ResultMap.buildSuccessResult("删除成功",i);
            }else {
                return ResultMap.buildFailureResult("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.buildFailureResult("删除失败");
        }
    }

    @RequestMapping("/updatePassword")
    public ResultMap updatePassword(@Param("username") String username, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword) {
        int i = userService.updatePassword(username, oldPassword, newPassword);
        if (i != 0) {
            return ResultMap.buildSuccessResult("修改密码成功",i);
        }else {
            return ResultMap.buildFailureResult("修改密码失败");
        }
    }

}

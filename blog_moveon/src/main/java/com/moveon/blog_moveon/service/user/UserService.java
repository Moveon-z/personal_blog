package com.moveon.blog_moveon.service.user;

import com.moveon.blog_moveon.entity.user.User;
import com.moveon.blog_moveon.mapper.user.UserMapper;
import com.moveon.blog_moveon.utils.MainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /*
    * 登陆用户
    * */
    public User loginUser(String username,String password) {
        return userMapper.loginUser(username, password);
    }

    /*
    * 注册用户
    * */
    public int registerUser(User user) {
        MainUtil util = new MainUtil();
        user.setUuid(util.getUUID());
        user.setRegisterTime(util.DateToString(new Date()));
        user.setUserType("common_user");
        try {
            int i = userMapper.registerUser(user);
            return i;
        }catch (Exception e){
            throw e;
        }
    }

    /*
    * 删除用户
    * */
    public int deleteUser(String username, String password) {
        try {
            int i = userMapper.deleteUser(username, password);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int updatePassword(String username, String oldPassword, String newPassword) {
        try {
            int i = userMapper.updatePassword(username, oldPassword, newPassword);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

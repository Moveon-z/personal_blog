package com.moveon.blog_moveon.mapper.user;

import com.moveon.blog_moveon.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User loginUser(String username, String password);

    public int registerUser(User user);

    public int deleteUser(String username, String password);

    public int updatePassword(String username, String oldPassword, String newPassword);
}

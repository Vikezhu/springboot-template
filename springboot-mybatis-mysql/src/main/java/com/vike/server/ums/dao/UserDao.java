package com.vike.server.ums.dao;

import com.vike.server.ums.model.User;
import com.vike.server.ums.model.UserDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUser(Map<String, Object> map);

    List<UserDetails> getUserDetails(@Param("userId") String userId);

    void addUser(UserDetails user);

    void updateUser(UserDetails user);

    void deleteUser(@Param("name") String name);
}

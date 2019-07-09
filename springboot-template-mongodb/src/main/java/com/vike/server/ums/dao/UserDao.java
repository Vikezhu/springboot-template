package com.vike.server.ums.dao;

import com.vike.server.ums.model.UserDetails;

import java.util.List;

public interface UserDao {
    List<UserDetails> getUser(Boolean countOutput, Integer start, Integer limit, String key, String value,
                       Boolean search, Boolean searchByAny, String sortfield, String sorttype, String fields);

    UserDetails getUserDetails(String userId);

    void addUser(UserDetails user);

    void updateUser(UserDetails user);

    void deleteUser(String... name);

    void test();
}

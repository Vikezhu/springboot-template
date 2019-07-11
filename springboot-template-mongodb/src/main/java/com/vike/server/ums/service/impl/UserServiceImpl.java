package com.vike.server.ums.service.impl;

import com.vike.server.ums.dao.UserDao;
import com.vike.server.ums.model.ApiResult;
import com.vike.server.ums.model.UserDetails;
import com.vike.server.ums.service.UserService;
import com.vike.server.ums.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ApiResult addUser(UserDetails user) {
        userDao.addUser(user);
        return ResponseUtil.success();
    }

    @Override
    public ApiResult getUser(Boolean countOutput, Integer start, Integer limit, String key, String value,
                             Boolean search, Boolean searchByAny, String sortfield, String sorttype, String fields) {
        List<UserDetails> list = userDao.getUser(countOutput, start, limit, key, value, search, searchByAny, sortfield, sorttype, fields);
        Integer count = userDao.getUserCount(countOutput, start, limit, key, value, search, searchByAny, sortfield, sorttype, fields);
        if (countOutput) {
            return ResponseUtil.successWithData(count, null);
        } else {
            return ResponseUtil.successWithData(count, list);
        }
    }

    @Override
    public ApiResult getUserDetails(String userId) {
        UserDetails userDetails = userDao.getUserDetails(userId);
        if (userDetails != null) {
            return ResponseUtil.successWithData(1, userDetails);
        } else {
            return ResponseUtil.successWithData(0, userDetails);
        }
    }

    @Override
    public ApiResult updateUser(UserDetails user) {
        userDao.updateUser(user);
        return ResponseUtil.success();
    }

    @Override
    public ApiResult deleteUser(String name) {
        String[] names = {};
        if (!name.trim().isEmpty()) {
            names = name.split(",");
        }
        userDao.deleteUser(names);
        return ResponseUtil.success();
    }

    /*@Override
    public ApiResult testInterface() {
        userDao.test();
        return ResponseUtil.success();
    }*/
}

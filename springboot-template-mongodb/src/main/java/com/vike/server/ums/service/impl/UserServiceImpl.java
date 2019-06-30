package com.vike.server.ums.service.impl;

import com.vike.server.ums.dao.UserDao;
import com.vike.server.ums.model.ApiResult;
import com.vike.server.ums.model.UserDetails;
import com.vike.server.ums.service.UserService;
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
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("0");
        apiResult.setMessage("新增成功");
        return apiResult;
    }

    @Override
    public ApiResult getUser(Boolean countOutput, Integer start, Integer limit, String key, String value,
                             Boolean search, Boolean searchByAny, String sortfield, String sorttype) {
        ApiResult apiResult = new ApiResult();
        List<UserDetails> list = userDao.getUser(countOutput, start, limit, key, value, search, searchByAny, sortfield, sortfield);
        if (!countOutput) {
            apiResult.setDatas(list);
        }
        apiResult.setCount(list.size());
        apiResult.setCode("0");
        apiResult.setMessage("查询成功");
        return apiResult;
    }

    @Override
    public ApiResult getUserDetails(String userId) {
        UserDetails userDetails = userDao.getUserDetails(userId);
        ApiResult apiResult = new ApiResult();
        apiResult.setDatas(userDetails);
        if (userDetails != null) {
            apiResult.setCount(1);
        } else {
            apiResult.setCount(0);
        }
        apiResult.setCode("0");
        apiResult.setMessage("查询成功");
        return apiResult;
    }

    @Override
    public ApiResult updateUser(UserDetails user) {
        userDao.updateUser(user);
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("0");
        apiResult.setMessage("修改成功");
        return apiResult;
    }

    @Override
    public ApiResult deleteUser(String name) {
        String[] names = {};
        if (!name.trim().isEmpty()) {
            names = name.split(",");
        }
        for (String str : names) {
            userDao.deleteUser(str);
        }
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("0");
        apiResult.setMessage("删除成功");
        return apiResult;
    }
}

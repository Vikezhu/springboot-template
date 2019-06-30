package com.vike.server.ums.service.impl;

import com.vike.server.ums.dao.UserDao;
import com.vike.server.ums.model.ApiResult;
import com.vike.server.ums.model.User;
import com.vike.server.ums.model.UserDetails;
import com.vike.server.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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
    public ApiResult getUser(Boolean countOutput, Integer start, Integer limit, String key, String value, Boolean search, Boolean searchByAny, String sortfield, String sorttype) {
        ApiResult apiResult = new ApiResult();
        // 查询条件拼接处理
        Map<String, Object> map = new HashMap<>();
        if (start != null && limit != null) {
            map.put("start", start);
            map.put("limit", limit);
        }
        if (key != null && value != null) {
            String[] fields = key.split(",");
            String[] values = value.split(",");
            for (int i = 0; i < fields.length; i++) {
                map.put(fields[i], values[i]);
            }
        }
        if (search != null) {
            map.put("search", search);
        }
        if (searchByAny != null) {
            map.put("searchByAny", searchByAny);
        }
        if (sortfield != null){
            map.put("sortfield", sortfield);
        }
        if (sorttype != null){
            map.put("sorttype", sorttype);
        }

        List<User> list = userDao.getUser(map);
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
        List<UserDetails> userDetails = userDao.getUserDetails(userId);
        ApiResult apiResult = new ApiResult();
        apiResult.setDatas(userDetails);
        apiResult.setCount(userDetails.size());
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

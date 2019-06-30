package com.vike.server.ums.service;

import com.vike.server.ums.model.ApiResult;
import com.vike.server.ums.model.UserDetails;

public interface UserService {
    ApiResult addUser(UserDetails user);

    ApiResult getUser(Boolean countOutput, Integer start, Integer limit, String key, String value, Boolean search, Boolean searchByAny, String sortfield, String sorttype);

    ApiResult getUserDetails(String userId);

    ApiResult updateUser(UserDetails user);

    ApiResult deleteUser(String name);
}

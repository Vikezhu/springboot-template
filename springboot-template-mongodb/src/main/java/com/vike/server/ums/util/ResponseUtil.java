package com.vike.server.ums.util;

import com.vike.server.ums.model.ApiResult;

public class ResponseUtil {

    public static ApiResult success() {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("0");
        apiResult.setMessage("操作成功");
        return apiResult;
    }

    public static ApiResult warn(String warnMsg) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("1");
        apiResult.setMessage(warnMsg);
        return apiResult;
    }

    public static ApiResult successWithData(Integer count, Object datas) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("0");
        apiResult.setMessage("操作成功");
        apiResult.setCount(count);
        apiResult.setDatas(datas);
        return apiResult;
    }
}

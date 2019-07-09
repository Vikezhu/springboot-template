package com.vike.server.ums.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vike.server.ums.model.ApiResult;
import com.vike.server.ums.model.UserDetails;
import com.vike.server.ums.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T11:45:28.038+08:00")

@RestController
public class UserApiController implements UserApi {

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    private UserService userService;
    HttpStatus code;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<Object> addUser(@ApiParam(value = "定义一个新的指标" ,required=true )  @Valid @RequestBody UserDetails body) {
        ApiResult apiResult = userService.addUser(body);
        if ("0".equals(apiResult.getCode()) || "1".equals(apiResult.getCode())) {
            code = HttpStatus.OK;
        } else {
            code = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<>(apiResult, code);
    }

    public ResponseEntity<Object> getUser(
            @ApiParam(value = "返回结果中的记录数而不是实际数据。默认值：false", defaultValue = "false") @Valid @RequestParam(value = "countOutput", required = false, defaultValue = "false") Boolean countOutput,
            @ApiParam(value = "返回从第start个位置起始的记录") @Valid @RequestParam(value = "start", required = false) Integer start,
            @ApiParam(value = "限制返回的记录数。") @Valid @RequestParam(value = "limit", required = false) Integer limit,
            @ApiParam(value = "输入查询条件的字段名，多个字段用逗号隔开。") @Valid @RequestParam(value = "key", required = false) String key,
            @ApiParam(value = "输入查询条件的字段值，多个值用逗号隔开。") @Valid @RequestParam(value = "value", required = false) String value,
            @ApiParam(value = "需要查询的字段集，多个值用逗号隔开。") @Valid @RequestParam(value = "fields", required = false) String fields,
            @ApiParam(value = "为true则根据字段值做模糊查询，类似LIKE %值%；默认为false。searchByAny为true时，该配置时效！", defaultValue = "false") @Valid @RequestParam(value = "search", required = false, defaultValue = "false") Boolean search,
            @ApiParam(value = "如果设置为true返回符合filter或search参数中给出的任何条件而不是所有条件的结果。默认值：false。", defaultValue = "false") @Valid @RequestParam(value = "searchByAny", required = false, defaultValue = "false") Boolean searchByAny,
            @ApiParam(value = "按给定字段对结果进行排序。") @Valid @RequestParam(value = "sortfield", required = false) String sortfield,
            @ApiParam(value = "排序方式。可能的值有：ASC- 升序;DESC- 下降。") @Valid @RequestParam(value = "sorttype", required = false) String sorttype) {

        ApiResult apiResult = userService.getUser(countOutput, start, limit, key, value, search, searchByAny, sortfield, sorttype, fields);
//        userService.testInterface();
        if ("0".equals(apiResult.getCode()) || "1".equals(apiResult.getCode())) {
            code = HttpStatus.OK;
        } else {
            code = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<>(apiResult, code);
    }

    public ResponseEntity<Object> getUserDetails(
            @ApiParam(value = "用户id", required = true) @PathVariable("userId") String userId) {
        ApiResult apiResult = userService.getUserDetails(userId);
        if ("0".equals(apiResult.getCode()) || "1".equals(apiResult.getCode())) {
            code = HttpStatus.OK;
        } else {
            code = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<>(apiResult, code);
    }

    public ResponseEntity<Object> deleteUser(@NotNull @ApiParam(value = "根据用户名批量删除,多个id用逗号隔开", required = true) @Valid @RequestParam(value = "name", required = true) String name) {
        ApiResult apiResult = userService.deleteUser(name);
        if ("0".equals(apiResult.getCode()) || "1".equals(apiResult.getCode())) {
            code = HttpStatus.OK;
        } else {
            code = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<>(apiResult, code);
    }

    public ResponseEntity<Object> updateUser(@ApiParam(value = "修改指标定义中的信息" ,required=true )  @Valid @RequestBody UserDetails body) {
        ApiResult apiResult = userService.updateUser(body);
        if ("0".equals(apiResult.getCode()) || "1".equals(apiResult.getCode())) {
            code = HttpStatus.OK;
        } else {
            code = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<>(apiResult, code);
    }

}

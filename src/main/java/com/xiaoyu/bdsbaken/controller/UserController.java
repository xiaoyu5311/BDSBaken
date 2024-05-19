package com.xiaoyu.bdsbaken.controller;

import com.xiaoyu.bdsbaken.entity.dto.ResponseResult;
import com.xiaoyu.bdsbaken.entity.vo.UserVO;
import com.xiaoyu.bdsbaken.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    ResponseResult login(@RequestBody UserVO userVO)
    {
        return loginService.login(userVO);
    }
}

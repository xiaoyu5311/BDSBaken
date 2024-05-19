package com.xiaoyu.bdsbaken.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.xiaoyu.bdsbaken.entity.dto.ResponseResult;
import com.xiaoyu.bdsbaken.entity.po.UserPO;
import com.xiaoyu.bdsbaken.entity.vo.UserVO;
import com.xiaoyu.bdsbaken.mapper.UserPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService
{
    @Autowired
    UserPOMapper userPOMapper;

    public ResponseResult login(UserVO userVO)
    {
        UserPO userPO = new LambdaQueryChainWrapper<>(userPOMapper).eq(UserPO::getUuid, userVO.getUuid()).one();
        if (userPO == null)
        {
            userPO = BeanUtil.copyProperties(userVO, UserPO.class);
            //新用户注册
            userPOMapper.insert(userPO);
            return ResponseResult.success(true);//true 新用户
        }
        return ResponseResult.success(false);
    }
}

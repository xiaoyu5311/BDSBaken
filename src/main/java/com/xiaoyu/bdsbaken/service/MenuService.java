package com.xiaoyu.bdsbaken.service;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.xiaoyu.bdsbaken.entity.dto.ResponseResult;
import com.xiaoyu.bdsbaken.entity.po.MenuItemPO;
import com.xiaoyu.bdsbaken.entity.vo.MenuItemVO;
import com.xiaoyu.bdsbaken.mapper.MenuItemPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService
{
    @Autowired
    MenuItemPOMapper menuItemPOMapper;

    public ResponseResult getMenuCateList()
    {
        //查询没有父级的菜单项
        List<MenuItemPO> list = new LambdaQueryChainWrapper<>(menuItemPOMapper).eq(MenuItemPO::getParent, -1).list();
        return ResponseResult.success(list);
    }

    public ResponseResult getSubMenuListById(int id)
    {
        //查询该父菜单下的所有子菜单
        List<MenuItemPO> list = new LambdaQueryChainWrapper<>(menuItemPOMapper).eq(MenuItemPO::getParent, id).list();
        return ResponseResult.success(list);
    }
}

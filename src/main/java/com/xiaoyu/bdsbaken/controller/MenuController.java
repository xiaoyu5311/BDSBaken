package com.xiaoyu.bdsbaken.controller;

import com.xiaoyu.bdsbaken.entity.dto.ResponseResult;
import com.xiaoyu.bdsbaken.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController
{
    @Autowired
    MenuService menuService;

    @GetMapping("/catelist")
    ResponseResult getMenuCateList()
    {
        return menuService.getMenuCateList();
    }

    @GetMapping("/sublist/{id}")
    ResponseResult getMenuCateList(@PathVariable int id)
    {
        return menuService.getSubMenuListById(id);
    }
}

package com.xiaoyu.bdsbaken.controller;

import com.xiaoyu.bdsbaken.entity.dto.ResponseResult;
import com.xiaoyu.bdsbaken.entity.vo.RecycleGoodsVO;
import com.xiaoyu.bdsbaken.entity.vo.SellGoodsVO;
import com.xiaoyu.bdsbaken.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController
{
    @Autowired
    StoreService storeService;

    @GetMapping("/sell/{id}")
//根据ID获取商品的详细信息
    ResponseResult getSellGoods(@PathVariable int id)
    {
        return storeService.getBuyGoods(id);
    }

    @PostMapping("/sell")
//出售
    ResponseResult sellGoods(@RequestBody SellGoodsVO sellGoodsVO)
    {
        return storeService.sellGoods(sellGoodsVO);
    }

    @GetMapping("/recycle/{id}")
//根据ID获取回收商品的详细信息
    ResponseResult getRecycledGoods(@PathVariable int id)
    {
        return storeService.getRecycledGoods(id);
    }

    @PostMapping("/recycle")
    ResponseResult recycleGoods(@RequestBody RecycleGoodsVO recycleGoodsVO)
    {
        return storeService.recycleGoods(recycleGoodsVO);
    }
}

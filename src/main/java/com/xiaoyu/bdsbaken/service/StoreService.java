package com.xiaoyu.bdsbaken.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.xiaoyu.bdsbaken.entity.dto.ResponseResult;
import com.xiaoyu.bdsbaken.entity.po.RecycledGoodsPO;
import com.xiaoyu.bdsbaken.entity.po.SellGoodsPO;
import com.xiaoyu.bdsbaken.entity.po.UserPO;
import com.xiaoyu.bdsbaken.entity.vo.RecycleGoodsVO;
import com.xiaoyu.bdsbaken.entity.vo.RecycledGoodsDetailVO;
import com.xiaoyu.bdsbaken.entity.vo.SellGoodsVO;
import com.xiaoyu.bdsbaken.entity.vo.SellGoodsDetailVO;
import com.xiaoyu.bdsbaken.mapper.RecycledGoodsPOMapper;
import com.xiaoyu.bdsbaken.mapper.SellGoodsPOMapper;
import com.xiaoyu.bdsbaken.mapper.UserPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService
{
    @Autowired
    SellGoodsPOMapper sellGoodsPOMapper;
    @Autowired
    UserPOMapper userPOMapper;
    @Autowired
    RecycledGoodsPOMapper recycledGoodsPOMapper;

    public ResponseResult getBuyGoods(int id)
    {
        SellGoodsPO one = new LambdaQueryChainWrapper<>(sellGoodsPOMapper).eq(SellGoodsPO::getGoodsId, id).one();
        SellGoodsDetailVO sellGoodsDetailVO = BeanUtil.copyProperties(one, SellGoodsDetailVO.class);
        return ResponseResult.success(sellGoodsDetailVO);
    }

    public ResponseResult sellGoods(SellGoodsVO sellGoodsVO)
    {
        String uuid = sellGoodsVO.getUuid();
        double total = sellGoodsVO.getAmount() * sellGoodsVO.getAmount();
        Double balance = new LambdaQueryChainWrapper<>(userPOMapper).eq(UserPO::getUuid, sellGoodsVO.getUuid()).one().getBalance();
        Double goodsPrice = new LambdaQueryChainWrapper<>(sellGoodsPOMapper).eq(SellGoodsPO::getGoodsId, sellGoodsVO.getGoodsId()).one().getGoodsPrice();
        Double sum = total * goodsPrice;
        if (balance > sum)
        {
            new LambdaUpdateChainWrapper<>(userPOMapper).eq(UserPO::getUuid, uuid).set(UserPO::getBalance, balance - sum).update();
            return ResponseResult.success(true);
        }
        return ResponseResult.success(false);
    }

    //
    public ResponseResult getRecycledGoods(int id)
    {
        RecycledGoodsPO one = new LambdaQueryChainWrapper<>(recycledGoodsPOMapper).eq(RecycledGoodsPO::getGoodsId, id).one();
        RecycledGoodsDetailVO recycledGoodsDetailVO = BeanUtil.copyProperties(one, RecycledGoodsDetailVO.class);
        return ResponseResult.success(recycledGoodsDetailVO);
    }


    public ResponseResult recycleGoods(RecycleGoodsVO recycleGoodsVO)
    {
        String uuid = recycleGoodsVO.getUuid();//用户ID
        double total = recycleGoodsVO.getAmount() * recycleGoodsVO.getAmount();
        Double balance = new LambdaQueryChainWrapper<>(userPOMapper).eq(UserPO::getUuid, recycleGoodsVO.getUuid()).one().getBalance();
        Double goodsPrice = new LambdaQueryChainWrapper<>(recycledGoodsPOMapper).eq(RecycledGoodsPO::getGoodsId, recycleGoodsVO.getGoodsId()).one().getRecycledPrice();
        Double sum = total * goodsPrice;
        new LambdaUpdateChainWrapper<>(userPOMapper).eq(UserPO::getUuid, uuid).set(UserPO::getBalance, balance + sum).update();

        return ResponseResult.success(true);
    }
}

package com.xiaoyu.bdsbaken.entity.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//购买后的回调
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoughtGoodsVO
{
    private Double balance;//剩余的余额
    private Boolean commit;//是否成功
}

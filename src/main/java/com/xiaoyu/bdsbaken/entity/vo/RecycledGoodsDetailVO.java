package com.xiaoyu.bdsbaken.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecycledGoodsDetailVO
{
    private Integer goodsId;
    private String goodsName;
    private Double goodsPrice;
    private String objectId;
}

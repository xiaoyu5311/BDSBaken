package com.xiaoyu.bdsbaken.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellGoodsDetailVO
{
    private Integer goodsId;
    private String goodsName;
    private Double goodsPrice;
    private Double originalPrice;
    private String objectId;
}

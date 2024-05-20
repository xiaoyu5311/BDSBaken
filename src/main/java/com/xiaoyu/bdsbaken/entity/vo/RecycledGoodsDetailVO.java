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
    private Integer amount;//需要回收的数量
    private Double recycledPrice;
    private Double originalPrice;
    private String objectId;
}

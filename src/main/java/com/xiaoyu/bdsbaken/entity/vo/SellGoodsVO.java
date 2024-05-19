package com.xiaoyu.bdsbaken.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellGoodsVO
{
    private String uuid;
    private Integer goodsId;
    private Integer amount;//购买的数量
}

package com.xiaoyu.bdsbaken.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sell_goods")
public class SellGoodsPO
{
    private Integer goodsId;
    private String goodsName;
    private Double goodsPrice;
    private Double originalPrice;
    private String objectId;
}

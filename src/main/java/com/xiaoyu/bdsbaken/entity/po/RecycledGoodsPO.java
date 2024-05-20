package com.xiaoyu.bdsbaken.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("recycled_goods")
public class RecycledGoodsPO
{
    private Integer goodsId;
    private String goodsName;
    private Double recycledPrice;
    private Double originalPrice;
    private Integer amount;
    private String objectId;
}

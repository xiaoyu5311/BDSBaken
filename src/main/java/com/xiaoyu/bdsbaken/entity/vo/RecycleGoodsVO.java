package com.xiaoyu.bdsbaken.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecycleGoodsVO
{
    private String uuid;
    private Integer goodsId;
    private Integer amount;//回收的数量
}

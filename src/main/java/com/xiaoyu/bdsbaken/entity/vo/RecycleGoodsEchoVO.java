package com.xiaoyu.bdsbaken.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.AdviceName;

@Data
@AllArgsConstructor
@NoArgsConstructor
//回显
public class RecycleGoodsEchoVO
{
    private Double balanceIncr;
    private Double balance;
}

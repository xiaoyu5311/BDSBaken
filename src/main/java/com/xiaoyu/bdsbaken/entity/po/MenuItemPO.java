package com.xiaoyu.bdsbaken.entity.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("menu_item")
public class MenuItemPO
{
    private Integer menuId;
    private String name;
    private Integer parent;
    private String formType;
    private Integer depth;
}

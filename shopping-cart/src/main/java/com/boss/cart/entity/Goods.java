package com.boss.cart.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 17:21
 * @Description 商品实体类
 */
@Data
@TableName("goods")
public class Goods implements Serializable {
    /**
     * 商品id
     */
    @TableId("id")
    private long id;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 商品库存
     */
    @TableField("number")
    private int number;

    /**
     * 商品价格
     */
    @TableField("price")
    private float price;
}
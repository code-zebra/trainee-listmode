package com.boss.cart.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 17:21
 * @Description 订单实体类中具体的每一项
 */
@Data
@TableName("order_item")
public class OrderItem implements Serializable {
    /**
     * 多对一 - 商品项对应订单的id
     */
    @TableId("order_id")
    private long id;

    /**
     * 商品单项中的商品id
     */
    @TableField("goods_id")
    private long goodsId;

    /**
     * 用以作为OrderItemMap插入时的key
     */
    @TableField
    private long infoId;

    /**
     * 商品数量
     */
    @TableField("number")
    private int number;

    /**
     * 该类商品总价
     */
    private float price;
}

package com.boss.cart.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 17:21
 * @Description
 */
@Data
@TableName("goods_order")
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId("order_id")
    private long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private long uid;

    /**
     * 订单编号
     */
    @TableField("sn")
    private long sn;
}

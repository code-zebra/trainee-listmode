package com.boss.bosstax.entity;

import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 11:39
 * @Description 收入项目实体类
 */
@Data
public class ReceiptItem {
    /**
     * 收入项目编码
     */
    private long item_code;
    /**
     * 收入项目名称
     */
    private String item_name;
    /**
     * 单位
     */
    private String unit;
    /**
     * 数量
     */
    private int number;
    
}

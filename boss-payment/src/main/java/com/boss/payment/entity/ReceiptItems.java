package com.boss.payment.entity;

import lombok.Data;

import java.util.HashMap;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 14:44
 * @Description
 */
@Data
public class ReceiptItems {

    /**
     * 所有收入项目项
     */
    private HashMap<Long, ReceiptItem> receiptItems;
    /**
     * 金额
     */
    private int account;

    /**
     * 收入项目项
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

}

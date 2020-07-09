package com.boss.bosstax.entity;

import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 11:31
 * @Description 税务双方人员，包含缴款人和收款人两类，用枚举类型Role区分
 */
@Data
public class Person {

    /**
     * 双方角色划分 缴款人-收款人
     */
    private enum Role {PAYER, PAYEE};
    private String fullName;
    private long account;
    private String deposit_bank;
}

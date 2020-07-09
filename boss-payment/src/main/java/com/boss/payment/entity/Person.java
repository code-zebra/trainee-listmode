package com.boss.payment.entity;

import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 11:31
 * @Description 税务双方人员，包含缴款人和收款人两类，用枚举类型Role区分
 */
@Data
public class Person {


    /**
     * 角色枚举类型
     */
    private Role role;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 账户
     */
    private long account;
    /**
     * 开户银行
     */
    private String deposit_bank;
    /**
     * 枚举类型划分双方角色 缴款人-收款人
     */
    enum Role {PAYER, PAYEE};
}

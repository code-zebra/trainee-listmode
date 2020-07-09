package com.boss.payment.entity;

import lombok.Data;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 14:31
 * @Description 缴款通知书
 */
@Data
public class PaymentNote {
    public static Person payer = new Person();
    public static Person payee = new Person();
    ReceiptItems items = new ReceiptItems();
    ConfirmSection confirm = new ConfirmSection();
    static {
        payer.setRole(Person.Role.PAYER);
        payee.setRole(Person.Role.PAYEE);
    }
}
package com.boss.payment.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author 黄杰峰
 * @Date 2020/7/9 0009 14:50
 * @Description 缴款单表底部确认栏实体类
 */
@Data
public class ConfirmSection {
    /**
     * 单位主管名称
     */
    private String superVisor;

    /**
     * 会计师名称
     */
    private String accountant;

    /**
     * 复核签名
     */
    private String reCheck;

    /**
     * 记账签名
     */
    private String charge;

    /**
     * 出纳员名称
     */
    private String cashier;

    /**
     * 通知书时间
     */
    private Date note_date;
}

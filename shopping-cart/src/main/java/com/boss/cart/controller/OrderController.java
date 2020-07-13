package com.boss.cart.controller;

import com.boss.cart.entity.Order;
import com.boss.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * @Author 黄杰峰
 * @Date 2020/7/11 0011 16:36
 * @Description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 删除数据库中Order信息
     * @param orderId
     * @return
     */
    @DeleteMapping("/{orderId}")
    public String delete(@PathVariable long orderId) {
        orderService.delete(orderId);
        return "Order Deleted" + new Date().toString();
    }

    /**
     * 添加订单信息到购物车中
     * @return
     */
    @PutMapping("/{order_id}")
    public String add(@PathVariable long order_id) {
        Order order = new Order();
        order.setId(order_id);
        // UUID生成随机订单号
        Long snUUID = UUID.randomUUID().getMostSignificantBits();
        order.setSn(snUUID);
        order.setUid(987654321L);
        orderService.addOrder(order);
        return "Order Added" + new Date().toString();
    }


}

package com.boss.cart.controller;

import com.boss.cart.entity.Order;
import com.boss.cart.entity.OrderItem;
import com.boss.cart.service.impl.OrderService;
import com.boss.cart.service.impl.ShoppingCartService;
import com.boss.cart.util.IdWorker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
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
    private ShoppingCartService cartService;

    @Autowired
    public OrderController(OrderService orderService, ShoppingCartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
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
    @PutMapping("/{orderId}")
    public String add(@PathVariable long orderId) {
        Order order = new Order();
        order.setId(orderId);
        /*// UUID生成随机订单号
        Long snUUID = UUID.randomUUID().getMostSignificantBits();
        order.setSn(snUUID);*/
        // 雪花算法生成随机订单号
        long sn = new IdWorker(1, 1, 1).nextId();
        order.setSn(sn);
        order.setUid(cartService.getOwnerId());
        orderService.addOrder(order);
        return "Order Added" + new Date().toString();
    }

    /**
     * 根据账单id查询商品信息
     * @param orderId
     * @param model
     * @return
     */
    @GetMapping("/selectItems/{orderId}")
    public String selectItemsByOrderId(@PathVariable long orderId, Model model) throws JsonProcessingException {
        List<OrderItem> items = orderService.getItemByOrderId(orderId);
        model.addAttribute("items", items);
        return new ObjectMapper().writeValueAsString(items) + "\n" + new Date().toString();
    }

}

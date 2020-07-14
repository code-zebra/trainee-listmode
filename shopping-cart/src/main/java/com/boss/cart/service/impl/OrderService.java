package com.boss.cart.service.impl;

import com.boss.cart.entity.Order;
import com.boss.cart.entity.OrderItem;
import com.boss.cart.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author 黄杰峰
 * @Date 2020/7/11 0011 15:30
 * @Description 订单相关业务类
 */
@Service
public class OrderService {

    /**
     * set注入service 和 session
     * Field injection is not recommended
     */
    private ShoppingCartService service;
    private HttpSession session;
    private OrderMapper orderMapper;
    private ShoppingCartService cartService;

    @Autowired
    public OrderService(ShoppingCartService service,
                        HttpSession session,
                        OrderMapper orderMapper,
                        ShoppingCartService cartService) {
        this.service = service;
        this.session = session;
        this.orderMapper = orderMapper;
        this.cartService = cartService;
    }

    public List<OrderItem> getItemByOrderId(long orderId) {
        List<OrderItem> orderItems = orderMapper.selectItemListByOrderId(orderId);
        return orderItems;
    }

    /**
     * 获取购物车商品，保存到List中
     * @return
     */
    public List<OrderItem> getOrderItemList() {
        List<OrderItem> orderItemList = new ArrayList<>();
        Map<Long, OrderItem> cart = (Map<Long, OrderItem>) session.getAttribute("cart");
        Iterator iterator = cart.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, OrderItem> entry = (Map.Entry<Long, OrderItem>) iterator.next();
            OrderItem item = entry.getValue();
            orderItemList.add(item);
        }
        return orderItemList;
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    public boolean addOrder(Order order) {
        int insertNum = orderMapper.insert(order);
        return insertNum > 0;
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    public boolean delete(Long orderId) {
        int deleteNum = orderMapper.deleteById(orderId);
        return deleteNum > 0;
    }


}

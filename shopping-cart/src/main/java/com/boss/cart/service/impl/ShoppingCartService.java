package com.boss.cart.service.impl;

import com.boss.cart.entity.Goods;
import com.boss.cart.entity.OrderItem;
import com.boss.cart.mapper.GoodsMapper;
import com.boss.cart.mapper.OrderItemMapper;
import com.boss.cart.mapper.OrderMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author 黄杰峰
 * @Date 2020/7/10 0010 9:25
 * @Description 购物车相关业务类
 */
@Service
public class ShoppingCartService {

    private OrderItemMapper orderItemMapper;

    private OrderMapper orderMapper;

    private GoodsMapper goodsMapper;

    private HttpSession session;

    ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 用以存放数据的HashMap <商品id，OrderItem>
     */
    Map<Long, OrderItem> myCart = new HashMap<>();

    /**
     * 用以读取购物车数据的ArrayList
     */
    ArrayList<OrderItem> orderItems;

    @Autowired
    public ShoppingCartService(OrderItemMapper orderItemMapper,
                               HttpSession session,
                               GoodsMapper goodsMapper,
                               OrderMapper orderMapper) {
        this.orderItemMapper = orderItemMapper;
        this.session = session;
        this.goodsMapper = goodsMapper;
        this.orderMapper = orderMapper;
    }

    public boolean add(OrderItem item) {
        Goods goods = goodsMapper.selectById(item.getGoodsId());
        item.setPrice(goodsMapper.selectById(item.getGoodsId()).getPrice() * item.getNumber());
        getCart();
        myCart.put(item.getGoodsId(), item);
        return true;
    }

    /**
     * 更新购物车中的数量（包括自定义编辑、添加和减少）
     * @param editOrderItem
     */
    public boolean edit(OrderItem editOrderItem) {
        getCart();
        myCart.put(editOrderItem.getGoodsId(), editOrderItem);
        return true;
    }

    /**
     * 删除购物车中指定商品
     * @param goodsId
     */
    public boolean delete(long goodsId) {
        getCart();
        myCart.remove(goodsId);
        return true;
    }

    /**
     * 更新购物车内容-赋值到myCart
     * @return
     */
    public Map<Long, OrderItem> getCart() {
        myCart = (Map<Long, OrderItem>) session.getAttribute("cart");
        if (myCart == null) {
            myCart = new HashMap<Long, OrderItem>();
            session.setAttribute("cart", myCart);
        }
        return this.myCart;
    }

    /**
     * 利用Jackson将购物车内容序列化返回
     * @return
     */
    public String list(){
        String cartJsonString = null;
        try {
            cartJsonString = objectMapper.writeValueAsString(myCart);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return cartJsonString;
    }

    /**
     * 保存购物车到数据库，同时将订单信息保存到数据库
     * @return
     */
    public boolean saveCart() {
        int insertNum = 0;
        Iterator<OrderItem> iterator = myCart.values().iterator();
        while (iterator.hasNext()) {
            OrderItem next = iterator.next();
            orderItemMapper.insert(next);
            insertNum++;
        }
        return insertNum > 0;
    }

    public Long getOwnerId() {
        return 12345678L;
    }

    /**
     * 从数据库中获取购物车商品
     * @return
     */
    public List<OrderItem> getCartFromDB() {
        orderItems = (ArrayList<OrderItem>) orderItemMapper.selectList(null);
        // 将数据库中OrderItem信息保存到session中
        Map<Long, OrderItem> cartMap = new HashMap<Long, OrderItem>();
        for (OrderItem orderItem : orderItems) {
            cartMap.put(orderItem.getGoodsId(), orderItem);
        }
        myCart = cartMap;
        session.setAttribute("cart", myCart);
        return orderItems;
    }

}
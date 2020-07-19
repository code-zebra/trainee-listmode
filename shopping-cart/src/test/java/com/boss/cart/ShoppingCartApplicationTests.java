package com.boss.cart;

import com.boss.cart.entity.Goods;
import com.boss.cart.mapper.GoodsMapper;
import com.boss.cart.mapper.OrderItemMapper;
import com.boss.cart.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShoppingCartApplicationTests {


    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Test
    void contextLoads() {
    }



}

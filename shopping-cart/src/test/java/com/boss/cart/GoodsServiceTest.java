package com.boss.cart;

import com.boss.cart.entity.Goods;
import com.boss.cart.service.impl.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 黄杰峰
 * @Date 2020/7/11 0011 15:46
 * @Description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceTest {

    @Autowired
    GoodsService service;

    @Test
    public void goodsServiceTest() {
        Goods goods = new Goods();
        goods.setId(7);
        goods.setPrice(5.6F);
        goods.setNumber(30);
        goods.setName("橙子");
        service.add(goods);
    }
}

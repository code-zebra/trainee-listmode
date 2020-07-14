package com.boss.cart;

import com.boss.cart.entity.OrderItem;
import com.boss.cart.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/10 0010 11:34
 * @Description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShoppingCartServiceTest {
    @Autowired
    OrderMapper mapper;

    @Test
    public void selectItemListByOrderIdTest() {
        List<OrderItem> orderItems = mapper.selectItemListByOrderId(12345L);
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}

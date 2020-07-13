package com.boss.cart;

import com.boss.cart.entity.Goods;
import com.boss.cart.mapper.GoodsMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/10 0010 9:00
 * @Description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GoodsMapperCrudTest {
    @Resource
    GoodsMapper goodsMapper;

    // Create
    @Test
    public void goodsMapperCreateTest() {

        Goods goods = new Goods();
        goods.setId(1L);
        goods.setName("苹果");
        goods.setNumber(100);
        goods.setPrice(5.6F);
        goodsMapper.insert(goods);
    }

    // Update
    @Test
    public void goodsMapperUpdateTest() {
        Goods goods = new Goods();
        goods.setId(2L);
        goods.setPrice(5.1F);
        goodsMapper.updateById(goods);
    }

    // Retrieve
    @Test
    public void goodsMapperRetrieveTest() {
        List<Goods> goodsList = goodsMapper.selectList(null);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    // delete
    @Test
    public void goodsMapperDeleteTest() {
        goodsMapper.deleteById(6L);
    }
}

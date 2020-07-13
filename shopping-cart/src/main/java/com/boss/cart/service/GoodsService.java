package com.boss.cart.service;

import com.boss.cart.entity.Goods;
import com.boss.cart.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/11 0011 15:07
 * @Description 商品信息相关业务类，更新信息到数据库中
 */
@Service
public class GoodsService {

    /**
     * set方式注入GoodsMapper
     * tips: Field injection is not recommended
     */
    private GoodsMapper mapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 新增商品
     * @param newGoods
     * @return
     */
    public boolean add(Goods newGoods) {
        int insertNum = mapper.insert(newGoods);
        return insertNum > 0;
    }

    /**
     * 商品下架
     * @param deleteGoodsId
     * @return
     */
    public boolean delete(int deleteGoodsId) {
        int deleteNum = mapper.deleteById(deleteGoodsId);
        return deleteNum > 0;
    }

    /**
     * 更新商品信息
     * @param editGoods
     * @return
     */
    public boolean edit(Goods editGoods) {
        int editNum = mapper.updateById(editGoods);
        return editNum > 0;
    }

    /**
     * 获取数据库中所有Goods
     * @return
     */
    public List<Goods> selectAll() {
        List<Goods> goodsList = mapper.selectList(null);
        return goodsList;
    }

    /**
     * 根据ID获取Goods
     * @param goodsId
     * @return
     */
    public Goods getGoodsByGoodsId(long goodsId) {
        return mapper.selectById(goodsId);
    }

    /**
     * 获取当前购物车用户id
     * @return
     */
    public long getOwnerId() {
        // 假设用户id
        return 123456789L;
    }

}

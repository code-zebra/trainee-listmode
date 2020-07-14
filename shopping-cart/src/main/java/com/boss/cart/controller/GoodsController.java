package com.boss.cart.controller;

import com.boss.cart.entity.Goods;
import com.boss.cart.service.impl.GoodsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/12 0012 15:38
 * @Description 更新商品信息 Restful
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 新品上架
     * @param goods
     * @return
     */
    @PutMapping("/{id}")
    public String add(@RequestBody Goods goods) {
        boolean added = goodsService.add(goods);
        return "Goods Added! " + new Date().toString();
    }

    /**
     * 商品下架
     * @param deleteId
     * @return
     */
    @DeleteMapping("/{deleteId}")
    public String delete(@PathVariable int deleteId) {
        boolean delete = goodsService.delete(deleteId);
        return "Goods Deleted! " + new Date().toString();
    }

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    @PatchMapping(value = "/{editedId}", consumes = "application/json")
    public String edit(@PathVariable long editedId, @RequestBody Goods goods) {
        Goods editedGoods = goodsService.getGoodsByGoodsId(editedId);
        if (goods.getName() != null) {editedGoods.setName(goods.getName());}
        if (goods.getNumber() != 0) {editedGoods.setNumber(goods.getNumber());}
        if (goods.getPrice() != 0) {editedGoods.setPrice(goods.getPrice());}
        goodsService.edit(editedGoods);
        return "Goods Edited! " + new Date().toString();
    }

    /**
     * 获取数据库中商品列表
     * @param model
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/selectAllFromDB")
    public String selectAll(Model model) throws JsonProcessingException {
        List<Goods> goodsList = goodsService.selectAll();
        String goodsListJson = new ObjectMapper().writeValueAsString(goodsList);
        model.addAttribute("goodsList", goodsListJson);
        return goodsListJson;
    }

    /**
     * 在数据库中根据id获取Goods
     * @param model
     * @param goodsId
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/{goodsId}")
    public String selectByIdFromGoodsInDB(Model model, @PathVariable long goodsId) throws JsonProcessingException {
        Goods goods = goodsService.getGoodsByGoodsId(goodsId);
        String goodsJson = new ObjectMapper().writeValueAsString(goods);
        model.addAttribute(String.valueOf(goodsId), goodsJson);
        return goodsJson;
    }
}

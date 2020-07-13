package com.boss.cart.controller;

import com.boss.cart.entity.Goods;
import com.boss.cart.entity.OrderItem;
import com.boss.cart.mapper.GoodsMapper;
import com.boss.cart.service.ShoppingCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/11 0011 16:36
 * @Description 购物车Controller
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    private ShoppingCartService cartService;
    private GoodsMapper goodsMapper;

    @Autowired
    public CartController(ShoppingCartService cartService, GoodsMapper goodsMapper) {

        this.cartService = cartService;
        this.goodsMapper = goodsMapper;
    }

    /**
     * 添加商品到购物车中(session)
     * @param item
     * @return
     */
    @PutMapping("/{id}")
    public String add(@RequestBody OrderItem item) {
        cartService.add(item);
        return "Order Item Added " + new Date().toString();
    }

    /**
     * 更改session中购物车商品信息
     * @param item
     * @return
     */
    @PostMapping("/{id}")
    public String edit(@RequestBody OrderItem item) {
        cartService.edit(item);
        return "Order Item Edited" + new Date().toString();
    }

    /**
     * 删除session中购物车商品
     * @param deleteId
     * @return
     */
    @DeleteMapping("/{deleteId}")
    public String delete(@PathVariable int deleteId) {
        cartService.delete(deleteId);
        return "Order Item delete" + new Date().toString();
    }

    /**
     * 从session中获取购物车信息json对象
     * @return
     */
    @GetMapping("/list")
    public String list() {
        return cartService.list();
    }

    /**
     * 保存购物车到数据库中
     * @return
     */
    @GetMapping("/saveCartToDB")
    public String saveCart() {
        cartService.saveCart();
        return "Cart Saved! " + new Date().toString();
    }

    /**
     * 删除数据库中购物车商品信息
     * @param goodsId
     * @return
     */
    @DeleteMapping("/deleteCartInDB/{goodsId}")
    public String deleteCart(@PathVariable long goodsId) {
        cartService.delete(goodsId);
        return "Cart Deleted! " + new Date().toString();
    }

    /**
     * 从数据库中获取购物车中商品的json数据
     * @param model
     * @return
     */
    @PostMapping("/getCartFromDB")
    public String getCartFromDate(Model model) throws JsonProcessingException {
        List<OrderItem> cartFromDB = cartService.getCartFromDB();
        String cartJson = "";
        cartJson = new ObjectMapper().writeValueAsString(cartFromDB);
        model.addAttribute("cart", cartJson);
        return "Get Cart From MySQL :" + cartJson;
    }
}

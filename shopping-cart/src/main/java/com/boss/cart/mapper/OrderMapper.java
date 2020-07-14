package com.boss.cart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.cart.entity.Order;
import com.boss.cart.entity.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/10 0010 8:55
 * @Description
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 根据OrderId查找OrderItem
     * @param orderId
     * @return
     */
    List<OrderItem> selectItemListByOrderId(long orderId);
}

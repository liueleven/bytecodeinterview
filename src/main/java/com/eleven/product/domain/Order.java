package com.eleven.product.domain;

import com.eleven.product.service.DiscountFactory;
import com.eleven.product.service.IOrderDiscountService;

import java.math.BigDecimal;

/**
 * @description:
 * @date: 2024-10-31 17:51
 * @author: liuziqing
 */

public class Order {


    // 商品ID和使用的优惠券类型
    private Long productId;

    private DiscountFactory.DiscountType discountType;

    private BigDecimal totalPrice;

    private IOrderDiscountService discountStrategy;

    public Order(Long productId, DiscountFactory.DiscountType discountType, BigDecimal totalPrice) {
        this.productId = productId;
        this.discountType = discountType;
        this.totalPrice = totalPrice;
        this.discountStrategy = DiscountFactory.getDiscount(discountType);
    }

    public IOrderDiscountService getDiscountStrategy() {
        return discountStrategy;
    }
}

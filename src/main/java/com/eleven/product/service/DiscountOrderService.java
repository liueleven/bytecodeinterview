package com.eleven.product.service;

import com.eleven.product.domain.OrderVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 打折券：提供一定的折扣，有9折优惠券。
 * @date: 2024-10-31 18:00
 * @author: liuziqing
 */
public class DiscountOrderService implements IOrderDiscountService {

    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.9");

    private BigDecimal totalPrice;

    public DiscountOrderService(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public BigDecimal calculate() {

        return totalPrice.multiply(DISCOUNT_RATE);
    }
}

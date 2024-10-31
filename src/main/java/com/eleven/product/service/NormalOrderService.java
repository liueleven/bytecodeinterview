package com.eleven.product.service;

import com.eleven.product.domain.OrderVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @date: 2024-10-31 18:00
 * @author: liuziqing
 */
public class NormalOrderService implements IOrderDiscountService {


    private BigDecimal totalPrice;

    public NormalOrderService(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public BigDecimal calculate() {
        return totalPrice;
    }
}

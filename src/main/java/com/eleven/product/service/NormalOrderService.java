package com.eleven.product.service;

import com.eleven.product.domain.OrderVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * @date: 2024-10-31 18:00
 * @author: liuziqing
 */
public class NormalOrderService implements IOrderDiscountService {



    @Override
    public BigDecimal calculate(OrderVO order) {
        return order.getTotalPrice();
    }
}

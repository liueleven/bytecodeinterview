package com.eleven.product.service;

import com.eleven.product.domain.OrderVO;

import java.math.BigDecimal;

/**
 * @description:
 * @date: 2024-10-31 17:59
 * @author: liuziqing
 */
public interface IOrderDiscountService {

    BigDecimal calculate(OrderVO order);
}

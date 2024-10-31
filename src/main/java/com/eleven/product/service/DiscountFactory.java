package com.eleven.product.service;

import com.eleven.product.domain.OrderVO;

import java.math.BigDecimal;

/**
 * @description:
 * @date: 2024-10-31 18:07
 * @author: liuziqing
 */
public class DiscountFactory {

    public enum DiscountType {
        FULL, DISCOUNT
    }

    public static IOrderDiscountService getDiscount(DiscountType discountType, BigDecimal totalPrice) {
        if (discountType == null) {
            return new NormalOrderService(totalPrice);
        }
        switch (discountType) {
            case FULL:
                return new FullDiscountOrderService(totalPrice);
            case DISCOUNT:
                return new DiscountOrderService(totalPrice);
        }
        return new NormalOrderService(totalPrice);
    }
}

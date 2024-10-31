package com.eleven.product.service;

import com.eleven.product.domain.OrderVO;

/**
 * @description:
 * @date: 2024-10-31 18:07
 * @author: liuziqing
 */
public class DiscountFactory {

    public enum DiscountType {
        FULL, DISCOUNT
    }

    public static IOrderDiscountService getDiscount(DiscountType discountType) {
        switch (discountType) {
            case FULL:
                return new FullDiscountOrderService();
            case DISCOUNT:
                return new DiscountOrderService();
        }
        return new NormalOrderService();
    }
}

package com.eleven.product.service;

import com.eleven.product.domain.OrderVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 满减券：消费达到一定金额后可以减免一部分，有满5000减100。
 * 用户购买时，可以使用手中的优惠券进行折扣
 * @date: 2024-10-31 18:00
 * @author: liuziqing
 */
public class FullDiscountOrderService implements IOrderDiscountService {

    private static final Map<BigDecimal, BigDecimal> MAP = new HashMap<>();
    static {
        MAP.put(new BigDecimal("5000"), new BigDecimal("100"));
    }



    @Override
    public BigDecimal calculate(OrderVO order) {
        for (Map.Entry<BigDecimal, BigDecimal> entry : MAP.entrySet()) {
            BigDecimal key = entry.getKey();
            if (order.getTotalPrice().compareTo(key) >= 0) {
                return order.getTotalPrice().subtract(entry.getValue());
            }
        }
        return order.getTotalPrice();
    }
}

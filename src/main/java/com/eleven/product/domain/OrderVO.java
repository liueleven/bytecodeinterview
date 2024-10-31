package com.eleven.product.domain;

import com.eleven.product.service.DiscountFactory;
import com.sun.istack.internal.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

/**
 * @description:
 * @date: 2024-10-31 17:56
 * @author: liuziqing
 */
@Validated
public class OrderVO {

    // 商品ID和使用的优惠券类型
    @NotNull
    private Long productId;
    @NotNull
    private DiscountFactory.DiscountType discountType;

    private BigDecimal totalPrice;

    public OrderVO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public DiscountFactory.DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountFactory.DiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

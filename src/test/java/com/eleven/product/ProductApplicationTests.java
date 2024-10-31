package com.eleven.product;

import com.eleven.product.domain.OrderVO;
import com.eleven.product.service.DiscountFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductApplicationTests {

    @Autowired
    private OrderController orderController;

    @Test
    void full() {
        OrderVO orderVO = new OrderVO();
        orderVO.setProductId(1L);
        orderVO.setTotalPrice(new BigDecimal("5000"));
        orderVO.setDiscountType(DiscountFactory.DiscountType.FULL);
        BigDecimal calc = orderController.calc(orderVO);
        Assert.assertEquals(new BigDecimal("4900"), calc);
    }

    @Test
    void discount() {
        OrderVO orderVO = new OrderVO();
        orderVO.setProductId(1L);
        orderVO.setTotalPrice(new BigDecimal("5000"));
        orderVO.setDiscountType(DiscountFactory.DiscountType.DISCOUNT);
        BigDecimal calc = orderController.calc(orderVO);
        Assert.assertEquals(new BigDecimal("4500.0"), calc);
    }

    @Test
    void normal() {
        OrderVO orderVO = new OrderVO();
        orderVO.setProductId(1L);
        orderVO.setTotalPrice(new BigDecimal("4900"));
        BigDecimal calc = orderController.calc(orderVO);
        Assert.assertEquals(new BigDecimal("4900"), calc);
    }

}

package com.eleven.product;

import com.eleven.product.domain.Order;
import com.eleven.product.domain.OrderVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @description: 编程题：商家有一个商品（例如笔记本5000元），同时商家设计了两种优惠券策略
 * 1. 打折券：提供一定的折扣，有9折优惠券。
 * 2. 满减券：消费达到一定金额后可以减免一部分，有满5000减100。
 * 用户购买时，可以使用手中的优惠券进行折扣
 * <p>
 * 假设你是java服务端开发人员，前端在计算时，要求你提供一个api:
 * 1 当结算时，根据前端传的商品ID和使用的优惠券类型，计算出订单最终金额，并返回给前端
 * 2 在springboot的controller中调通这个接口并返回
 * <p>
 * 要求
 * 1 将代码上传到gitee或者github 并截图反馈本次编程题目代码所在的位置
 * 2 笔试时间 30分钟
 * @date: 2024-10-31 17:50
 * @author: liuziqing
 */
@RestController
public class OrderController {


    @PostMapping("/order/calculate")
    public BigDecimal calc(@RequestBody @Validated OrderVO orderVO) {
        // 实际上价格需要从数据库中查询，这里为了简单，直接赋值
        Order order = new Order(orderVO.getProductId(), orderVO.getDiscountType(), orderVO.getTotalPrice());
        return order.getDiscountStrategy().calculate();

    }


}

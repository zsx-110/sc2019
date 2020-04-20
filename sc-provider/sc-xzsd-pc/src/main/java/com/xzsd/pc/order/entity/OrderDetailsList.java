package com.xzsd.pc.order.entity;

import java.util.List;

/**
 * 封装数据实体类
 * @author zsx
 * @date 2020-04-19
 */
public class OrderDetailsList {
    private List<OrderDetails> orderDeepenList;

    public List<OrderDetails> getOrderDeepenList() {
        return orderDeepenList;
    }

    public void setOrderDeepenList(List<OrderDetails> orderDeepenList) {
        this.orderDeepenList = orderDeepenList;
    }
}

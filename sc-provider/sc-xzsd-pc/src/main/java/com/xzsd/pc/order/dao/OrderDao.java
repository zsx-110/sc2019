package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName orderDao
 * @Description order
 * @author zsx
 * @date 2020-04-19
 */
@Mapper
public interface OrderDao {

    /**
     * 查询订单列表（分页）
     * @param orderInfo
     * @return
     */
    List<OrderVO> getListOrder(OrderInfo orderInfo);

    /**
     * 管理员查询全部订单（分页）
     * @param orderInfo
     * @return
     */
    List<OrderVO> getListOrderByAdmin(OrderInfo orderInfo);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetails> getOrderDetailsById(@Param("orderId") String orderId);

    /**
     * 修改订单状态
     * @param orderList
     * @return
     */
    int updateOrderStatus(@Param("orderList") List<OrderInfo> orderList);
}

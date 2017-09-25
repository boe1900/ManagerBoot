package com.managerboot.service.demo.mybatis.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * Created by huabo on 2017/9/25.
 */
@TableName("t_order")
public class Order {

    private static final long serialVersionUID = 1L;



    @TableId(value="order_id")
    private Long orderId;

    private Long userId;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

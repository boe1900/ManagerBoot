package com.managerboot.service.demo.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.managerboot.service.demo.mybatis.entity.Order;
import com.managerboot.service.demo.mybatis.entity.UpmsUser;
import org.springframework.stereotype.Repository;


/**
 * <p>
  * 用户 Mapper 接口
 * </p>
 *
 * @author huabo
 * @since 2017-05-26
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {

}
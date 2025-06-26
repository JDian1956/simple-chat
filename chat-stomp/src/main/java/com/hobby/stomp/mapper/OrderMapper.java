package com.hobby.stomp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hobby.stomp.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Harris
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
}

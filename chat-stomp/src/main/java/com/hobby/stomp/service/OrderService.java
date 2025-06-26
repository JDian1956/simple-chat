package com.hobby.stomp.service;

import com.hobby.stomp.entity.OrderEntity;
import com.hobby.stomp.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Harris
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    public int insert(OrderEntity entity) {
        return orderMapper.insert(entity);
    }

    public int deleteById(Long id) {
        return orderMapper.deleteById(id);
    }

    public int updateById(OrderEntity entity) {
        return orderMapper.updateById(entity);
    }
}

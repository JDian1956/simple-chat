package com.hobby.others.sevice;

import com.hobby.others.entity.StockEntity;
import com.hobby.others.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Harris
 */
@Service
@RequiredArgsConstructor
public class StockService {
    private final StockMapper stockMapper;

    public int insert(StockEntity entity) {
        return stockMapper.insert(entity);
    }

    public int deleteById(Long id) {
        return stockMapper.deleteById(id);
    }

    public int updateById(StockEntity entity) {
        return stockMapper.updateById(entity);
    }
}

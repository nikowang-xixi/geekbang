package org.xq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xq.domain.OrderDO;
import org.xq.mapper.OrderMapper;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public void add(OrderDO orderDO) {
        OrderDO existOrder = orderMapper.selectById(1);
        System.out.println(existOrder);

        orderMapper.insert(orderDO);

        existOrder = orderMapper.selectById(1);
        System.out.println(existOrder);
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }
}

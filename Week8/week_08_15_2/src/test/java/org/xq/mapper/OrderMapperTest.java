package org.xq.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xq.Application;
import org.xq.domain.OrderDO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderDO orderDO = orderMapper.selectById(1);
        System.out.println(orderDO);
    }

    @Test
    public void testInsert() {
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(6L);
        orderMapper.insert(orderDO);
    }
}
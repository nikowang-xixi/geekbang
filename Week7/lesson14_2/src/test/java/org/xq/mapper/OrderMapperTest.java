package org.xq.mapper;


import org.apache.shardingsphere.api.hint.HintManager;
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

    /**
     * 测试读取
     * 读 从库
     */
    @Test
    public void testSelectByIdFromSalve() {
        for (int i = 0; i < 10; i++) {
            OrderDO orderDO = orderMapper.selectById(1);
            System.out.println(orderDO);
        }
    }

    /**
     * 强制从主库读取
     */
    @Test
    public void testSelectByIdFromMaster() {
        HintManager.getInstance().setMasterRouteOnly();
        OrderDO orderDO = orderMapper.selectById(1);
        System.out.println(orderDO);
    }


    /**
     * 测试写入
     */
    @Test
    public void testInsert() {
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(10);
        orderMapper.insert(orderDO);
    }

}
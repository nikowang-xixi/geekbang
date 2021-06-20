package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static homework.JDBCHelper.getConnection;

/**
 * 批量插入数据
 */
public class BatchInsert {
    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        String orderSql = "insert  emall_order\n" +
                "(gmt_create, gmt_modified, country_id, province_id, city_id, district_id, street_id, address, order_amount, ship_fee, remark, order_sn, store_id, order_status, shipping_status)\n" +
                "values\n" +
                "(unix_timestamp(now()), unix_timestamp(now()),1,11,111,111,1111,'XXXX',(last_insert_id()+1) * 100, 0, concat('订单备注', last_insert_id()+1), concat('ORDERSN', last_insert_id()+1),1,'YXD','WFH');";

        PreparedStatement preparedStatement = connection.prepareStatement(orderSql);
        for (int i = 0; i < 10000000; i++) {
            preparedStatement.execute();
        }
        System.out.println("批量插入数据完成");
    }


}

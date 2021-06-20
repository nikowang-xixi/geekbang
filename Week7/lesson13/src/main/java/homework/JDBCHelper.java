package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static homework.JDBCConstant.*;


public class JDBCHelper {

    private static Connection connection;

    private JDBCHelper() {}

    public static Statement getStatement() throws Exception {
        Connection connection = getConnection();
        JDBCHelper.connection = connection;
        return connection.createStatement();
    }

    public static void release(ResultSet resultSet, Statement statement) throws Exception {
        if (null != resultSet) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (null != connection) {
            connection.close();
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER_NAME, PWD);
    }

}

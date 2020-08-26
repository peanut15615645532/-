package utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JDBC {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public JDBC(){}

    public  Connection getConnection(HttpServletRequest request) throws SQLException {
        Connection connection = null;
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("key");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            connection = (Connection)iterator.next();
            boolean flag = (boolean)map.get(connection);
            if (flag==true){
                map.put(connection,false);
                break;
            }
        }
        return connection;
    }

    public  Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet,HttpServletRequest request){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("key");
        map.put(connection,true);
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

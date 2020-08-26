package dao;

import entity.Users;
import utils.JDBC;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    JDBC jdbc = new JDBC();
    public int add(Users user, HttpServletRequest request){
        int result = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement("insert users(userName,password,sex,email) values (?,?,?,?)");
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getSex());
            preparedStatement.setString(4,user.getEmail());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return result;
    }
    public List findAll(HttpServletRequest request){
        String sql = "select * from users";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Users> usersList = new ArrayList<>();
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer userId = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                String sex = resultSet.getString(4);
                String email = resultSet.getString(5);
                Users user = new Users(userId,userName,password,sex,email);
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return usersList;
    }
    public int delete(String userId,HttpServletRequest request){
        String sql = "delete from users where userId=?";
        JDBC jdbc = new JDBC();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return result;
    }
    public int login(String userName,String password,HttpServletRequest request){
        JDBC jdbc = new JDBC();
        String sql = "select count(*) from users where userName=? and password=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return result;
    }
}

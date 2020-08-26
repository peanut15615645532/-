package dao;

import entity.Question;
import utils.JDBC;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    JDBC jdbc = new JDBC();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public int add(Question question, HttpServletRequest request){
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
        int result = 0;
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,question.getTitle());
            preparedStatement.setString(2,question.getOptionA());
            preparedStatement.setString(3,question.getOptionB());
            preparedStatement.setString(4,question.getOptionC());
            preparedStatement.setString(5,question.getOptionD());
            preparedStatement.setString(6,question.getAnswer());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return result;
    }

    public List findall(HttpServletRequest request){
        String sql = "select * from question";
        List<Question> questionList = new ArrayList<>();
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer questionId = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String optionA = resultSet.getString(3);
                String optionB = resultSet.getString(4);
                String optionC = resultSet.getString(5);
                String optionD = resultSet.getString(6);
                String answer = resultSet.getString(7);
                Question question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet);
        }
        return questionList;
    }

    public int delete(String questionId,HttpServletRequest request){
        String sql = "delete from question where questionId=?";
        int result = 0;
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,questionId);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return result;
    }

    public Question findById(String questionId,HttpServletRequest request){
        String sql = "select * from question where questionId=?";
        Question question = null;
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,questionId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer question_Id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String optionA = resultSet.getString(3);
                String optionB = resultSet.getString(4);
                String optionC = resultSet.getString(5);
                String optionD = resultSet.getString(6);
                String answer = resultSet.getString(7);
                question = new Question(question_Id,title,optionA,optionB,optionC,optionD,answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return question;
    }

    public int update(Question question,HttpServletRequest request){
        String sql = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        int result = 0;
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,question.getTitle());
            preparedStatement.setString(2,question.getOptionA());
            preparedStatement.setString(3,question.getOptionB());
            preparedStatement.setString(4,question.getOptionC());
            preparedStatement.setString(5,question.getOptionD());
            preparedStatement.setString(6,question.getAnswer());
            preparedStatement.setInt(7,question.getQuestionId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet,request);
        }
        return result;
    }

    public List findRand(HttpServletRequest request){
        String sql = "select * from question order by rand() limit 0,4";
        List<Question> questionList = new ArrayList<>();
        try {
            connection = jdbc.getConnection(request);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer questionId = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String optionA = resultSet.getString(3);
                String optionB = resultSet.getString(4);
                String optionC = resultSet.getString(5);
                String optionD = resultSet.getString(6);
                String answer = resultSet.getString(7);
                Question question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc.close(connection,preparedStatement,resultSet);
        }
        return questionList;
    }
}

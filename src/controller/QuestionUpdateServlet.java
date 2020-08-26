package controller;

import dao.QuestionDao;
import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId,title,optionA,optionB,optionC,optionD,answer;
        QuestionDao questionDao = new QuestionDao();
        Question question = null;
        questionId = request.getParameter("questionId");
        title= request.getParameter("title");
        optionA= request.getParameter("optionA");
        optionB= request.getParameter("optionB");
        optionC= request.getParameter("optionC");
        optionD= request.getParameter("optionD");
        answer= request.getParameter("answer");

        question = new Question(Integer.valueOf(questionId),title,optionA,optionB,optionC,optionD,answer);
        int result = questionDao.update(question,request);

        if(result == 1){
            request.setAttribute("info","试题更新成功");
        }else{
            request.setAttribute("info","试题更新失败");
        }

        request.getRequestDispatcher("/info.jsp").forward(request,response);

    }
}

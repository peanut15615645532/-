package controller;

import dao.QuestionDao;
import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        QuestionDao questionDao = new QuestionDao();
        Question question = null;
        int result;
        title= request.getParameter("title");
        optionA= request.getParameter("optionA");
        optionB= request.getParameter("optionB");
        optionC= request.getParameter("optionC");
        optionD= request.getParameter("optionD");
        answer= request.getParameter("answer");
        question = new Question(null,title,optionA,optionB,optionC,optionD,answer);

        result = questionDao.add(question,request);

        if(result == 1){
            request.setAttribute("info","试题添加成功");
        }else{
            request.setAttribute("info","试题添加失败");
        }

        request.getRequestDispatcher("/info.jsp").forward(request,response);

    }
}

package controller;

import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Question> questionList = null;
        questionList = (List) session.getAttribute("List");
        int score = 0;
        for(Question question:questionList){
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String userAnswer = request.getParameter("answer_"+question.getQuestionId());
            if(userAnswer.equals(answer)){
                score+=25;
            }
        }

        request.setAttribute("info","本次考试成绩：" + score);
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}

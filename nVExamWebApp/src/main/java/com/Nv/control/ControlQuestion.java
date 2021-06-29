/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nv.control;

import com.Nv.dao.DAO;
import com.Nv.entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;
import com.Nv.entity.Question;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author pc
 */
public class ControlQuestion extends HttpServlet {

    private com.Nv.dao.DAO dao;
    @Resource(name = "jdbc/nv_exam_db")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            this.dao = new DAO(this.dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String command = "";
        try {
            command = request.getParameter("command").toLowerCase();
        } catch (Exception e) {

        }

        switch (command) {
            case "all_question":
                showQuestion(request, response);
                break;
            case "all_category":
                showCategory(request, response);
                break;
            case "add_question":
                addQuestion(request, response);
                break;
            case "add_category":
                addCategory(request, response);
                break;
            case "send_ques_to_update":
                sendQuestionToUpdate(request, response);
                break;
            case "update_ques":
                updateQues(request, response);
                break;
            default:
                showCategory(request, response);
                break;
        }

    }

    private void showQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            //Get questions from DB
            List<Question> quesList = dao.getAllQuestion();
            //set 
            request.setAttribute("question_list", quesList);
            //Send to jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/jsp/admin/question.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            printStackTrace(e);
        }

    }

    private void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> catList = dao.getAllCategory();
            request.setAttribute("cat_list", catList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/jsp/admin/category.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            printStackTrace(e);
        }
    }

    private void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            if (request.getParameter("ques_des") != null) {
                String quesDes = request.getParameter("ques_des");
                String opt1 = request.getParameter("opt1");
                String opt2 = request.getParameter("opt2");
                String opt3 = request.getParameter("opt3");
                String opt4 = request.getParameter("opt4");
                String opt5 = request.getParameter("opt5");
                String opt6 = request.getParameter("opt6");
                StringBuffer sb = new StringBuffer();
                for (String parameterValue : request.getParameterValues("correct-ans")) {
                    sb.append(parameterValue);
                }
                String correctAns = sb.toString();
                int category = Integer.parseInt(request.getParameter("category"));
                int status = Integer.parseInt(request.getParameter("status"));
                Question newQues = new Question(quesDes, correctAns, opt1, opt2, opt3, opt4, opt5, opt6, category, status);
                dao.addQuestion(newQues);
                showQuestion(request, response);
            } else {
                //Send out category for drop down selection
                List<Category> catList = dao.getAllCategory();
                request.setAttribute("cat_list", catList);
                //Redirect to addding form
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/jsp/admin/add_question.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            printStackTrace(e);
        }
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("cat_title") != null) {
                //Get info from submiited form
                String catTitle = request.getParameter("cat_title");
                //Capital first word
                catTitle = catTitle.substring(0, 1).toUpperCase() + catTitle.substring(1).toLowerCase();
                String catImg = request.getParameter("cat_img");

                dao.addCategory(new Category(catTitle, catImg));
                showCategory(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/jsp/admin/add_category.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            printStackTrace(e);
        }
    }

    private void sendQuestionToUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Question theQuestion = dao.findQuestion(Integer.parseInt(request.getParameter("quesId")));
            request.setAttribute("the_question", theQuestion);
            List<Category> catList = dao.getAllCategory();
            request.setAttribute("cat_list", catList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/jsp/admin/update_question.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {

        }
    }

    private void updateQues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            int ID = Integer.parseInt(request.getParameter("ques_ID"));
            String quesDes = request.getParameter("ques_des");
            String opt1 = request.getParameter("opt1");
            String opt2 = request.getParameter("opt2");
            String opt3 = request.getParameter("opt3");
            String opt4 = request.getParameter("opt4");
            String opt5 = request.getParameter("opt5");
            String opt6 = request.getParameter("opt6");
            StringBuffer sb = new StringBuffer();
            for (String parameterValue : request.getParameterValues("correct-ans")) {
                sb.append(parameterValue);
            }
            String correctAns = sb.toString();
            int category = Integer.parseInt(request.getParameter("category"));
            int status = Integer.parseInt(request.getParameter("status"));
            Question theQuestion = new Question(ID, quesDes, correctAns, opt1, opt2, opt3, opt4, opt5, opt6, category, status);

            dao.updateQuestion(theQuestion);
            showQuestion(request, response);

        } catch (Exception e) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
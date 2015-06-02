/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import Accounts.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toshiba
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        DataBase d = new DataBase();
        d.connect();
        ArrayList l = new ArrayList();
        l = d.select("select * from accounts where name='"+username+"' and password='"+password+"'", password);
        d.close();
       
        if(l == null){
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("id", l.get(0));
            session.setAttribute("type", l.get(1));
            session.setAttribute("name", l.get(2));
            System.out.println(session.getAttribute("id").toString());
            System.out.println(session.getAttribute("type").toString());
            System.out.println(session.getAttribute("name").toString());
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.forward(request,response); 
        }
        }
        catch (Exception e){
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.forward(request,response);     
        }
        
    }

}

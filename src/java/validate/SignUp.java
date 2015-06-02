/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import Accounts.DataBase;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toshiba
 */
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        DataBase db = new DataBase();
        db.connect();
        db.insert("INSERT INTO ACCOUNTS (name , password, type) VALUES ('"+request.getParameter("userName")+"', '"+request.getParameter("userPass")+"' , 1)");
        RequestDispatcher rd=request.getRequestDispatcher("post-creation.jsp");    
        rd.forward(request,response); 
        }catch (Exception e){
            out.println("Error!");
            RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");    
            rd.forward(request,response); 
        }
    }

}

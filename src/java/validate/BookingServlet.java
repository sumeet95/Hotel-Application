/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import Accounts.DataBase;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "BookingServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        DataBase db = new DataBase();
        HttpSession session = request.getSession();
        db.connect();
        db.bookRooms( request.getParameter("rid") , (String) session.getAttribute("id")   );
        RequestDispatcher rd=request.getRequestDispatcher("room_booked.jsp");    
        rd.forward(request,response); 
        } catch(Exception e) {
            RequestDispatcher rd=request.getRequestDispatcher("reservation.jsp");    
        rd.forward(request,response); 
        }
    }


}

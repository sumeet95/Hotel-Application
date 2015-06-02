package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import Rooms.Room;
import java.util.ArrayList;
import Accounts.*;

public final class reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    DataBase db = new DataBase();
    Rooms rooms;
    User user;
    Connection connection;
    PreparedStatement pstatement;

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Humber Hotel</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("<script src=\"js/jquery.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/jquery-ui.css\" />\n");
      out.write("<script src=\"js/jquery-ui.js\"></script>\n");
      out.write("\t\t  <script>\n");
      out.write("\t\t\t\t  $(function() {\n");
      out.write("\t\t\t\t    $( \"#datepicker,#datepicker1\" ).datepicker();\n");
      out.write("\t\t\t\t  });\n");
      out.write("\t\t  </script>\n");
      out.write("<!---/End-date-piker---->\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/JFGrid.css\" />\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/JFFormStyle-1.css\" />\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/JFCore.js\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/JFForms.js\"></script>\n");
      out.write("\t\t\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t\t(function() {\n");
      out.write("\t\t\t\tJC.init({\n");
      out.write("\t\t\t\t\tdomainKey: ''\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\t})();\n");
      out.write("\t\t</script>\n");
      out.write("<!--nav-->\n");
      out.write("<script>\n");
      out.write("\t\t$(function() {\n");
      out.write("\t\t\tvar pull \t\t= $('#pull');\n");
      out.write("\t\t\t\tmenu \t\t= $('nav ul');\n");
      out.write("\t\t\t\tmenuHeight\t= menu.height();\n");
      out.write("\n");
      out.write("\t\t\t$(pull).on('click', function(e) {\n");
      out.write("\t\t\t\te.preventDefault();\n");
      out.write("\t\t\t\tmenu.slideToggle();\n");
      out.write("\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\t$(window).resize(function(){\n");
      out.write("        \t\tvar w = $(window).width();\n");
      out.write("        \t\tif(w > 320 && menu.is(':hidden')) {\n");
      out.write("        \t\t\tmenu.removeAttr('style');\n");
      out.write("        \t\t}\n");
      out.write("    \t\t});\n");
      out.write("\t\t});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- start header -->\n");
      out.write("<div class=\"header_bg\">\n");
      out.write("<div class=\"wrap\">\n");
      out.write("\t<div class=\"header\">\n");
      out.write("\t\t<div class=\"logo\">\n");
      out.write("\t\t\t<a href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"\"></a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"h_right\">\n");
      out.write("\t\t\t<!--start menu -->\n");
      out.write("\t\t\t<ul class=\"menu\">\n");
      out.write("\t\t\t\t<li><a href=\"index.jsp\">hotel</a></li> |\n");
      out.write("\t\t\t\t<li><a href=\"rooms.jsp\">rooms & suits</a></li> |\n");
      out.write("\t\t\t\t<li class=\"active\"><a href=\"reservation.jsp\">reservation</a></li> |\n");
      out.write("\t\t\t\t<li><a href=\"activities.jsp\">galery</a></li> |\n");
      out.write("\t\t\t\t<li><a href=\"contact.jsp\">contact</a></li>\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<!-- \n");
      out.write("\t\t\t\t\n");
      out.write("                    -->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t<div class=\"top-nav\">\n");
      out.write("\t\t<nav class=\"clearfix\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t<li class=\"active\"><a href=\"index.jsp\">hotel</a></li> \n");
      out.write("\t\t\t\t<li><a href=\"rooms.jsp\">rooms & suits</a></li> \n");
      out.write("\t\t\t\t<li><a href=\"reservation.jsp\">reservation</a></li> \n");
      out.write("\t\t\t\t<li><a href=\"activities.jsp\">galery</a></li> \n");
      out.write("\t\t\t\t<li><a href=\"contact.jsp\">contact</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t<a href=\"#\" id=\"pull\">Menu</a>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<!--start main -->\n");
      out.write("<div class=\"main_bg\">\n");
      out.write("<div class=\"wrap\">\n");
      out.write("\t<div class=\"main\">\n");
      out.write("\t\t<div class=\"res_online\">\n");
      out.write("\t\t\t<h4>find a room</h4>\n");
      out.write("\t\t\t<p class=\"para\">Search our big database to find the best room for you. With far more space than an ordinary hotel room, our condominium-sized suites provide you with plenty of room to stretch out and relax. Available with one or two bedrooms, each suite includes a fully equipped kitchen and dining area, ensuite laundry facilities, windows that open, and complimentary wireless high-speed Internet access.\n");
      out.write("Business travelers won?t have to make their bedroom their office. Our spacious living rooms include a desk and are an ideal place to hold small meetings or socialize with coworkers.\n");
      out.write("Parents, imagine being able to tuck your kids into bed, and having some quiet time of your own to enjoy a movie in a separate room. If you are planning a romantic evening out, Les Suites offers childcare services, available on request.\n");
      out.write("Our two-bedroom suites make it easy for traveling friends to share a suite and still have the privacy of separate sleeping areas.\n");
      out.write("Les Suites Hotel Ottawa makes your stay an experience closer to home.</p>\n");
      out.write("\t\t</div>\t\t\t\n");
      out.write("\t\t\t<div class=\"span_of_2\">\n");
      out.write("\t\t\t\t<div class=\"span2_of_1\">\n");
      out.write("\t\t\t\t\t<h4>check-in:</h4>\n");
      out.write("\t\t\t\t\t<div class=\"book_date btm\">\n");
      out.write("\t\t\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t\t\t<input class=\"date\" id=\"datepicker1\" type=\"text\" value=\"DD/MM/YY\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'DD/MM/YY';}\">\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t<div class=\"sel_room\">\n");
      out.write("\t\t\t\t\t\t<h4>type of rooms</h4>\n");
      out.write("\t\t\t\t\t\t<select name=\"roomType\" id=\"country\" onchange=\"change_country(this.value)\" class=\"frm-field required\">\n");
      out.write("\t\t\t\t\t\t\t<option value=\"null\">Select a type of Room</option>\n");
      out.write("\t\t\t\t            <option value=\"Suite room\">Suite room</option>         \n");
      out.write("\t\t\t\t            <option value=\"Single room\">Single room</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"AX\">Double room</option>\n");
      out.write("\t\t        \t\t</select>\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t<div class=\"sel_room left\">\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"span2_of_1\">\n");
      out.write("\t\t\t\t\t<h4>check-out:</h4>\n");
      out.write("\t\t\t\t\t<div class=\"book_date btm\">\n");
      out.write("\t\t\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t\t\t<input class=\"date\" id=\"datepicker1\" type=\"text\" value=\"DD/MM/YY\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'DD/MM/YY';}\">\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t<div class=\"sel_room\">\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t<div class=\"sel_room left\">\n");
      out.write("\t\t\t\t\t\t<h4>Number of pets:</h4>\n");
      out.write("\t\t\t\t\t\t<select id=\"country\" onchange=\"change_country(this.value)\" class=\"frm-field required\">\n");
      out.write("\t\t\t\t\t\t\t<option value=\"null\">0</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"null\">Just kidding, no pets allowed lol</option>\n");
      out.write("\t\t\t\t            \n");
      out.write("\t\t        \t\t</select>\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"res_btn\">\n");
      out.write("\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t<input name=\"submitSearch\" type=\"submit\" value=\"search now &nbsp; &#128269; \" style=\"width: 280px;\">\n");
      out.write("\t\t\t\t</form>\n");
      out.write("                <br>\n");
      out.write("                <form>\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"submitSuite\" value=\"book now\" style=\"width: 280px;\">\n");
      out.write("       ");
 if(request.getParameter("submitSuite")!=null)
       {
        
      out.write("\n");
      out.write("         \n");
      out.write("         ");
  //db.connect();
           //int userid = (Integer) session.getAttribute("id");
             //       int roomid= Integer.parseInt( request.getParameter("rid"));
               //     String special= request.getParameter("special");
        // db.bookRoom(roomid, userid, special);
         //db.close();
  out.println("Congractulations room has been booked");
} 
      out.write("\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("            ");

                if(request.getParameter("submitSearch") != null){
       
                    db.connect();
                    
        ArrayList<Room> rooms = db.selectAllRooms(); 
      out.write("\n");
      out.write("        \n");
      out.write("        <p> There are currently <i>");
      out.print( rooms.size() );
      out.write("</i> rooms available</h2>\n");
      out.write("                    <ol>\n");
      out.write("                        ");
 for(int i=0; i < rooms.size();i++){  
      out.write("\n");
      out.write("                        \n");
      out.write("<li value =");
 rooms.get(i).getRoomId(); 
      out.write(" > Room ID is ");
      out.print( rooms.get(i).getRoomId() );
      out.write(" and Room type is ");
      out.print( rooms.get(i).getName() );
      out.write("  </li>    \n");
      out.write("\n");
      out.write("                        ");
 }   
      out.write("\n");
      out.write("                    </ol>\n");
      out.write("                ");
 db.close(); } 
      out.write("\n");
      out.write("                <form>\n");
      out.write("                    \n");
      out.write("       ");

                //AQEEL
//I added these two text fields to get the room id and special requests from the users
      out.write("\n");
      out.write("       <br>Enter ROOM ID: <br>\n");
      out.write("<input type=\"number\" name=\"rid\" value=\"\">\n");
      out.write("<br>\n");
      out.write("<br>Enter any special Requests: <br>\n");
      out.write("<input type=\"text\" name=\"special\" value=\"\">\n");
      out.write("<br>\n");
      out.write("</form>\n");
      out.write("         ");

                if(request.getParameter("submitSuite")!=null){
         
         }
         
      out.write("   \n");
      out.write("          \n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</div>\t\n");
      out.write("<!--start main -->\n");
      out.write("<div class=\"footer_bg\">\n");
      out.write("<div class=\"wrap\">\n");
      out.write("<div class=\"footer\">\n");
      out.write("\t\t\t<div class=\"copy\">\n");
      out.write("\t\t\t\t<p class=\"link\"><span>© All rights reserved | Developed by&nbsp;<a href=\"http://humber.ca//\"> Humber Hotel</a></span></p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"f_nav\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a href=\"index.jsp\">home</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"rooms.jsp\">rooms & suits</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"reservation.jsp\">reservation</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"contact.jsp\">Contact</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"soc_icons\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a class=\"icon1\" href=\"#\"></a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"icon2\" href=\"#\"></a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"icon3\" href=\"#\"></a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"icon4\" href=\"#\"></a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"icon5\" href=\"#\"></a></li>\n");
      out.write("\t\t\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\t\t</ul>\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"clear\"></div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\t\t\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");

    if (request.getParameter("submitSuite") != null) {
        db.connect();
        user = new User(((User) session.getAttribute("Session")), "Suite");
        int i = Integer.parseInt(db.select("SELECT * FROM ROOMS WHERE ROOMTYPE = 'Suite' AND BOOKED = '1'", "ROOMNUMBER").get(0).toString());
        user.getRoom().roomNum = String.valueOf(i);
        db.insertBookRoom(i, user.getUsername(), request.getParameter("specialRequest"), request.getParameter("startDate"), request.getParameter("finishDate"));
        db.insert("UPDATE ROOMS SET BOOKED = '0' WHERE ROOMNUMBER = " + user.getRoom().roomNum);
        db.close();
        session.setAttribute("Session", user);
        request.setAttribute("startDate", request.getParameter("startDate"));
        request.setAttribute("finishDate", request.getParameter("finishDate"));
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

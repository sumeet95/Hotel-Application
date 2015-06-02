<%-- 
    Document   : editRooms
    Created on : Apr 9, 2015, 3:06:11 AM
    Author     : Toshiba
--%>

<%@page import="room.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Accounts.DataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    

        <title>Humber Hotel</title>
        <meta HTTP-EQUIV=Expires CONTENT="0">
        <meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script src="js/jquery.min.js"></script>
        <link type="text/css" rel="stylesheet" href="css/JFGrid.css" />
        <link type="text/css" rel="stylesheet" href="css/JFFormStyle-1.css" />
        <script type="text/javascript" src="js/JFCore.js"></script>
        <script type="text/javascript" src="js/JFForms.js"></script>

        <script type="text/javascript">
            (function () {
                JC.init({
                    domainKey: ''
                });
            })();
        </script>
        <!--nav-->
        <script>
            $(function () {
                var pull = $('#pull');
                menu = $('nav ul');
                menuHeight = menu.height();

                $(pull).on('click', function (e) {
                    e.preventDefault();
                    menu.slideToggle();
                });

                $(window).resize(function () {
                    var w = $(window).width();
                    if (w > 320 && menu.is(':hidden')) {
                        menu.removeAttr('style');
                    }
                });
            });


        </script>
    </head>
    <body>
        <!-- start header -->
        <div class="header_bg">
            <div class="wrap">
                <div class="header">
                    <div class="logo">
                        <a href="index.jsp"><img src="images/logo.png" alt=""></a>
                    </div>
                    <div class="h_right">
                        <!--start menu -->
                        <ul class="menu">
                            <li><a href="index.jsp">hotel</a></li> |
                            <li><a href="rooms.jsp">rooms & suits</a></li> |
                            <li><a href="reservation.jsp">reservation</a></li> |
                            <li><a href="activities.jsp">gallery</a></li> |
                            <li class="active"><a href="contact.jsp">contact</a></li>
                            <div class="clear"></div>
                        </ul>

                    </div>
                    <div class="clear"></div>
                    <div class="top-nav">
                        <nav class="clearfix">
                            <ul>
                                <li class="active"><a href="index.jsp">hotel</a></li> 
                                <li><a href="rooms.jsp">rooms & suits</a></li> 
                                <li><a href="reservation.jsp">reservation</a></li> 
                                <li><a href="activities.jsp">gallery</a></li> 
                                <li><a href="contact.jsp">contact</a></li>
                            </ul>
                            <a href="#" id="pull">Menu</a>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <!--start main -->
        <div class="main_bg">
            <div class="wrap">
                <div class="content">
                    <%
                        DataBase db = new DataBase();
                        db.connect();
                        ArrayList<Room> rooms = db.selectAllRooms();
                    %>
                    <br><br>
                    <h1>Edit Rooms</h1>
                    <%
                        for (int i = 0; i < rooms.size(); i++) {
                            out.println("Room ID    : " + rooms.get(i).getRoomId() + "<br>");
                            out.println("Name       : " + rooms.get(i).getName() + "<br>");
                            out.println("Location   : " + rooms.get(i).getLocation() + "<br>");
                            out.println("Type       : " + rooms.get(i).getRoomType() + "<br>");
                            out.println("Status     : " + rooms.get(i).getStatus() + "<br>");
                            out.println("Description: " + rooms.get(i).getDescription() + "<br>");
                            out.println("<br><br>");
                        }
                        db.close();
                    %>
                </div>

                <br><br>
                <div class="sidebar">
                    <input checked="checked" type="radio" name="user_level" id="rd1" value="add"/>
                    <label for="rd1">Add Room</label><br/>
                    <div id="addDiv" style="display:none;">
                        <%
                            if (request.getParameter("name") == null) {
                                
                            } else {
                                db.connect();
                            db.insert("INSERT INTO ROOMS (name , location, description , status, roomtype) VALUES ('"+request.getParameter("name")+"',+'"+request.getParameter("loc")+"','"+request.getParameter("description")+"'," + request.getParameter("status") + ", '" + request.getParameter("type") +"')");
                            db.close();
                        %>
                            <jsp:forward page="Inserted.jsp" />
                            <%
                                    
                            }
                        %>
                            <form action="editRooms.jsp" method="GET">
                               <div id="boxalign2" class="boxalign2">
                                   <label for="name">Name:</label><input class="rounded2" name="name" type="text" style="width: 100px!important; " required/> <br/><br/>
                                <label for="loc">Location:</label><input class="rounded2" name="loc" type="text" style="width: 100px!important;" required/> <br/>
                                <label for="type">Type:</label>
                                <select name="type" style="width: 115px!important;" required>
                                    <option value="Single Room">Single</option>
                                    <option value="Double Room">Double</option>
                                    <option value="Suite Room">Suite</option>
                                </select> <br/>
                                <label for="status">Status:</label>
                                <select name="status" style="width: 115px!important;" required>
                                    <option value="0">Free</option>
                                    <option value="1">Reserved</option>
                                </select> <br/>
                                <label for="description">Description:</label>
                                <textarea rows="4" cols="50" name="description" style="width: 230px!important" required>
                                </textarea> <br />
                                <input type="Submit" value="Add" style="width: 55px!important;" />
                               </div>
                            </form>
                            <br>
                        </div>
                        <input type="radio" name="user_level" id="rd2" value="delete"/>                      
                        <label for="rd2">Delete Room</label><br/>
                        <div id="deleteDiv" style="display:none;">
                            <%
                                if(request.getParameter("id") == null){
                                    
                                } else {
                                    db.connect();
                                    db.delete(request.getParameter("id"));
                                    db.close();
                                }
                            %>
                            <form action="editRooms.jsp" method="GET">
                                ID: <input name="id" type="text" style="width: 100px!important;" />
                                <input type="Submit" value="Delete" style="width: 55px!important;" />
                            </form>
                            <br>
                        </div>
                        <input type="radio" name="user_level" id="rd3" value="modify"/>
                        <label for="rd3">Modify Room</label><br/>
                        <input type="button" value="Select" onClick="show()"/>
                         <div id="modifyDiv" style="display:none;">
                        <%
                            if (request.getParameter("modID") == null) {
                                
                            } else {
                                db.connect();
                            db.insert("update ROOMS set name='"+request.getParameter("modName")+"',description='"+request.getParameter("modDescription")+ "' where roomid=" + request.getParameter("modID") );
                            db.close();
                        %>
                            <jsp:forward page="Inserted.jsp" />
                            <%
                                    
                            }
                        %>
                            <form action="editRooms.jsp" method="GET">
                               
                                   ID: <input name="modID" type="text" style="width: 100px!important;" /> <br/><br/>
                                   <label for="modName">Name:</label>
                                   <input class="rounded2" name="modName" type="text" style="width: 100px!important; " required/> <br/><br/>
                                    <label for="modDescription">Description:</label>
                                    <textarea rows="4" cols="50" name="modDescription" style="width: 230px!important" required>
                                    </textarea> <br />
                                <input type="Submit" value="Modify" style="width: 55px!important;" />
                               
                            </form>
                            <br>
                        </div>
                </div>

            </div>

            <script>
                function Delete() {
                        <%
                        db.delete(request.getParameter("id"));
                        System.out.print(request.getParameter("id"));
                        %>
                                alert("sd");
                }
                
                function show() {
                    if (document.getElementById('rd2').checked) {
                        document.getElementById("deleteDiv").style.display = "";
                    }
                    
                    if (document.getElementById('rd1').checked) {
                        document.getElementById("addDiv").style.display = "";
                    }
                    
                    if (document.getElementById('rd3').checked) {
                        document.getElementById("modifyDiv").style.display = "";
                    }
                }
            </script>

        </div>
        <!--start main -->
        <div class="footer_bg">
            <div class="wrap">


                <div class="footer">
                    <div class="copy">
                        <p class="link"><span>© All rights reserved | Developed by&nbsp;<a href="http://humber.ca//"> Humber Hotel</a></span></p>
                    </div>
                    <div class="f_nav">
                        <ul>
                            <li><a href="index.jsp">home</a></li>
                            <li><a href="rooms.jsp">rooms & suits</a></li>
                            <li><a href="reservation.jsp">reservation</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                        </ul>
                    </div>

                    <div class="soc_icons">
                        <ul>
                            <li><a class="icon1" href="#"></a></li>
                            <li><a class="icon2" href="#"></a></li>
                            <li><a class="icon3" href="#"></a></li>
                            <li><a class="icon4" href="#"></a></li>
                            <li><a class="icon5" href="#"></a></li>
                            <div class="clear"></div>
                        </ul>	
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>		
    </body>
</html>

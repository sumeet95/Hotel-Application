<%@page import="room.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Accounts.DataBase"%>
<html>
<head>
<title>Humber Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/JFGrid.css" />
<link type="text/css" rel="stylesheet" href="css/JFFormStyle-1.css" />
		<script type="text/javascript" src="js/JFCore.js"></script>
		<script type="text/javascript" src="js/JFForms.js"></script>

		<script type="text/javascript">
			(function() {
				JC.init({
					domainKey: ''
				});
				})();
		</script>
<!--nav-->
<script>
		$(function() {
			var pull 		= $('#pull');
				menu 		= $('nav ul');
				menuHeight	= menu.height();

			$(pull).on('click', function(e) {
				e.preventDefault();
				menu.slideToggle();
			});

			$(window).resize(function(){
        		var w = $(window).width();
        		if(w > 320 && menu.is(':hidden')) {
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
				<li><a href="activities.jsp">galery</a></li> |
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
				<li><a href="activities.jsp">galery</a></li> 
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
	<div class="main">
            <h3>My Booked Rooms</h3>
            <%
                        DataBase db = new DataBase();
                        db.connect();
                        ArrayList<Room> rooms = db.selectMyRooms((String)session.getAttribute("id"));
//            ArrayList<Room> rooms = db.selectMyRooms("1");        
            %>
                    <br><br>
                    <h2>You have booked <%= rooms.size() %> rooms with us. Below is the descriptions</h2><br>
                    <h1>My Rooms</h1>
                    <%
                        for (int i = 0; i < rooms.size(); i++) {
                            out.println("Room ID    : " + rooms.get(i).getRoomId() + "<br>");
                            out.println("Name       : " + rooms.get(i).getName() + "<br>");
                            out.println("Location   : " + rooms.get(i).getLocation() + "<br>");
                            out.println("Type       : " + rooms.get(i).getRoomType() + "<br>");
                            //out.println("Status     : " + rooms.get(i).getStatus() + "<br>");
                            out.println("Description: " + rooms.get(i).getDescription() + "<br>");
                            out.println("<br><br>");
                        }
                        db.close();
                    %>
	</div>
</div>
</div>		
<!--start main -->
<div class="footer_bg">
<div class="wrap">
<div class="footer">
			<div class="copy">
				<p class="link"><span>� All rights reserved | Developed by&nbsp;<a href="http://humber.ca//"> Humber Hotel</a></span></p>
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

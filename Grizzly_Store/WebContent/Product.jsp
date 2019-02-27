<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="mystyle.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header col-sm-2">
      <img src="D:\agil\Grizzly_Store\WebContent\images\Grizz2.png" height=60px width=200px>
      </div>
      <div class="navbar-header col-sm-3 headpad">
      <table>
	<tr><td><Input type="text" name="search" placeholder="Search" class="search"></td>
      <td><a href="Search" class="btn btn-info btn-sm">
          <span class="glyphicon glyphicon-search"></span> 
        </a></td></tr>
      </table>
      </div>
      <div class="navbar-header col-sm-3"></div>
    <div class="navbar-header col-sm-3 headpad hname">
    <%	String usrname = request.getParameter("usernme");%>
    <%=	"Welcome,Admin "+ usrname %>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="row"><br><br></div>
<div class="container text-center">    
  <div class="card">
    <div class="col-sm-3 sidenav">
    	<img src="D:\agil\Grizzly_Store\WebContent\images\Prof_head.png" alt="Profile"><br><br>
      <img src="D:\agil\Grizzly_Store\WebContent\images\profile.png" alt="Profile Photo" height="40%" width="45%">
      <%
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/grizzly_store","root","password-1");
		PreparedStatement st=con.prepareStatement("Select Name,ID,Designation,Office from grizzly_store.log_det WHERE Username=?"); 
		st.setString(1, usrname);
		ResultSet rs = st.executeQuery();
		String Name = new String();
		String ID = new String();
		String Designation = new String();
		String Office = new String();
		if (rs.next())
		 	Name = rs.getString("Name");
			ID = rs.getString("ID");
			Designation = rs.getString("Designation");
			Office = rs.getString("Office");
 		con.close();
%>
      	<br><p class="prof_name"><b><%= Name %></b></p>
		<b>ID</b>
		<br><p><%= ID %></p>
		<b>Designation</b>
		<br><p><%= Designation %></p>
		<b>Office</b>
		<br><p><%= Office %></p>	    
    </div>
    <div class="col-sm-1"> </div>
    <div class="col-sm-4 text-left">
    <div class="row"> 
      <ul class="nav nav-pills nav-justified">
    <li class="active"><a href="#">PRODUCTS</a></li>
    <li><a href="#">VENDORS</a></li>
  </ul>
  	</div>
  	<div class="row"><br><br></div>
  	<div class="row">
  	<div class="col">
  	<form action="Add_prod" method="POST" id="add_form">
	<Input type="text" placeholder="Enter Product ID" style="border:none" name="prod_id"> 
	<hr width="50%" align="left">
	<select name="prod_cat" style="border:none">
	<option value="null">Select</option>
    <option value="Personal Care">Personal Care</option>
    <option value="Laptops">Laptops</option>
    <option value="Art Supplies">Art Supplies</option>
  </select>
	<hr width="50%" align="left">
	<Input type="text" placeholder="Name" style="border:none" name="prod_name"> 
	<hr width="50%" align="left">
	<Input type="text" placeholder="Description" style="border:none" name="prod_desc"> 
	<hr width="50%" align="left">
	<Input type="text" placeholder="Price" style="border:none" name="prod_price"> 
	<hr width="50%" align="left">
	<Input type="text" placeholder="Rating" style="border:none" name="prod_rating"> 
	<hr width="50%" align="left">	 
    <button type="submit" id="button2">Add</button>
    <button type="reset" id="button2">Cancel</button>
	</form>  
  	</div>
  	</div>
    </div>
   </div>
	</div>
</body>
</html>

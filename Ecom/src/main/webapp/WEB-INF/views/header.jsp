
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.dropdown-menu {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-menu a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown:hover .dropdown-menu {
    display: block;
}
</style>
</head>
<body>
  <nav class="navbar navbar-inverse" style="background-color:#424558">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="./">BEAUTYPLUS</a>
    </div>
    <ul class="nav navbar-nav">
      
       <c:if test="${pageContext.request.userPrincipal.name  == 'shiphiaphilip@gmail.com'}">
      <li ><a href="admin">Admin</a></li>
      </c:if>
       <c:if test="${pageContext.request.userPrincipal.name  != 'shiphiaphilip@gmail.com'}">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <c:forEach var="c" items="${cat}">
                       <li><a href="selectcat?id=${c.id}">${c.name}</a></li>    
                    </c:forEach>  
        </ul>
      </li></c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name == null }">
      <li><a href="adding"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="logn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name  != 'shiphiaphilip@gmail.com'}">
        <li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name  != null}">
					<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
					<li><a href='<c:url value="/j_spring_security_logout" />'><span class="glyphicon glyphicon-log-out">Logout</a></li>
				</c:if>
      </ul>
  </div></nav>
</body>
</html>

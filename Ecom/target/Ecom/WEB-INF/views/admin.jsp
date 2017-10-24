<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#cat">Category</a></li>
    <li><a data-toggle="tab" href="#prod">Product</a></li>  
    <li><a data-toggle="tab" href="#sup">Supplier</a></li>
     <li><a data-toggle="tab" href="#list">Editor</a></li>
  </ul>
<div class="tab-content">
 
 <div id="cat" class="tab-pane fade in active">
    <form role="form" action="saveCategory" method="post">
      <h3>Category</h3>
     
    <label><b>Category Name</b></label>
    <input type="text"  name="name" id="name" required></br>
    <button type="submit" class="btn btn-default" href="Admin">Save</button>
   </form> </div>
    
 <div id="prod" class="tab-pane fade in active">
 <form role="form" action="saveProduct" method="post" enctype="multipart/form-data">
    
      <h3>Product</h3>
      <label><b>NAME</b></label>
   
     <input type="text" name="name" id="name" required></br>
    <label><b>price</b></label>
    <input type="number"  name="price" id="price" required></br>
    <label><b>stock</b></label>
    <input type="number" name="stock"  id="stock" required></br>
    <div class="form-group"> IMAGE                  
           <input type="file" name="img"  id="img" required/>
        </div>
     <label><b>Category</b></label>
     <select name="cid">
     <c:forEach var = "c" items="${cat}">
          <option value="${c.id}">${c.name}</option>
      </c:forEach>    
     
     </select>
      <label><b>Supplier</b></label>
     <select name="sid">
     <c:forEach var = "s" items="${supp}">
          <option value="${s.id}">${s.name}</option>
      </c:forEach>    
     
     </select>
     
     
    <button type="submit" class="btn btn-default" href="admin">Save</button>
   </form> </div>
    
    
    
    <div id="sup" class="tab-pane fade in active">
    <form role="form" action="saveSupplier">
      <h3>Supplier</h3>
      <label><b>Supplier name</b></label>
    <input type="text" name="name"  id="name" required></br>
    <label><b>Address</b></label>
    <input type="text"  name="address"  id="address" required></br>
    <button type="submit" class="btn btn-default" href="admin">Save</button>
   </form> </div>
    
  
 
 <div id="list" class="tab-pane fade in active">
    <form >
      <h3>List</h3>
      <label><b><a href ="categorylist">List of categories</a></b></label></br>
     <label><b><a href ="productlist">List of products</a></b></label></br>
     <label><b><a href ="supplierlist">List of supplier</a></b></label></br>
   </form> </div>

    </div>
    


<jsp:include page="footer.jsp"/>

</body>
</html>

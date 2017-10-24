<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>update</title>
    <jsp:include page="header.jsp"/>
<div class="container">
            <form action="saveupdateproduct" >
                <h2>Product Update</h2>
  
                <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label">Product ID</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" value="${pro.id }" name="id" autofocus readonly="readonly">
                        <span class="help-block"></span>
                    </div>
                     <div class="col-sm-9">
                     
                      <label><b>Supplier</b></label>
                  <select name="sid">
                 <c:forEach var = "s" items="${supp}">
                     <option value="${s.id}">${s.name}</option>
                   </c:forEach>    
     
                    </select>
     
                    </div>
                     <div class="col-sm-9">
                      <label><b>Category</b></label>
                        <select name="cid">
                    <c:forEach var = "c" items="${cat}">
                     <option value="${c.id}">${c.name}</option>
                    </c:forEach>    
     
                     </select>
                    </div>
                    <label for="firstName" class="col-sm-3 control-label">Product Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="name" value="${pro.name }" name="name" autofocus>
                        <span class="help-block"></span>
                    </div>
                    <label for="firstName" class="col-sm-3 control-label">Price</label>
                    <div class="col-sm-9">
                        <input type="text" id="price" value="${pro.price}" name="price" autofocus>
                        <span class="help-block"></span>
                    </div>
                    <label for="firstName" class="col-sm-3 control-label">Stock</label>
                    <div class="col-sm-9">
                        <input type="text" id="stock" value="${pro.stock}" name="stock" autofocus>
                        <span class="help-block"></span>
                    </div>
                </div>
               <input type="submit" value="Save" class="btn btn-info btn-block">
               
            </form> <!-- /form -->
        </div> <!-- ./container -->
        <jsp:include page="footer.jsp"/>
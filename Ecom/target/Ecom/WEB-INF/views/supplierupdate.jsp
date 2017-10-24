<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>updates</title>
    <jsp:include page="header.jsp"/>
<div class="container">
            <form action="saveupdatesupplier">
                <h2>Product Update</h2>
                <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label">Supplier Id</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" placeholder="${sup.id }" name="id" autofocus>
                        <span class="help-block"></span>
                    </div>
                    <label for="firstName" class="col-sm-3 control-label">Supplier Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" placeholder="${sup.name }" name="name" autofocus>
                        <span class="help-block"></span>
                    </div>
                    <label for="firstName" class="col-sm-3 control-label">Address</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" placeholder="${sup.address}" name="address" autofocus>
                        <span class="help-block"></span>
                    </div>
                    
                </div>
               <input type="submit" value="Save" class="btn btn-info btn-block">
               
            </form> <!-- /form -->
        </div> <!-- ./container -->
        <jsp:include page="footer.jsp"/>
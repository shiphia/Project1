<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>update</title>
    <jsp:include page="header.jsp"/>
<div class="container">
            <form action ="saveupdatecategory" >
                <h2>CAtegory Update</h2>
                <div class="form-group">
                 <label for="id" class="col-sm-3 control-label">Category Id</label>
                    <div class="col-sm-9">
                        <input type="text" id="id" placeholder="${cat.id }" name="id" autofocus>
                        <span class="help-block"></span>
                    </div>
                    <label for="firstName" class="col-sm-3 control-label">Category Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" placeholder="${cat.name }" name="name" autofocus>
                        <span class="help-block"></span>
                    </div>
                </div>
               <input type="submit" value="Save" class="btn btn-info btn-block">
               
            </form> <!-- /form -->
        </div> <!-- ./container -->
        <jsp:include page="footer.jsp"/>
        
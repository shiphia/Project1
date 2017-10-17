<!DOCTYPE html>
<html lang="">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href='//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css' rel='stylesheet'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                       <th colspan="2">price</th>
                       <th colspan="2">stock</th>
                        
                    </tr>
                </thead>
                 <c:forEach var = "p" items="${pro}">
                <tbody>
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${p.name} </a></h4>
                                
                         </div>
                        </div></td>
                        <td class="col-sm-8 col-md-6">
                        
                                <h4 class="media-heading"><a href="#">${p.price} </a></h4>
                                
                         </div>
                        </div></td>
                        <td class="col-sm-8 col-md-6">
                        
                                <h4 class="media-heading"><a href="#">${p.stock} </a></h4>
                                
                         </div>
                        </div></td>
                       
                       
                       
                        <td class="col-sm-1 col-md-1">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"><a href="deleteproduct?id=${p.id}" title="#"></span> Remove</a>
                        </button></td>
                          <td class="col-sm-1 col-md-1">
                        
                         <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"><a href="updateproduct?id=${p.id }" title="#"></span> Update</a>
                        </button></td>
                    </tr>
                    
                         </c:forEach>       
                     </tbody>
                     
                     
 
                               
                     
                     
                     

	

 
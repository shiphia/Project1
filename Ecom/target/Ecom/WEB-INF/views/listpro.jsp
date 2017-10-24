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
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product id</th>
                        <th colspan="1">Name</th>
                       <th colspan="1">price</th>
                       <th colspan="1">stock</th>
                        
                    </tr>
                </thead>
                 <c:forEach var = "p" items="${pro}">
                <tbody>
                    <tr>
                    <td class="col-sm-8 col-md-6">
                        
                                <h4 class="media-heading">${p.id} </h4>
                                
                         </div>
                        </div></td>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${pageContext.request.contextPath}/resources/images1/${p.img}" style="width: 72px; height: 72px;"> </a>
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
                           <c:if test="${pageContext.request.userPrincipal.name  != null}">
                         <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-shopping-cart"><a href="cart?id=${p.id }" title="#"></span> ADD TO CART</a>
                        </button>
                        </c:if>
                        </td>
                    </tr>
                    
                       
                       
                    </tr>
                    
                         </c:forEach>       
                     </tbody>
                     </table>
                     </div>
                     </div>
                     </div>
                     
     <jsp:include page="footer.jsp"/>
                     
   </html>                  
 
                               
                     
                     
                     

	

 
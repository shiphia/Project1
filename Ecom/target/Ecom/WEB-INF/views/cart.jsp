
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:20%;
		margin:1.5em 0;
	}
	
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
  </style>
</head>
<body>

<jsp:include page="header.jsp"/>
<c:if test ="${fn:length(ca) eq 0}">
 <!-- Header -->
  <header class="page-header">
    <div class="container">
      <h1>My Cart</h1>
    </div>
  </header>

  <!-- Main Content -->
  <div class="container">
    <div class="hero-unit">
      <h2>Empty cart<i class="fa fa-shopping-cart"></i></h2>
      <p>YOUR CART IS EMPTY!!!!</p>
      <p>
        <a href="./" class="btn btn-primary">
          Buy something
        </a>
      </p>
    </div>
  </div>
</c:if>
</br></br>
</br></br></br>
<c:if test="${fn:length(ca) ge 1}">
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:30%">Product</th>
							<th style="width:2%">Price</th>
							<th style="width:0.5%;">Quantity</th>
							<th style="width:2%">Subtotal</th>
							<th style="width:2%"></th>
							<th style="width:2%"></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach var="c" items="${ca}">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/resources/images1/${c.pid.img}" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${c.pid.name}</h4>
									</div>
								</div>
							</td>
							<td data-th="Price">${c.pid.price}</td>
							<td align="center">${c.quantity}</td>
							<td>$${c.pid.price * c.quantity }</td>
							<td>
							<a href="cartup?cartid=${c.id}">update<i class="fa fa-refresh" aria-hidden="true"></i></a>
							</td>
							<td>
								<a href="cartdel?cartid=${c.id}">delete<i class="fa fa-close" style="color:red"></i></a>								
							</td>
							
						</tr></c:forEach>
					</tbody>
					<tfoot>
						
						<tr>
							<td><a href="./" class="btn btn-warning"><i class=" glyphicon glyphicon-shopping-cart"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total:${t}</strong></td>
							<td><a href="ship" class="btn btn-success btn-block"><i class=" glyphicon glyphicon-log-out"></i> Checkout</a></td>
						</tr>
					</tfoot>
				</table>
</div></c:if></br></br></br></br></br>
<jsp:include page="footer.jsp"/>

</body>
</html>

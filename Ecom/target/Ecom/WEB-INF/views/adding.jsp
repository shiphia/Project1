<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABOUT</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<style>

.centered-form{
	margin-top: 60px;
}

.centered-form .panel{
	
	box-shadow: rgba(255,0,0,0.3) 20px 20px 20px;
}</style>
<body>
<nav>
<div class="navbar navbar-light" style="background-color: #ffb6c1;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BEAUTY PLUS</a>
    </div>
    <ul class="nav navbar-nav">
    
      <li><a href="adding">ABOUT</a></li>
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">CATEGORY
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">FACE</a></li>
          <li><a href="#">LIPS</a></li>
          <li><a href="#">EYES</a></li>
          <li><a href="#">HAIR</a></li>
          <li><a href="#">NAILS</a></li>
        </ul>
      </li>
         
         <li><a href="#">OFFERS</a></li>
      </ul>
       <ul class="nav navbar-nav navbar-right">
         <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="logn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
 </div>
  </div>
</nav>

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">REGISTRATION </small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form" action="saveUser" method="post">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			                <input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="First Name">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="Last Name">
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
			    				<input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address">
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="password" name="password" id="password" class="form-control input-sm" placeholder="Password">
			    					</div>
			    					</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-sm" placeholder="Confirm Password">
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    		
			    		</form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>

</body>
</html>
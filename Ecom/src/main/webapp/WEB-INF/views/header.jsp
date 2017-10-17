<ul class="nav navbar-nav">  
            <li>  
                <a href="./">Home</a>  
            </li>  
              <c:if test="${pageContext.request.userPrincipal.name  == 'admin123@gmail.com'}">
              <li>  
               <a href="admin/adding">Admin</a>              
              </li>  
            </c:if> 
             <c:if test="${pageContext.request.userPrincipal.name  != 'admin123@gmail.com'}">
            <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category List
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach var="c" items="${clist}" >
          <li><a href="categoryProductlist?id=<c:out value='${c.cid}'/>"><c:out value="${c.name}"/></a></li>
       </c:forEach>
          </ul>
          </li>
          </c:if>
           <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name  != 'admin123@gmail.com'}">
            <li>       
            <a href="checkout">My Cart<i class="fa fa-shopping-cart" ></i></a> 
            </li> 
            </c:if> 
            <li>  
             <c:if test="${pageContext.request.userPrincipal.name == null }">
                <a href="register">Register</a>  
                </c:if>
            </li>  
            <li>  
            <c:if test="${pageContext.request.userPrincipal.name == null }">
                <a href="login">Login</a>
            </c:if>    
            </li>  
             <li>  
            <c:if test="${pageContext.request.userPrincipal.name  != null}">
					<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
					<li><a href='<c:url value="/j_spring_security_logout" />'>Logout</a></li>
				</c:if>
            </li>  
        </ul>  
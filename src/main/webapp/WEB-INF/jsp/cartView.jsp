<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Total Inventory Page</title>
</head>

<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp">
       <jsp:param name="pageTitle" value="Checkout" />
    </jsp:include>
    
    <h2>Shopping Cart</h2>
    
    <table style="width:40%">
        <th>Tool</th><th>Category</th><th>Return Date</th>
	        <c:forEach var="item" items="${shoppingCart}" varStatus="loopStatus"> 
		  
		        <tr>
		           <td><c:out value="${item.toolId}"/></td>
		           <td><c:out value="${item.toolId}"/></td>
		           <td><c:out value="${item.dateLoaned}"/></td>
		           <td><a href="${addItemURL}"><c:out value="Remove From Cart"/> </a></td>
	        	</tr>
			</c:forEach>
        </table>
    
          
  			 
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>CART VIEW</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp">
		<jsp:param name="pageTitle" value="Cart View" />
	</jsp:include>



	<h2>Tools in your Cart</h2>


	<ul class="inventoryList">
		<c:forEach var="toolId" items="${cartContents}" varStatus="loopStatus">
			<div>
				${toolId.getToolName}
				<hr>
			</div>
		</c:forEach>
	</ul>


	<c:url value="/addTools" var="addToolsURL"> 
	<div>
		<form action=${addToolsURL} method="get">
			<button type="button">Add more tools to your cart</button>
		</form>
	</div>
	</c:url>

<br> <br>

	<c:url value="/checkoutTools" var="loanProcessURL"> </c:url>
	<div>
		<form action=${loanProcessURL} method="get">
			<button type="button">Proceed to Loan Processing</button>
		</form>
	</div>


	<!--  <jsp:include page="/WEB-INF/jsp/footer.jsp" />    -->
>>>>>>> branch 'master' of https://jimkasper@bitbucket.org/techelevator-team-green/capstone-project.git
</body>

</html>
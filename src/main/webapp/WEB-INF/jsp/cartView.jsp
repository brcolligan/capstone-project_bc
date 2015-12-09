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
    
    <h2>Tools in your Cart</h2>
    
    
    <table style="width:40%">
        <th>Tool</th><th>Category</th><th>Return Date</th>
	        <c:forEach var="tool" items="${shoppingCart}" varStatus="loopStatus"> 
		  
		        <tr>
		           <td><c:out value="${tool.toolName}"/></td>
		           <td><c:out value="${tool.toolId}"/></td>
		           <td><c:out value="${tool.toolInventoryId}"/></td>
		           <td><a href="${addItemURL}"><c:out value="Remove From Cart"/> </a></td>
	        	</tr>
			</c:forEach>
        </table>
    

	<c:url value="/addTools" var="addToolsURL"> 
	<div>
		<form action=${addToolsURL} method="get">
			<button type="button">Add more tools to your cart</button>
		</form>
	</div>
	</c:url>

<br> <br>



	<!--  <jsp:include page="/WEB-INF/jsp/footer.jsp" />    -->

</body>

</html>
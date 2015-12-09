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
    
          
  			 
</body>

</html>
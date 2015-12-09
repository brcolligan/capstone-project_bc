<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Available Inventory</title>
</head>

<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp">
       <jsp:param name="pageTitle" value="Inventory List" />
    </jsp:include>
    
    <h2>Inventory</h2>
    
      
	<table style="width:50%">
        <th>Tool</th><th>Category</th><th>Id</th><th>Period</th><th>Inventory Id</th>
	       
	        <c:forEach var="tool" items="${toolList}" varStatus="loopStatus"> 
		        
		        <c:url value="/addToCart" var="addItemURL">
		        	<c:param name="toolInventoryId" value="${tool.toolInventoryId}" />
		        </c:url>
		        
		        <tr>
		           <td><c:out value="${tool.toolName}"/></td>
		           <td><c:out value="${tool.toolCategoryName}"/></td>
		           <td><c:out value="${tool.toolId}"/></td>
		           <td><c:out value="${tool.toolLoanPeriod}"/></td>
		           <td><c:out value="${tool.toolInventoryId}"/></td>
		           <td><a href="${addItemURL}"><c:out value="Add to Cart"/> </a></td>
	        	</tr>
			</c:forEach>
        </table>
        
        
        <a href="/tool-library-web/viewCart"><c:out value="Go To Shopping Cart"/>
        </a>
       
    <c:url value="/viewCart" var="cartViewURL" />

	<div>
		<form action=${cartViewURL} method="get">
			<button type="button">Review Cart Contents</button>
		</form>
	</div>
    
         
    
                 
                 
  			 
</body>

</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

	<c:url value="/viewCart" var="cartViewURL" />
	<h2><a href="${cartViewURL }">Review Cart Contents</a></h2>
	
	<h2>Available Inventory</h2>

	<table class="tableList">
		<tr>
			<th>Tool<br>Name</th>
			<th>Tool<br>Category</th>
			<th>Tool<br>ID</th>
			<th>Loan<br>Period</th>
			<th>Add<br>Tool</th>
		</tr>

		<c:forEach var="tool" items="${toolList}" varStatus="loopStatus">

			<c:url value="/addToCart" var="addItemURL">
				<c:param name="toolInventoryId" value="${tool.toolInventoryId}" />
			</c:url>
				
			<c:choose>
				<c:when test="${loopStatus.count % 2 == 0}">
					<c:set var="itemClass" value="even" />     
				</c:when>
				<c:otherwise>
					<c:set var="itemClass" value="odd" />
				</c:otherwise>
			</c:choose>

			<tr class = "${itemClass}">
				<td><c:out value="${tool.toolName}" /></td>
				<td><c:out value="${tool.toolCategoryName}" /></td>
				<td><c:out value="${tool.toolClientId}" /></td>
				<td><c:out value="${tool.toolLoanPeriod} days" /></td>
				<td> <a href="${addItemURL}">
				<c:url value="/img/add-icon.png" var="addIcon" />
    			<img class = icon src="${addIcon}" id="addIcon"/></a></td>
			
		
			</tr>
		</c:forEach>
	</table>


</body>
</html>
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
</body>

</html>
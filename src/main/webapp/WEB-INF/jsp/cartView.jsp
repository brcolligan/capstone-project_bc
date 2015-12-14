<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<c:url value="/addTools" var="addTools"></c:url>

	<div>
		<a href="${addTools}">add more items</a>
	</div>

	<table class="tableList">
		<th>Tool</th>
		<th>Category</th>
		<th>Due Date</th>
		<c:forEach var="addedTool" items="${shoppingCart}"
			varStatus="loopStatus">

			<c:url value="/removeFromCart" var="removeTools">
				<c:param name="toolInventoryId" value="${addedTool.toolInventoryId}" />
			</c:url>

			<tr>
				<td><c:out value="${addedTool.toolName}" /></td>
				<td><c:out value="${addedTool.toolCategoryName}" /></td>
				<td><c:out value="${addedTool.toolDueDate}" /></td>
				<td><a href="${removeTools}"><c:out
							value="Remove From Cart" /> </a></td>
				<!-- remove item from cart, do a redirect to this page & it will refresh without that item -->
			</tr>
		</c:forEach>
	</table>

	<h2>Renter's Information</h2>

	<div class="fieldGroup">
		<c:url value="/checkoutTools" var="formActionURL" />
		<form class="form" action="${formActionURL}" method="POST">

			<div class="fieldGroup">
				<input type="hidden" value="${shoppingCart }" />
			</div>

			<div class="fieldGroup">
				<input type="text" name="date" id="date" placeholder="Today's Date" />
			</div>

			<div class="fieldGroup">
				<input type="text" name="firstName" id="firstName"
					placeholder="First Name" /> <input type="text" name="lastName"
					id="lastName" placeholder="Last Name" />
			</div>

			<div class="fieldGroup">
				<input type="text" name="license" id="license"
					placeholder="Driver's license #" />
			</div>

			<div class="fieldGroup">
				<input type="text" name="phone" id="phone" placeholder="Phone #" />
			</div>

			<div class="fieldGroup">
				<input type="submit" value="Submit Loan Request" />

			</div>
		</form>
	</div>
	<!--  <jsp:include page="/WEB-INF/jsp/footer.jsp" />    -->
</body>
</html>
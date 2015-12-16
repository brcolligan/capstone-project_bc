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
	<c:url value="/clearCart" var="clearCart"></c:url>

	<div>
		<a href="${addTools}">
		<button type="button">Add More Tools</button>
		</a>
	</div>
	<div>
		<a href="${clearCart}">
		<button type="button">Clear The Toolbox</button>
		</a>
	</div>

	<table class="tableList">
		<tr>
		<th>Tool</th>
		<th>Category</th>
		<th>Due Date</th>
		<th></th>
		</tr>
		
		<c:forEach var="addedTool" items="${shoppingCart}"
			varStatus="loop">

			<c:url value="/removeFromCart" var="removeTools">
				<c:param name="toolInventoryId" value="${addedTool.toolInventoryId}" />
				<c:param name="toolInventoryIndex" value="${loop.index}" />
			</c:url>
			<tr>
				<td><c:out value="${addedTool.toolName}" /></td>
				<td><c:out value="${addedTool.toolCategoryName}" /></td>
				<td><c:out value="${addedTool.toolDueDate}" /></td>
				
				<td><a href="${removeTools}"><c:out value="Remove From Cart" /> </a></td>
				<!-- remove item from cart, do a redirect to this page & it will refresh without that item -->
			</tr>
		</c:forEach>
	</table>

	<h2>Renter's Information</h2>

	<div class="fieldGroup">
		<c:url value="/checkoutTools" var="formActionURL" />
		<form class="form" action="${formActionURL}" method="POST"  >

			<div class="fieldGroup">
				<input type="hidden" value="${shoppingCart }" />
			</div>

			<div class="fieldGroup">
				<input type="text" name="date" id="date" placeholder="yyyy-mm-dd" required />
			</div>

			<div class="fieldGroup">
				<input type="text" name="firstName" id="firstName" placeholder="First Name" required/> 
			</div>
			<div class="fieldGroup">
				<input type="text" name="lastName" id="lastName" placeholder="Last Name" required/>
			</div>

			<div class="fieldGroup">
				<input type="text" name="license" id="license" placeholder="Driver's license #" required/>
			</div>

			<div class="fieldGroup">
				<input type="number" name="phone" id="phone" placeholder="Phone #" size = "10" required/>
			</div>

			<div class="fieldGroup">
				<input type="submit" value="Submit Loan Request" />

			</div>
		</form>
	</div>
	<!--  <jsp:include page="/WEB-INF/jsp/footer.jsp" />    -->
</body>
</html>
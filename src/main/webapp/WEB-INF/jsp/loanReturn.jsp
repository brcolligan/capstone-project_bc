<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Loan Return Page</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp">
		<jsp:param name="pageTitle" value="Return Loan" />
	</jsp:include>

	<table class="tableList">
		<!-- var="loan" items="${loanList}" varStatus="loopStatus">         -->
		<tr>
			<th><c:out value="First Name" /></th>
			<td><c:out value="${loan.firstName }" /></td>
		<tr>
			<th><c:out value="Last Name" /></th>
			<td><c:out value="${loan.lastName }" /></td>
		<tr>
			<th><c:out value="Phone Number" /></th>
			<td><c:out value="${loan.phoneNumber }" /></td>
	
		<tr>
			<th><c:out value="Tool Loaned" /></th>
			<td><c:out value="${loan.toolLoaned}" /></td>
		<tr>
			<th><c:out value="Date Loaned" /></th>
			<td><c:out value="${loan.dateOfLoan }" /></td>
		<tr>
			<th><c:out value="Due Date" /></th>
			<td><c:out value="${loan.expectedReturn }" /></td>
		<tr>
			<th><c:out value="Late Fees" /></th>
			<td><c:out value="${loan.lateFee }" /></td>
		<tr>
			<th><c:out value="Maintenance Fee" /></th>
			<td><c:out value="${loan.maintenanceFee }" /></td>
		<tr>
			<th><c:out value="Cleaning Fee" /></th>
			<td><c:out value="${cleaningFee }" /></td>
		</tr>
		<tr>
			<th><c:out value="Total Fees" /></th>
			<td><c:out value="${cleaningFee+loan.maintenanceFee+loan.lateFee}" /></td>
		</tr>
	</table>

	<c:url value="/processedReturn" var="processedReturnURL">
		<c:param name="loanId" value="${loan.loanId}" />
		<c:param name="cleaningFee" value="${cleaningFee}" />
		<c:param name="lateFee" value="${loan.lateFee}" />
		<c:param name="maintenanceFee" value="${loan.maintenanceFee}" />
	</c:url>
	<a href="${processedReturnURL }">
		<button type="button">Finish</button>
	</a>

</body>
</html>
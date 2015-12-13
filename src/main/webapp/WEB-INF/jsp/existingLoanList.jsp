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
		<jsp:param name="pageTitle" value="Active Loans" />
	</jsp:include>

	<table style="width: 50%" class="table">
		<th>Last Name</th>
		<th>First Name</th>
		<th>Tool Name</th>
		<th>Rental Date</th>
		<th>Due Date</th>

		<c:forEach var="loan" items="${loanList}" varStatus="loopStatus">
			<c:url value="/loanReturn" var="addLoanURL">
				<c:param name="loanId" value="${loan.loanId}" />
			</c:url>
			<tr>
				<td><c:out value="${loan.lastName}" /></td>
				<td><c:out value="${loan.firstName}" /></td>
				<td><c:out value="${loan.toolLoaned}" /></td>
				<td><c:out value="${loan.dateOfLoan}" /></td>
				<td><c:out value="${loan.expectedReturn}" /></td>
				<td><a href="${addLoanURL}"><c:out value="Return Loan" /> </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Previous Loans</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp">
		<jsp:param name="pageTitle" value="Previous Loans" />
	</jsp:include>

	<table class="tableList">
		<tr>
		<th>Last<br>Name</th>
		<th>First<br>Name</th>
		<th>Tool<br>Name</th>
		<th>Rental<br>Date</th>
		<th>Due<br>Date</th>
		<th>Cleaning<br>Fee </th>
		<th>Maintenance<br>Fee </th>
		<th>Late<br>Fee </th>
		</tr>
	
		<c:forEach var="loan" items="${oldLoanList}" varStatus="loopStatus">
			<c:url value="/oldLoanReturn" var="oldLoanReturnURL">
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
				<td><c:out value="${loan.lastName}" /></td>
				<td><c:out value="${loan.firstName}" /></td>
				<td><c:out value="${loan.toolLoaned}" /></td>
				<td><c:out value="${loan.dateOfLoan}" /></td>
				<td><c:out value="${loan.expectedReturn}" /></td>
				<td><c:out value="${loan.cleaningFee}" /></td>
				<td><c:out value="${loan.maintenanceFee}" /></td>
				<td><c:out value="${loan.lateFee}" /></td>

			</tr>
			
		</c:forEach>
		
	</table>
	
</body>
</html>
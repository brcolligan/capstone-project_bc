
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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


 <table style="width:50%" class="table">
        <!-- var="loan" items="${loanList}" varStatus="loopStatus">         -->
		    <tr>
		    	<td><c:out value="${loan.firstName }" /></td>
		    	<td><c:out value="${loan.lastName }" /></td>
		    	<td><c:out value="${loan.phoneNumber }" /></td>
		    	<td><c:out value="${loan.toolLoaned}" /></td>  
		    	<td><c:out value="${loan.dateOfLoan }" /></td>
		    	<td><c:out value="${loan.expectedReturn }" /></td>
		    	<td><c:out value="${loan.lateFee }"  /></td>
		    	<td><c:out value="${loan.maintenanceFee }" /></td>
		    	<td><c:out value="${loan.cleaningFee }" /></td>
			</tr>
        
 </table>
 
 		<c:url value="/processedReturn" var="processedReturnURL" />
 		<a href = "${processedReturnURL }">
 			<button type="button">Finish</button>
 		</a>

	
	
</body>

</html>
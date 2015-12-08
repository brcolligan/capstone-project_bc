
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="placeholder.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Loan Return Page</title>
</head>
<c:url value="/" var="contextRoot" />

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp">
	   <jsp:param name="pageTitle" value="Active Loans" />
	</jsp:include>


<div>
<p> 
display
return date
customer name
phone

Tool Return Details
Tool
Rental Date
Due Date

Fees and Fines
Late Fees
Maintence fees
Cleaning Fee
Total
</p>

</div>

	
	
</body>

</html>
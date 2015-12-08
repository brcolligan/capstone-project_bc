
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="placeholder.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Tool Library</title>
</head>
<c:url value="/" var="contextRoot" />

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp">
	   <jsp:param name="pageTitle" value="Tool Library" />
	</jsp:include>


<div>
<form action="/newLoan" method="get">
<button type="button">New Loan</button>
</form>
</div>
<div>
<form action="/existingLoan" method="get">
<button type="button">Existing Loan</button>
</form>
</div>


	
	
</body>

</html>
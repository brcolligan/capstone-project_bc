<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Tool Library</title>
</head>
<c:url value="/" var="contextRoot" />

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp">
		<jsp:param name="pageTitle" value="Create a New Loan or Return an Existing Loan" />
	</jsp:include>
	
	<div class = "homeSelection">
	
		<c:url value="/addTools" var="addTools" />
			<a href="${addTools}"> 
		<c:url value="/img/newLoan.jpg" var="newLoan" />
   			<img src="${newLoan}" id="newLoan" />
			</a>
			
		<c:url value="/existingLoans" var="existingLoans" />
			<a href="${existingLoans}"> 
		<c:url value="/img/existingLoans.jpg" var="existingLoans" />
    		<img src="${existingLoans}" id="existingLoans" />
			</a>
	</div>
	
	</body>
</html>
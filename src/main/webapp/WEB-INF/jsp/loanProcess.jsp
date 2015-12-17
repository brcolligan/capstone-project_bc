<!--   for tables use  attribute class="table" . For forms use attribute class="form" - christo-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Loan Confirmation</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp">
		<jsp:param name="pageTitle" value="Loan Confirmation" />
	</jsp:include>

	<H2>Thank you for your transaction.</H2>
	
	

	<c:url value="/homePage" var="homePageURL" />
	<h2><a href="${homePageURL}">Click here to return to the Homepage.</a> </h2>

</body>
</html>
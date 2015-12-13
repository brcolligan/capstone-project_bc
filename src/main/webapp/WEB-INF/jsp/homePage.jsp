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
		<jsp:param name="pageTitle" value="Tool Library" />
	</jsp:include>

	<c:url value="/addTools" var="addTools">
	</c:url>
	<c:url value="/existingLoans" var="existingLoans">
	</c:url>

	<div>
		<a href="${addTools}">NEW LOANS</a>
	</div>
	<br>

	<div>
		<a href="${existingLoans}">EXISTING LOANS</a>
	</div>

</body>
</html>
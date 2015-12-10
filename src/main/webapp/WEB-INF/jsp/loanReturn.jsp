
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


 <ol class="table">
        <c:forEach var="loan" items="${loanById}" varStatus="loopStatus">           
            <c:url value="/processedReturn" var="loanReturn">
                <c:param name="loanReturnPage" value="${loan.id}" /> 
            </c:url>
        
        </c:forEach>
        
    </ol>

	
	
</body>

</html>

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


 <ol class="loanList">
        
        <c:forEach var="loan" items="${loanList}" varStatus="loopStatus">  <%-- The <c:forEach> tag is documented on page 447 of Head First Servlets --%>
            
            <c:url value="/ExistingLoans" var="existingLoanList">
                <c:param name="existingLoanList" value="${topic.id}" />      <%-- adding query string parameters using <c:url> is documented on page 466 of Head First Servlets --%>
            </c:url>
        
          
           
        </c:forEach>
        
    </ol>

	
	
</body>

</html>
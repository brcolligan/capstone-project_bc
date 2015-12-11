
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
        <c:forEach var="loan" items="${loanList}" varStatus="loopStatus">           
		    <tr>
		    	<td><c:out value="${loan.toolLoaned}" /></td>  
			</tr>
        </c:forEach>
        
 </table>
 

	
	
</body>

</html>
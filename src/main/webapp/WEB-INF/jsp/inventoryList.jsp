<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Available Inventory Page</title>
</head>

<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp">
       <jsp:param name="pageTitle" value="Total Inventory Page" />
    </jsp:include>
    
    <h2>Inventory</h2>
    
      <ol class="inventoryList">
        
        <c:forEach var="tool" items="${toolList}" varStatus="loopStatus">  <%-- The <c:forEach> tag is documented on page 447 of Head First Servlets --%>

          
            <li >
                <a href="${loanReturnPage}"><c:out value="${tool.toolName}" /></a>  <%-- We're using a c:out tag here to HTML encode the title and prevent a possible XSS vulnerability --%>
            </li>
        </c:forEach>
        
    </ol>
    
         
    
                 
                 
  			 
</body>

</html>
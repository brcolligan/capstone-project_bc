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

            <c:choose>
                <c:when test="${loopStatus.count % 2 == 0}">
                    <c:set var="itemClass" value="even" />     <%-- The <c:set> tag is documented on page 455 of Head First Servlets --%>
                </c:when>
                <c:otherwise>
                    <c:set var="itemClass" value="odd" />
                </c:otherwise>
            </c:choose>
            <li class="${itemClass}">
                <a href="${loanReturnPage}"><c:out value="${tool.id}" /></a>  <%-- We're using a c:out tag here to HTML encode the title and prevent a possible XSS vulnerability --%>
            </li>
        </c:forEach>
        
    </ol>
    
         
    
                 
                 
  			 
</body>

</html>
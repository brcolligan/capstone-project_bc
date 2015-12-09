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
    
      <ol>
        
        <c:forEach var="tool" items="${toolList}"> 
        <c:url value="/addToCart" var="addItemURL">
                <c:param name="toolId" value="${tool.toolId}" />
            </c:url>
          
            <li>
                <a href="${addItemURL}"><c:out value="${tool.toolName}"/> 
                						<c:out value="${tool.toolCategoryName}"/> 
                						<c:out value="${tool.toolId}"/> 
                						<c:out value="${tool.toolLoanPeriod}"/></a> 
            </li>
            
        </c:forEach>
        
    </ol>
    
         
    
                 
                 
  			 
</body>

</html>
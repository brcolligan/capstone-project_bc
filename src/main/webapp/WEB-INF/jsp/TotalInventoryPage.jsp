<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Total Inventory Page</title>
</head>

<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp">
       <jsp:param name="pageTitle" value="Total Inventory Page" />
    </jsp:include>
    
    <h2>Inventory</h2>
    
    
    
    <ul class="inventoryList">
        
        <c:forEach var="tool" items="${toolList}" varStatus="loopStatus">  <%-- The <c:forEach> tag is documented on page 447 of Head First Servlets --%>
        
            <hr>
            <div>${tool}</div>
           <c:url value="/newLoan" var="addToShopCartURL">
            
            
            
            
                <c:param name="topicId" value="${topic.id}" />      <%-- adding query string parameters using <c:url> is documented on page 466 of Head First Servlets --%>
            </c:url>
        /capstone-project/src/main/
                        <a href="newLoan"><img src="/webapp/img/shopping_cart.png" /></a>  <%-- We're using a c:out tag here to HTML encode the title and prevent a possible XSS vulnerability --%>
            </li>
        </c:forEach>
        
    </ul>
    
    <c:url value="/forumTopicInput" var="topicInputURL" />
    [ <a href="${topicInputURL}">Add a Topic</a> ]

    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>

</html>
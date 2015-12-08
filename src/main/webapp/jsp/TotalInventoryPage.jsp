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
    
    <h2>Inventory List</h2>
    
    
    
    <ol class="inventoryList">
        
        <c:forEach var="tool" items="${inventoryList}" varStatus="loopStatus">  <%-- The <c:forEach> tag is documented on page 447 of Head First Servlets --%>
            
            <c:url value="/addTools" var="uniqueInventoryURL">
                <c:param name="topicId" value="${topic.id}" />      <%-- adding query string parameters using <c:url> is documented on page 466 of Head First Servlets --%>
            </c:url>
        
            <c:choose>
                <c:when test="${loopStatus.count % 2 == 0}">
                    <c:set var="itemClass" value="even" />     <%-- The <c:set> tag is documented on page 455 of Head First Servlets --%>
                </c:when>
                <c:otherwise>
                    <c:set var="itemClass" value="odd" />
                </c:otherwise>
            </c:choose>
            <li class="${itemClass}">
                <a href="${topicViewURL}"><c:out value="${topic.title}" /></a>  <%-- We're using a c:out tag here to HTML encode the title and prevent a possible XSS vulnerability --%>
            </li>
        </c:forEach>
        
    </ol>
    
    <c:url value="/forumTopicInput" var="topicInputURL" />
    [ <a href="${topicInputURL}">Add a Topic</a> ]

    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>

</html>
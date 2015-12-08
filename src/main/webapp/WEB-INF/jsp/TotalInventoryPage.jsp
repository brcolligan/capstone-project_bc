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
        
        <c:forEach var="tool" items="${toolList}" varStatus="loopStatus">  
       
            <div>
            	${tool}
            <c:url value="/addToCart" var="addToCartURL">
			    <c:param name="tool_id" value="${tool.tool_id}" />    
                <img src="/webapp/img/shopping_cart.png"/></a>      <!--http request surrounds image, to make shopping cart a button -->
            </c:url>
            

                   <hr>
            </div>
        </c:forEach>
        
    </ul>
    
    <c:url value="/forumTopicInput" var="topicInputURL" />
    [ <a href="${topicInputURL}">Add a Topic</a> ]

    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>

</html>
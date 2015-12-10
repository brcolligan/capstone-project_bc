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
       <jsp:param name="pageTitle" value="Checkout" />
    </jsp:include>
    
 
    <h2>Tools in your Cart</h2>
    
    <table style="width:40%" class="table">
        <th>Tool</th><th>Category</th><th>Inventory Id</th>
	        <c:forEach var="addedTool" items="${shoppingCart}" varStatus="loopStatus"> 
		  
		        <tr>
		           <td><c:out value="${addedTool.toolName}"/></td>
		           <td><c:out value="${addedTool.toolId}"/></td>
		           <td><c:out value="${addedTool.toolInventoryId}"/></td>
		           <td><a href="${addItemURL}"><c:out value="Remove From Cart"/> </a></td>
	        	</tr>
			</c:forEach>
        </table>
        
    <h2>Renter's Information</h2>
    
    <div class="fieldGroup">
    	<c:url value="/checkoutTools" var="formActionURL" />
    	<form class="form" action="${formActionURL}" method="POST">
    
    
    <div class="fieldGroup">
        <input type="text" name="date" id="date" placeholder="Today's Date" />
    </div>
    
    <div class="fieldGroup">
         <input type="text" name="firstName" id="firstName" placeholder="First Name" />
   	   	 <input type="text" name="lastName" id="lastName" placeholder="Last Name" />
    </div>
    
    <div class="fieldGroup">
        <input type="text" name="license" id="license" placeholder="Driver's license #" />
    </div>
    
    <div class="fieldGroup">
        <input type="text" name="phone" id="phone" placeholder="Phone #" />
    </div>
    
    <div class="fieldGroup">
            <input type="submit" value="Submit Loan Request" />
    </div>
   </form>	
    </div>

<c:url value="/addTools" var="addTools">
	</c:url>
	<div>
		<a href="${addTools}">add more items</a>
	</div>

<br> <br>



	<!--  <jsp:include page="/WEB-INF/jsp/footer.jsp" />    -->

</body>

</html>
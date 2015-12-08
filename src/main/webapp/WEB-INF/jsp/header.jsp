<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width:800px; text-align:right;">

<c:url value="/" var="homePageURL" />
<a href="${homePageURL}"> 
    <c:url value="/img/placeholer.png" var="logoURL" />
    <img src="${logoURL}" id="logo" />
</a>
</div>


<div id="content">
    
    <h1><c:out value="${ param.pageTitle }" /></h1>
    </div>
    
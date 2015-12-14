<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class=header-banner style="width:1200px; text-align:center;">
<br><br>
<c:url value="/" var="homePageURL" />
	<a href="${homePageURL}"> 
<c:url value="/img/logo.jpg" var="logoURL" />
    <img src="${logoURL}" id="logo" />
</a>
</div>


<div id="content">
    
    <h1><c:out value="${ param.pageTitle }" /></h1>
    </div>
    
    
<!--  commented out. The below code can be used for a horizontal navigation bar if needed 
    <header class="header-banner">
   <nav><ul>
    <li class="active"><a href="#">link1</a></li>
    <li><a href="#">link2</a></li>
    <li><a href="#">link3</a></li>
    <li><a href="#">link4</a></li>
  </ul></nav>
</header>  										--> 
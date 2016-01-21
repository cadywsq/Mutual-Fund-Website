<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-customer-top.jsp" />
<div>
	<h3>Welcome, ${ user.firstName } ${ user.lastName }!</h3>
</div>
<img src="img/banner.jpg" alt="CFS Welcome Banner" width="80%">

<jsp:include page="template-buttom.jsp" />
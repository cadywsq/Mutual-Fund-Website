<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-customer-top.jsp" />

<div class="row">
	<div class="col-md-offset-2 col-md-8">
		<h2 class="page-header">${customer.getFirstName()}
			${customer.getLastName()}</h2>
	</div>
</div>
<div class="row">
	<div class="col-md-offset-2 col-md-8">
		<h2 align="center">Transaction History</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped">
				<tr>
					<td>Date</td>
					<td>Operation</td>
					<td>Fund Name</td>
					<td>Shares</td>
					<td>Share Price</td>
					<td>Amount</td>
				</tr>


				<c:forEach var="h" items="${history}">
					<tr>
						<td>${ h.getDate() }</td>
						<td>${ h.getOperation() }</td>
						<td>${ h.getFund() }</td>
						<td>${ h.getShares() }</td>
						<td align="right">$${ h.getPrice() }</td>
						<td align="right">$${ h.getTotal() }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>




<jsp:include page="template-buttom.jsp" />
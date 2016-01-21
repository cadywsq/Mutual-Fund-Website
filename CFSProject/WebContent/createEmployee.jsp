<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-employee-top.jsp" />
<div>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<h2>Create Employee Account</h2>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${ (empty msg) }">
				</c:when>
				<c:otherwise>
					<h3 style="color: blue">${msg}</h3>
				</c:otherwise>
			</c:choose>

			<c:forEach var="error" items="${errors}">
				<h3 style="color: red">${error}</h3>
			</c:forEach>
		</div>

		<div class="col-md-offset-2 col-md-8">
			<form method="post" action="createEmployee.do">
				<div class="form-group">
					<div class="row">
						<div class="col-xs-2">
							<label>User Name:<span class="astreik">*</span></label>
						</div>
						<div class="col-md-2">
							<label id="userName"><u><b>abc123</b></u></label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2">
						<label>First Name:<span class="astreik">*</span></label>
					</div>
					<div class="col-md-3">
						<input name="firstName" required class="form-control" value="${form.firstName}">
					</div>
					<div class="col-xs-2">
						<label>Last Name:<span class="astreik">*</span></label>
					</div>
					<div class="col-md-3">
						<input name="lastName" required class="form-control" value="${form.lastName}">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-2">
						<label>Password:<span class="astreik">*</span></label>
					</div>
					<div class="col-md-3">
						<input name="confirm" type="password" required
							class="form-control">
					</div>
					<div class="col-xs-2">
						<label>Confirm Password:<span class="astreik">*</span></label>
					</div>
					<div class="col-md-3">
						<input name="password" type="password" required
							class="form-control">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6" align="right">
					<input type="submit" class="btn btn-default" name="action" value="Create Employee">
					</div>
				</div>
				<br>
			</form>
		</div>
	</div>
</div>
<jsp:include page="template-buttom.jsp" />

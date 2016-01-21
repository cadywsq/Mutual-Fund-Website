<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-employee-top.jsp" />
<div>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<h4>Deposit Check</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
		<c:forEach var="error" items="${errors}">
			<h3 style="color: red">${error}</h3>
		</c:forEach>
			<form method="post" action="depositCheck.do">
				<div class="form-group">
					<div class="row">
						<div class="col-xs-4">
							<label>Customer(Username):<span class="astreik">*</span></label>
						</div>
						<div class="col-md-6">
							<select required class="form-control">
								<option></option>
								<option>user1</option>
								<option>user2</option>
							</select>
						</div>
					<br><br><br>
					<div class="form-group">
						<div class="col-xs-4">
							<label>Amount:</label><span class="astreik">*</span>
						</div>
						<div class="col-md-6">
							<input name="amount" type="text" required class="form-control"
								placeholder="Only numbers in the format 1000.00">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label>Confirm Amount:</label><span class="astreik">*</span>
						</div>
						<div class="col-md-6">
							<input name="amount" type="text" required class="form-control">
						</div>
					</div>

				</div>
				<br>
				</div>

				<div class="row">
					<div class="col-xs-6" align="right">
					<input type="submit" class="btn btn-default" name="action" value="Deposit Check">
						<br> <br> <br>
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="template-buttom.jsp" />
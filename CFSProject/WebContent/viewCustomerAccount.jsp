<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-employee-top.jsp" />
<div>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<h3>Select Customer Account</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-ofset-2 col-md-8">
			<form role="form">
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
				</div>
				<br>
				</div>

				<div class="row">
					<div class="col-xs-6" align="right">
						<button type="submit" name="create" class="btn btn-default">View Customer Account</button>
						<br> <br> <br>
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="template-buttom.jsp" />
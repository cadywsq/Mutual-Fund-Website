<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Team Eleven">
<title>Carnegie Financial Services</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/sb-admin.css" rel="stylesheet">
<link href="bootstrap/css/gencss.css" rel="stylesheet">
</head>
<body style="background-image: url(img/tartan-background.jpg);">
	<div>
		<!-- Navigation -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-offset-1 col-md-11">
					<nav class="navbar" role="navigation">
						<div class="navbar-header">
							<a href="customerMain.html"> <img src="img/logo.png"
								style="height: 110px;">
							</a>
						</div>
						<!-- Top Menu Items -->

						<!-- Menu Items End -->
					</nav>
				</div>
			</div>
		</div>

		<!-- End of Navigation Bar -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- End of Top-Customer - Dont Edit Anything Above -->
				<div class="row">
					<div class="col-md-offset-1 col-md-10">
						<div>
							<br>
							<c:forEach var="error" items="${errors}">
								<h3 style="color: red">${error}</h3>
							</c:forEach>
							<br>
						</div>
						<table>
							<tr>
								<td>
								<form method="post" action="login.do">
									<div class="form-group">
										<label>Username</label>
										<input class="form-control" placeholder="Enter here your user name here" name="userName" value="${username}">
									</div>
									<div class="form-group">
										<label>Password</label>
										<input class="form-control" type="password" placeholder="This is case sensitive field" name="password">
									</div>
									<input type="submit" class="btn btn-default" name="action" value="Customer Login">
									<input type="submit" class="btn btn-default" name="action" value="Employee Login">
									<p>
										<span><a href="SendResetPasswordMail">Trouble
												Logging in</a></span>
									</p>
								</form>
								</td>
								<td>
									<div class="ticker" style="margin-left: 60px;">
										<h3>Latest Market News</h3>
										<ul id="ticker">
											<li>Dummy data is benign information that does not
												contain any useful data</li>
											<li>For testing, dummy data can also be used as stubs <br>
												or pad to avoid software testing iss...
											</li>
											<li>In operational use, dummy data may be transmitted <br>
												for OPSEC purposes.
											</li>
											<li>Dummy data must be rigorously evaluated and
												documented <br> to ensure that it does no...
											</li>
										</ul>
									</div>

								</td>
							</tr>
						</table>

						<jsp:include page="template-buttom.jsp" />
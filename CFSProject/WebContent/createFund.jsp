<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-employee-top.jsp" />
  <div>
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <h2>Create Fund</h2>
      </div>
    </div>
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
      <c:forEach var="error" items="${errors}">
			<h3 style="color: red">${error}</h3>
		</c:forEach>
      <form method="post" action="createFund.do">
        <div class="form-group">
	        <div class="row">
		          <div class="col-xs-2">
		            <label>Fund Name:<span class="astreik">*</span></label>
		          </div>
		          <div class="col-md-6">
		           <input name="fundName" required class="form-control" placeholder="Max 25 Characters">
		          </div>
	        </div>
        </div>
        <br>
        <div class="form-group">
	        <div class="row">
		          <div class="col-xs-2">
		             <label>Ticker:<span class="astreik">*</span></label>
		          </div>
		          <div class="col-md-6">
		     	     <input name="ticker" required class="form-control" maxlength="5" placeholder="Max 5 Character Capital Ex: DSPBR">          
		          </div>
	        </div>        
        </div> 
		<br>
        <div class="row">
        <div class="col-xs-6" align="right">
        <input type="submit" class="btn btn-default" name="action" value="Create Fund">
        <br><br><br>
        </div>
        </div>
      </form>
    </div>
<jsp:include page="template-buttom.jsp" />

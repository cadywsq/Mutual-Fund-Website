<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-employee-top.jsp" />
  <div>
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <h3> Create Customer Account</h3>
      </div>
    </div>
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
      <form role="form">
        <div class="form-group">
        <div class="row">
          <div class="col-xs-2">
            <label>User Name:<span class="astreik">*</span></label>
          </div>
          <div class="col-md-2">
            <label id="user"><u><b>abc123</b></u></label>
          </div>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-2">
            <label>First Name:<span class="astreik">*</span></label>
          </div>
          <div class="col-md-3">
           <input name="firstName" required class="form-control">
          </div>
          <div class="col-xs-2">
            <label>Last Name:<span class="astreik">*</span></label>
          </div>
          <div class="col-md-3">
           <input name="lastName" required class="form-control">
          </div>
        </div>
        <br>
        <div class="row">
          <div class="col-xs-2">
            <label>Password:<span class="astreik">*</span></label>
          </div>
          <div class="col-md-3">
          <input name="confirm" type="password" required class="form-control">          
          </div>
          <div class="col-xs-2">
          <label>Confirm Password:<span class="astreik">*</span></label>
          </div>
          <div class="col-md-3">
            <input name="password" type="password" required class="form-control" placeholder="This is case sensitive field.">
          </div>
        </div>        
        <div class="form-group">
        <div class="row">
          <div class="col-xs-5">
          <label>Address line 1:<span class="astreik">*</span></label>
          <input class="form-control" name="addrLine1" paceholder="Address Line 1" required class="form-control">
          </div>
          <div class="col-xs-5">
          <label>Address line 2:<span class="astreik">*</span></label>
          <input class="form-control" name="addrLine2" paceholder="Address Line 2 (Optional)" >
          </div>
          </div>
        </div>
          <br>
          
          <div  class="form-group">
        <div class="row">
         <div class="col-xs-1">
              <label>City:<span class="astreik">*</span></label>
          </div>
         <div class="col-xs-2">
          <input class="form-control" name="city">
          </div>
          <div class="col-xs-1">
          <label>State:<span class="astreik">*</span> </label>
          </div>
          <div class="col-xs-2">
          <input name="state" class="form-control">
          </div>
           <div class="col-xs-2">
          <label>Zip code:<span class="astreik">*</span> </label>
          </div>
          <div class="col-xs-2">
          <input name="zip" class="form-control" placeholder="Use format: 12345" maxlength="5">
          </div>
        </div>
        </div>
        <br>
        <div class="row">
        <div class="col-xs-6" align="right">
        <button type="submit" name="create" class="btn btn-default">Create Customer</button>
        </div>
        </div>
      </form>
    </div>
<jsp:include page="template-buttom.jsp" />

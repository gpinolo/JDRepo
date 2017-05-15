<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
	<title>Login Page</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="resources/css/login.css" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="resources/js/jquery/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>


</head>

<body onload='document.f.j_username.focus();' class="loginPage">

	<div class="row-fluid">
		<div class="span6 offset3">
			<header>
				<div class="header_logo"></div>
			</header>
		</div>
	</div>

	<div class="row-fluid">

		<div class="span4 offset4">
		
			<div class="box">

				<div class="well loginFormWell">Login</div>

				<c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}">
					<div class="row-fluid error-row lastException">
						<div class="span12">
							<div class="alert alert-error">
								<!-- Your login attempt was not successful, try again.<br /> Caused By: -->
								${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
								<c:remove var="SPRING_SECURITY_LAST_EXCEPTION"/>
							</div>
						</div>
					</div>
				</c:if>
				
				<c:if test="${not empty requestScope['passwordSuccessfullyChanged']}">
					<div class="row-fluid error-row">
						<div class="span12">
							<div class="alert alert-success">Password Successfully Changed
							</div>
						</div>
					</div>
				</c:if>

				<form id="loginForm" class="well loginForm" name='f'
					action="<c:url value='j_spring_security_check' />" method='POST'>
	
					<div class="control-group custom-form no-margin">
	
						<div class="controls">
							<label for="j_username">Username</label>
	
							<div class="marker">
								<input class="input-xlarge" type="text" name="j_username"
									id="j_username" value="">
							</div>
							<span class="help-inline hide">Mandatory field</span>
						</div>
	
					</div>
	
					<div class="control-group custom-form">
	
						<div class="controls">
							<label for="j_password">Password</label>
	
							<div class="marker">
								<input class="input-xlarge" type="password" name="j_password"
									id="j_password" value="" />
							</div>
							<span class="help-inline hide">Mandatory field</span>
						</div>
	
					</div>
	
					<div class="control-group custom-button clearfix no-margin">
						<button class="btn btn-small pull-right" type="submit">Login</button>
					</div>
	
					<span class="fields hide">* = mandatory fields</span>
				</form>
			
				<div class="shadow"></div>
			</div>
			
			<footer>
				<div class="footer_logo"></div>
			</footer>
			
		</div>

	</div>


	<c:if test="${not empty requestScope['WRNPWDEXPIRED']}">

		<div id="passwordExpirationModal" class="modal hide">
			<div class="modal-header">
				<h3>Warning</h3>
			</div>
			<div class="modal-body">
				<div class="row-fluid">
					<div class="span12">
						<div class="alert">
							<span>Your password will expire in</span>
							<strong class="days">${WRNPWDEXPIRED}</strong> 
							<span>days</span>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span2 offset5">
						<a href="#" id="passwordExpirationModalOkButton" data-dismiss="modal" class="btn btn-small btn-block">Ok</a>
					</div>
				</div>
			</div>
<!-- 			<div class="modal-footer"></div> -->
		</div>

		<script type="text/javascript">
			
			var redirectUrl = '${redirectUrl}';
			
			$(function() {
				$("#passwordExpirationModal").modal();
			});
			
			$("#passwordExpirationModal").on('click', '#passwordExpirationModalOkButton', function(e) {
				e.preventDefault();
				
				if (redirectUrl) location.href = redirectUrl;
			});
			
		</script>

	</c:if>
	
	<c:if test="${not empty requestScope['changePassword']}">

		<div id="changePasswordModal" class="modal hide">
			<div class="modal-header">
				<h3>Change Password</h3>
			</div>
			<div class="modal-body">
				
			<c:if test="${not empty requestScope['changePasswordErrorMessage']}">
				<div class="row-fluid changePasswordErrorMessage">
					<div class="span12">
					
						<div class="alert alert-error">
							<span>
								<!-- Your attempt to change password was not successful. <br /> Caused By: -->
								${changePasswordErrorMessage}
							</span>
						</div>
						
					</div>
				</div>
			</c:if>
				
				<div class="row-fluid hide alert-row">
					<div class="span12">
					
						<div class="alert alert-error">
							<span class="alert-message">
								
							</span>
						</div>
					
					</div>
				</div>
				
				<div class="row-fluid">
					<div class="span12">
		
						<form id="changePasswordForm" name='changePasswordForm' action="<c:url value='ChangePasswordServlet' />" method='POST'>
		
							<div class="control-group">
		
								<div class="controls">
									<label for="oldPassword">Enter Old Password</label>
									
									<div class="marker">
										<input class="input" type="password" type="text" name="oldPassword" id="oldPassword" value="">
									</div>
									<span class="help-inline">Old password</span>
								</div>
		
							</div>
		
							<div class="control-group no-margin clearfix">
		
								<div class="controls controls-row span7">
									<label for="newPassword">Enter New Password</label>
									
									<div class="marker">
										<input class="input" type="password" name="newPassword" id="newPassword" value="" />
									</div>
									<span class="help-inline">Password</span>
								</div>
								<!--
								<div class="controls controls-row not-validated span2 offset2">
									<label for="expireDate">Expire Date</label>
									
									<input class="input-mini" type="text" name="expireDate" id="expireDate" disabled="disabled" value="" />
									<span class="help-inline"></span>
								</div>
		 						-->
							</div>
							
							<div class="control-group">
		
								<div class="controls">
									<label for="confirmNewPassword">Confirm New Password</label>
									
									<div class="marker">
										<input class="input" type="password" name="confirmNewPassword" id="confirmNewPassword" value="" />
									</div>
									<span class="help-inline">Confirm New Password</span>
								</div>
		
							</div>

							<!-- hidden fields to propagate request parameters -->
							<input type="hidden" name='username' value="${username}" />
							<input type="hidden" name='loginUrl' value="j_spring_security_check" />
							
						</form>
		
					</div>
				</div>
				
				<div class="row-fluid">
		
					<div class="span2 offset4">
						<a href="#" id="changePasswordModalOkButton" class="btn btn-small btn-block">OK</a> 
					</div>
					
					<div class="span2">
						<a href="#" id="changePasswordModalCancelButton" data-dismiss="modal" class="btn btn-small btn-block">Cancel</a>
					</div>
					
				</div>
				
			</div>
			
<!-- 			<div class="modal-footer"></div> -->
		</div>
		
		<script type="text/javascript">
			
			var redirectUrl = '${redirectUrl}';
			
			$(function() {
				$('#changePasswordModal').modal('show');
			});
			
			$("#changePasswordModal").on('click', '#changePasswordModalOkButton', function(e) {
				e.preventDefault();
				if ( checkFormEmptyFields( $("#changePasswordForm") ) && comparePasswords( $("#newPassword"), $("#confirmNewPassword") ) ) 
					$('#changePasswordForm').submit();
			});
			
			$("#changePasswordModal").on('click', '#changePasswordModalCancelButton', function(e) {
				e.preventDefault();
// 				$('#changePasswordModal').modal('hide');
			});
			
		</script>

	</c:if>

	<script type="text/javascript">
		$(function() {

			$("#loginForm").submit(function() {

				$(".error-row").hide();
				
				return checkFormEmptyFields( $(this) );
				
			});

		});
		
		function checkFormEmptyFields( $form ) {
			var result = true;
			
			$form.find(".control-group").each(function( i, controlGroup ) {
				var $controlGroup = $(controlGroup);
				
				$controlGroup.find("input").each(function( i, input ) {
					var $input = $(input);
					var $helpInline = $controlGroup.find(".help-inline");
					
					if ( !$input.val() && !$input.parent().hasClass("not-validated") ) {
						$helpInline.removeClass("hide");
						$controlGroup.addClass("error");
						result = false;
					} else if ( !$input.parent().hasClass("not-validated") ) {
						$helpInline.addClass("hide");
						$controlGroup.removeClass("error");
					}
				
				});
				
				
			});
			
			return result;
		}
		
		function comparePasswords( $new, $repeat ) {
			var equal = $new.val() == $repeat.val();
			
			if (!equal) {
				$(".changePasswordErrorMessage").addClass("hide");
				$("#changePasswordModal .alert-row").removeClass("hide").find(".alert-message").html("Passwords do not match!");
			}
			
			return equal;
		}
		
	</script>

</body>
</html>
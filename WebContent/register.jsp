<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:master title="Register">
	<jsp:attribute name="body">
		<div class="container" style="min-height: 70vh;">
			<div class="row">
				<h3 class="center-align">Register</h3>
				<form method="POST" action="register" class="col s12" id="registerForm">
					<div class="row">
				        <div class="input-field col s6">
				          <input name="firstName" type="text"/>
				          <label for="first_name">First Name*</label>
				        </div>
				        <div class="input-field col s6">
				          <input name="lastName" type="text"/>
				          <label for="lastName">Last Name*</label>
				        </div>
			        </div>
			        <div class="row">
			        	<div class="input-field col s12">
			        		<input id="address" name="address" type="text"/>
			        		<label for="address">Address*</label>
			        	</div>
			        </div>
			        <div class="row">
			        	<div class="input-field col s12">
			        		<input id="email" name="email" type="text"/>
			        		<label for="email">Email*</label>
			        	</div>
			        </div>
			        <div class="row">
			        	<div class="input-field col s12">
			        		<input id="password" name="password" type="password"/>
			        		<label for="password">Password*</label>
			        	</div>
			        	<div class="input-field col s12">
			        		<input id="confirmPassword" name="confirmPassword" type="password"/>
			        		<label for="password">Confirm Password*</label>
			        	</div>
			        </div>
			        <div class="row">
			        	<div id="terms" class="center-align">
			        		<label>
			        		<input type="checkbox" name="agreement" id="agreement"/>
			        		<span>I agree to the <a href="#">terms and services</a></span>
			        		</label>
			        	</div>
			        </div>
			        <button class="btn waves-effect waves-light left" type="submit">Register
			        	<i class="material-icons right">person_add</i>
			        </button>
					<button id="clear" class="btn waves-effect waves-light right">Clear
						<i class="material-icons right">clear</i>
					</button>
				</form>
			</div>
		</div>
	</jsp:attribute> 
	<jsp:attribute name="script">
		<script>
			$(window).ready(function(){
				var form = $("#registerForm");
				$.validator.addMethod("password", function(value,element){
					return this.optional(element) || /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#?!@$%^&*-]).{8,}$/.test(value)
				}, "Password must be 6-12 length, contains at least one capital letter and 1 special character")
				$("#clear").click(function(e){
					form.trigger("reset");
				})
				form.validate({
					rules: {
						firstName: {
							required: true
						},
						lastName: {
							required: true
						},
						address: {
							required: true
						},
						email: {
							email: true,
							required: true,
						},
						password: {
							password: true,
							required: true,
						},
						confirmPassword: {
							required: true,
							equalTo: "#password"
						}
					},
					errorElement: 'span',
					errorPlacement: function (error, element) {
						error.addClass("red-text")
					    var placement = $(element).data('error');
					    if (placement) {
					        $(placement).append(error)
					        
					    } else {
					        error.insertAfter(element);
					    }
					},
					submitHandler: function(form) {
					    if(!$("#agreement").is(":checked") || !form.valid()){
					    	return false;
					    }
						form.submit();
					}
				})
			})
		</script>
	</jsp:attribute>
</t:master>
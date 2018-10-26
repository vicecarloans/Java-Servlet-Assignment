<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master title="Login">
	<jsp:attribute name="head">
		<style>
			.g-recaptcha > div {
				margin:auto
			}
		</style>
	</jsp:attribute>
	<jsp:attribute name="body">
		<div class="container" style="min-height: 70vh;">
			
			<div class="row">
				<h3 class="center-align">Login</h3>
				<form method="POST" action="auth" class="col s12" id="loginForm">
				    <div class="row">
				    	<div class="input-field col s12">
				    		<input id="email" name="email" type="text"/>
				    		<label for="email">Email</label>
				    	</div>
				    </div>
				    <div class="row">
				    	<div class="input-field col s12">
				    		<input id="password" name="password" type="password"/>
				    		<label for="password">Password</label>
				    	</div>
				    </div>
				    <div class="g-recaptcha" data-sitekey="6LdF63YUAAAAAE_rrnulFDgPAdIPK93i7J3MZum5"></div>
			    	<div class="row">
				   		<div class="center-align">
				   			<p>Don't have an account? <a href="register.jsp"> Register with us today</a></p>
				   		</div>
				   	</div>
			    	<button class="btn waves-effect waves-light right" type="submit" name="action">Login
				    	<i class="material-icons right">send</i>
				  	</button>
				    
				</form>
			</div>
		</div>
	</jsp:attribute>
	<jsp:attribute name="script">
		<script>
			$(window).ready(function(){
				$.validator.addMethod("password", function(value,element){
					return this.optional(element) || /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#?!@$%^&*-]).{8,}$/.test(value)
				}, "Password must be 6-12 length, contains at least one capital letter and 1 special character")
				var form = $("#loginForm");
				form.validate({
					rules: {
						email: {
							required: true,
							email: true
						},
						password: {
							required: true,
							password: true
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
					    if(!form.valid()){
					    	return false;
					    }
						form.submit();
					  }
				});
				
			})

		</script>
	</jsp:attribute>
</t:master>
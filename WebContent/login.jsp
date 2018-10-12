<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master title="Login">
	<jsp:attribute name="body">
		<div class="container" style="min-height: 70vh;">
			
			<div class="row">
				<h3 class="center-align">Login</h3>
				<form method="POST" action="auth" class="col s12">
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
				    <div class="row center-align">
				    	<label>
				    		<input type="checkbox"/>
				    		<span>I am not a robot</span>
				    	</label>
				    </div>
				  
			    	<button class="btn waves-effect waves-light right" type="submit" name="action">Submit
				    	<i class="material-icons right">send</i>
				  	</button>
				   
				    
				</form>
			</div>
		</div>
	</jsp:attribute>
</t:master>
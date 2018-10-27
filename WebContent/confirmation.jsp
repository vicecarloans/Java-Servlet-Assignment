<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:master title="Confirmation">
	<jsp:attribute name="body">
		<div class="container" style="min-height: 70vh;">
			<h3>An email has been sent to your inbox. Please check your email to verify and confirm</h3>
			<p><a href="login.jsp">Take me back to login</a></p>
		</div>
	</jsp:attribute>
</t:master>
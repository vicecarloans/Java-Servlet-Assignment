<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="title"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="script" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   	   <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 	<!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
	<script src='https://www.google.com/recaptcha/api.js?onload=recaptchaCallback&render=explicit"' async defer></script>
	     
	<title>${title}</title>
    <jsp:invoke fragment="head"/>
</head>
<body>
	<nav>
		<div class="nav-wrapper teal lighten-2">
			<a href="dashboard.jsp" class="brand-logo">Securely</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li style="margin-right:10px;">Welcome, <%= session.getAttribute("user") %> </li>
				<li><a href="signout">Sign Out</a></li>
			</ul>
		</div>
	</nav>
    <jsp:invoke fragment="body"/>
   	<footer class="page-footer teal lighten-2">
		<div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Securely</h5>
                <p class="grey-text text-lighten-4">A platform that makes online transaction with ease.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Blog</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Pricing</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">FAQ</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Contact</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            &copy; Made by the IT Guys
            </div>
          </div>
	</footer>
	<jsp:invoke fragment="script"/>
</body>
</html>
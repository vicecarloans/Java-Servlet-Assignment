<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="title"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   	   <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 	<!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
     
	<title>${title}</title>
    <jsp:invoke fragment="head"/>
</head>
<body>
	<nav>
		<div class="nav-wrapper">
			<a href="#" class="brand-logo">Secured</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
			</ul>
		</div>
	</nav>
    <jsp:invoke fragment="body"/>
   	<footer class="page-footer">
		<div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
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
</body>
</html>
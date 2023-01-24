<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<c:if test="${ !empty error }">
		<p><c:out value=" ${ error } !" /></p>
		</c:if>
		<form method="post" action="Login">
		  	<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Pseudo</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="pseudo" id="pseudo">
			    </div>
			 </div>
			 <div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="password" name="password">
			    </div>
		  	</div>
		  	<input type="submit" value="Valider">
	  	</form>
	</body>
</html>
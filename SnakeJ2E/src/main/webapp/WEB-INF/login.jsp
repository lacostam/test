<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
				    <form method="post" action="Accueil">
		  <div class="mb-3 row">
			    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
			    <div class="col-sm-10">
			      <input type="email" class="form-control" name="pseudo">
			    </div>
			  </div>
			  <div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="inputPassword" name="password">
			    </div>
		  </div>
		  <input type="submit" value="Valider">
		  </form>
	</body>
</html>
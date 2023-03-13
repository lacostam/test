<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div class="card" style="width: 60em; margin-left: 2em;margin-top: 2em;">
		  	<div class="card-body">
				<c:if test="${ !empty error }">
					<div class="alert alert-danger" role="alert">
				  		<c:out value=" ${ error } !" />
					</div>	
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
				  	<input class="btn btn-primary" type="submit" value="Valider">
			  	</form>
			  	<a  type="submit" href="NewAccount"  >Create a account</a>
	  		</div>
	  	</div>
	</body>
</html>
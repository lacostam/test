<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div class="card" style="width: 50em; margin-left: 2em;margin-top: 2em;">
		  	<div class="card-body">
			<c:if test="${ !empty error }">
				<div class="alert alert-danger" role="alert">
			  		<c:out value=" ${ error } !" />
				</div>	
			</c:if>
			 <form method="post" action="NewAccount">
			  	<div class="mb-3 row">
				    <label for="inputPassword" class="col-sm-2 col-form-label">Nouveau pseudo</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="pseudo" id="pseudo">
				    </div>
				 </div>
				 <div class="mb-3 row">
				    <label for="inputPassword" class="col-sm-2 col-form-label">Nouveau password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="password" name="password">
				    </div>
			  	</div>
			  	<input type="submit" class="btn btn-primary" value="Create account">
		  	</form>
		  	</div>
		  </div>
	</body>
</html>



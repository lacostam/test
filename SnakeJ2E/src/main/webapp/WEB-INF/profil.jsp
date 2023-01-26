<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div class="card" style="width: 16em; margin-left: 2em;margin-top: 2em;">
		  	<div class="card-body">
		  	 <ul class="list-group list-group-flush">
			    <li class="list-group-item"><c:out value="Pseudo:  ${ user.pseudo }	" /></li>
			   	<li class="list-group-item"><c:out  value="Password:  ${ user.password }	" /></li> 
			   	<li class="list-group-item">	
			   	<form NAME="deleteAccount" ACTION="Logout" METHOD="POST">
					<input type="submit" class="btn btn-danger"  value="Supprimer le compte" />
        		</FORM>
        		</li>
			  </ul>
		  	

        	</div>
		</div>
	</body>
</html>
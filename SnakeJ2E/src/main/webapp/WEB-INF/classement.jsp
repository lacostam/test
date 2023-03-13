<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		
		
		<div class="card" style="width: 40em; margin-left: 5em;margin-top: 2em;">
		  	<div class="card-body">		     
		  	 <h1>Classement</h1>
		      <table class="table">	     
		        <thead>
		          <tr>
		            <th>Pseudo</th>
		            <th>Score</th>
		          </tr>
		        </thead>
		        <tbody>
		           	<c:forEach items="${liste}" var="i">
		           		<tr>
				      		<td>${i.pseudo}</td>
				            <td>${i.score}</td>
				        </tr>
			            
		       		</c:forEach>
		        </tbody>
		      </table>
    	</div>
    	</div>
	
	
		
	</body>
</html>
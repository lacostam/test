<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div class="container" Align=Center style="margin-top: 2em;">
			<c:if test="${ !empty sessionScope.user }">
				<img src="images/snake.png">
				<h1><span style="border-radius:10px"><c:out value="Bonjour ${ user.pseudo } !" /></span></h1> 
			</c:if>
		</div>		
	</body>
</html>
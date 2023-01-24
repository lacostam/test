<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div class="container" Align=Center>
			<c:if test="${ !empty sessionScope.pseudo }">
				<h1><span style="background-color: #198754 ; border-radius:10px"><c:out value="Bonjour ${ sessionScope.pseudo } !" /></span></h1> 
			</c:if>
		</div>		
	</body>
</html>
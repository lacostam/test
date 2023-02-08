<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Snake Game</title>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div class="row">
		  <div class="col-sm-6 mb-3 mb-sm-0" style="width: 25em; margin-left: 2em">
		    <div class="card">
		        <img src="..." class="card-img-top">
				  <div class="card-body">
				    <h5 class="card-title">Skin 1</h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					<c:choose>
					<c:when test="${ !empty sessionScope.user }">
					<a href="#" class="btn btn-primary">Acheter</a>
					</c:when>
					<c:when test="${ empty sessionScope.user }">
					<a href="Login" class="btn btn-primary">Acheter</a>
					</c:when>
					</c:choose>
				</div>
		    </div>
		  </div>
		  
		  
		  <div class="col-sm-6" style="width: 25em;"	>
		    <div class="card">
		        <img src="images/snake.jpg" class="card-img-top"/>
				  <div class="card-body">
				    <h5 class="card-title">Skin 2</h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				 	<a href="#" class="btn btn-primary">Acheter</a>
				</div>
		    </div>
		  </div>
		</div>
	</body>
</html>
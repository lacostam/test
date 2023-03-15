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
		        <img src="images/whiteSkin.png" width=100% height=100% >
				  <div class="card-body">
				    <h5 class="card-title">White Skin</h5>
				    <p class="card-text">Ce skin est incroyable vite achete le !</p>
					<c:choose>
					<c:when test="${ !empty sessionScope.user }">
					<a href="#" class="btn btn-primary">Acheter</a>
					</c:when>
					</c:choose>
				</div>
		    </div>
		  </div>
		  
		  
		  <div class="col-sm-6" style="width: 25em;"	>
		    <div class="card">
		        <img src="images/pinkSkin.png" width=100% height=100% >
				  <div class="card-body">
				    <h5 class="card-title">Pink Skin</h5>
				    <p class="card-text">Ce skin est incroyable vite achete le !</p>
				 	<a href="#" class="btn btn-primary">Acheter</a>
				</div>
		    </div>
		  </div>
		</div>
	</body>
</html>
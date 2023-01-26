<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
		  <div class="container-fluid">
		  
		    <a class="navbar-brand" href="Accueil">Snake Game</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="Accueil">Accueil</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="Classement">Classement</a>
		        </li>
		         <li class="nav-item">
			          <a class="nav-link" href="Shop">Shop</a>
			    </li>
		       	<c:if test="${ !empty sessionScope.user }">
			        <li class="nav-item">
			          <a class="nav-link" href="#">Historique</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="Profil">Profil</a>
			        </li>
		        </c:if>
		      </ul>
		      <form class="d-flex" role="search">
		      	<c:if test="${ !empty sessionScope.user }">
        			<a class="btn btn-outline-success" type="submit" href="Logout">logout</a>
        		</c:if>
        		<c:if test="${ empty sessionScope.user }">
        			<a class="btn btn-outline-success" type="submit" href="Login" >login</a>
      		  	</c:if>
      		  </form>  
		    </div>
		  </div>
</nav>
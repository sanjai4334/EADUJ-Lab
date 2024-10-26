<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="d-flex vh-100 bg-dark">
	<div class="m-auto border border-3 rounded p-5">
	    <h2 class="text-light mb-3">Register User</h2>
	    <form action="RegisterServlet" method="post">
	    	<div class="form-floating mb-3">	    	
			    <input type="text" class="form-control" id="username" name="username" placeholder="JohnDoe">
			    <label for="username">Username</label>
	    	</div>
	    	<div class="form-floating mb-3">	    	
			    <input type="email" class="form-control" id="email" name="email" placeholder="johndoe@gmail.com">
			    <label for="email">Email</label>
	    	</div>
	    	<div class="form-floating mb-3">	    	
			    <input type="password" class="form-control" id="password" name="password"  placeholder="">
			    <label for="password">Password</label>
	    	</div>
	    	<input type="submit" class="btn btn-outline-light" value="Register">
	    </form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>



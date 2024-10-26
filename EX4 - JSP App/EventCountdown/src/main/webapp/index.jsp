<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Event Countdown</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="display: grid; place-items: center; height: 100%;">
	<div class="w-50 h-25">	
	    <h1>Event Countdown</h1>
	    <form action="countdown.jsp" method="post">
	    	<div class="form-floating">
			  <input type="Date" class="form-control" id="eventDate" placeholder="Event Date" name="eventDate">
			  <label for="eventDate">Event Date</label>
			</div>
	        <input type="submit" class="btn btn-success m-2" value="Start Countdown">
	    </form>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

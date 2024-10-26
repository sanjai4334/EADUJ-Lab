<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Countdown Timer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script>
        // Function to start the countdown
        function startCountdown(eventDate) {
            // Update the count down every 1 second
            var countdownInterval = setInterval(function() {
                var now = new Date().getTime();
                var distance = eventDate - now;

                // Time calculations for days, hours, minutes and seconds
                var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                // Display the result in an element with id="countdown"
               document.getElementById("countdown").innerHTML = 
				    "<div class=\"row text-center m-5\">" +
				        "<div class=\"col bg-primary text-light p-3 m-1 rounded d-flex flex-column justify-content-center align-items-center\">" +
				            "<span class=\"fs-2 fw-bold\">" + days + "</span>" +
				            "<span class=\"fs-6\">days</span>" +
				        "</div>" +
				        "<div class=\"col bg-primary text-light p-3 m-1 rounded d-flex flex-column justify-content-center align-items-center\">" +
				            "<span class=\"fs-2 fw-bold\">" + hours + "</span>" +
				            "<span class=\"fs-6\">hours</span>" +
				        "</div>" +
				        "<div class=\"col bg-primary text-light p-3 m-1 rounded d-flex flex-column justify-content-center align-items-center\">" +
				           "<span class=\"fs-2 fw-bold\">" + minutes + "</span>" +
				           "<span class=\"fs-6\">minutes</span>" +
				       "</div>" +
				       "<div class=\"col bg-primary text-light p-3 m-1 rounded d-flex flex-column justify-content-center align-items-center\">" +
				           "<span class=\"fs-2 fw-bold\">" + seconds + "</span>" +
				           "<span class=\"fs-6\">seconds</span>" +
				       "</div>" +
				   "</div>";


    

                // If the countdown is finished, display a message
                if (distance < 0) {
                    clearInterval(countdownInterval);
                    document.getElementById("countdown").innerHTML = "The event has already passed.";
                }
            }, 1000);
        }

        // Get the event date from the server and start the countdown
        window.onload = function() {
            var eventDateStr = '<%= request.getParameter("eventDate") %>';
            var eventDate = new Date(eventDateStr + "T00:00:00"); // Set to midnight of the event date
            startCountdown(eventDate.getTime());
        };
    </script>
</head>
<body>
    <h1>Countdown to Your Event</h1>
    <div id="countdown"></div>
    <a href="index.jsp" class="btn btn-secondary">Back to Input</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

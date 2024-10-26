package LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String VALID_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Welcome</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".card { background: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); width: 300px; text-align: center; }");
        out.println("</style></head><body>");

        // Check if the credentials are correct
        if (VALID_PASSWORD.equals(password)) {
            String username = email.substring(0, email.indexOf('@')); // Extract username from email
            out.println("<div class=\"card\">");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<p>Email: " + email + "</p>");
            out.println("</div>");
        } else {
            out.println("<div class=\"card\">");
            out.println("<h1>Invalid email or password.</h1>");
            out.println("</div>");
        }

        out.println("</body></html>");
        out.close();
    }
}

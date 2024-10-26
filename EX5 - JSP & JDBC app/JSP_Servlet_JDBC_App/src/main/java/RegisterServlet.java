import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/userdb", "root", "mysql");

            // SQL query
            String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            int row = pstmt.executeUpdate();

            if (row > 0) {
                // Forward to success page
                request.setAttribute("username", username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().write("Registration Failed.");
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error occurred: " + e.getMessage());
        }
    }
}

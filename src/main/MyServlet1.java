import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

// This annotation declares that this class is a servlet and specifies the URL pattern it will handle.
@WebServlet("/Myserv")
public class MyServlet1 extends GenericServlet {

    // This method is called to handle requests to the servlet.
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // Sets the content type of the response to HTML.
        response.setContentType("text/html");
        // Retrieves the PrintWriter object for writing HTML content to the response.
        PrintWriter out = response.getWriter();
        System.out.println("Servlet is called");
        // Retrieves the locale set for the response.
        Locale loc = response.getLocale();
        // Writes a message to the response indicating the locale set for the application.
        out.println("Locale set for this application is " + loc.toString());
    }
}

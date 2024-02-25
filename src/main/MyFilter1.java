import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

// This annotation declares that this class is a servlet filter and specifies the URL pattern it will filter.
@WebFilter("/Myserv")
public class MyFilter1 implements Filter {

    // Initializes the filter. This method is called by the servlet container when the filter is instantiated.
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // Destroys the filter. This method is called by the servlet container when the filter is being removed from service.
    public void destroy() {

    }

    // This method is called for each request that the filter intercepts.
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // Sets the content type of the response to HTML.
        response.setContentType("text/html");
        // Retrieves the PrintWriter object for writing HTML content to the response.
        PrintWriter out = response.getWriter();
        // Writes a message indicating that the request is being filtered and passed to a wrapper class.
        out.println("<b> <i>Filtering request and passing it to Wrapper class</i> </b> <br/>");

        // Creates instances of custom wrapper classes for the request and response.
        RequestWrapper requestWrapper = new RequestWrapper(request);
        ResponseWrapper responseWrapper = new ResponseWrapper(response);

        // Passes the wrapped request and response objects to the next filter in the chain, or to the servlet if this is the last filter.
        chain.doFilter(requestWrapper, responseWrapper);

        // Retrieves the PrintWriter object from the response wrapper and writes a message indicating post-processing.
        responseWrapper.getWriter().println("Post-processing");
    }
}

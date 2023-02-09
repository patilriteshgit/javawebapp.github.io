
package newpackage;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;


public class secondservlet extends GenericServlet {
    @Override
    public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException
    {
        System.out.println("servicing.....");
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        out.println("<h1>this is the output from generic servlet<h1>");
        
    }
    
}

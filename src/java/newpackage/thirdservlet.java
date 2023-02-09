
package newpackage;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class thirdservlet extends HttpServlet 
{
    @Override
    public void doGet(HttpServletRequest reqs , HttpServletResponse resp)throws ServletException,IOException
    {
        resp.setContentType("text/HTML");
        PrintWriter out =resp.getWriter();
        out.print("<h1>Output from HTTP Servlet </h1>" );
    }
    
}


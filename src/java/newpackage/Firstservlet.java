
package newpackage;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Firstservlet implements Servlet
{
    //life cycle methods
    
    ServletConfig conf;
    @Override
    public void init(ServletConfig conf)
    {
        this.conf=conf;
        System.out.println("creating object..... ");
    }
    @Override
    public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException
    {
        System.out.println("servicing.....");
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        out.println("<h1>this is the output from servlet<h1>");
        
    }
    @Override
    public void destroy()
    {
        System.out.println("going to destroy");
    }
    // Non life cycle methods
    @Override
    public ServletConfig getServletConfig()
    {
        return this.conf;
    }
    @Override
    public String getServletInfo()
    {
        return("created by ritzz patil");
    }
}


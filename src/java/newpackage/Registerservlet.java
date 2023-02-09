
package newpackage;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registerservlet extends HttpServlet
{
        static final String DB_URL = "jdbc:mysql://localhost/registerdb";
        static final String USER = "root";
        static final String PASS = "rits@7";
        static String addquery ="INSERT INTO servletdb VALUES (?,?,?)";
        static String dispquery ="select * from servletdb where sname=? and spw=?";

    @Override
    protected void doPost(HttpServletRequest reqs, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/HTML");
        PrintWriter out =resp.getWriter();
        out.println("<h1>Welcome to Register Servlet</h1>");
        out.println("<h1>Your Data is processed as</h1>");
        //Fetching data from the form
        String username = reqs.getParameter("user_name");
        String usermail = reqs.getParameter("user_mail");
        String userpw = reqs.getParameter("user_pw");
        
        // Printing fetched data on screen (similar op can be performed by these variables)
        out.println ("you entered name : "+ username);
        out.println ("you entered password: "+ userpw);
        out.println ("you entered mail ID : "+ usermail);
        out.println("<br>");
        out.println("<h1><a href=index.html>GO TO REGISTRATION PAGE AGAIN</a></h1>");
        
        
        
    //jdbc self try2
    try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement pstmt =conn.prepareStatement(addquery);
         PreparedStatement pstmt2 =conn.prepareStatement(dispquery);
         
         
         //check login id name and pw found in db
         pstmt2.setString(1,username);
         pstmt2.setString(2,userpw);
         ResultSet set = pstmt2.executeQuery();
         if(set.next()){
             RequestDispatcher rd= reqs.getRequestDispatcher("loginsuccess.jsp");
             rd.forward(reqs, resp);
         }
         else{
         // Execute a query
         out.println("Inserting records into the table...");          
         pstmt.setString(1,username);
         pstmt.setString(2,usermail);
         pstmt.setString(3,userpw);
        //execcute
         pstmt.executeUpdate();
         out.println("Inserted records into the table...");
         }
            
        
      } catch (SQLException e) {
         e.printStackTrace();
      }     catch (ClassNotFoundException ex) { 
                Logger.getLogger(Registerservlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
   }
        
          
        }
        
    

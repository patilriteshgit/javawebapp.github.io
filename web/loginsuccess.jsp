
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1 style="color: blue">LOGIN SUCCESSFULL </h1>
        <h1>YOUR NAME AND PW MATCH IN THE FOLLOWING DATA DB </h1>
        <sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/registerdb" user="root" password="rits@7" var="ds"></sql:setDataSource>
        <sql:query dataSource="${ds}" var="rs">select * from servletdb;</sql:query>
        <div class="container">
        <table class="table">
            <tr>
                <td>USER NAME</td>
                <td>USER mail</td>
                <td>USER password</td>
            </tr>
        <c:forEach items="${rs.rows}" var="row">
            <tr>
                <td><c:out value="${row.sname}"></c:out></td>
                <td><c:out value="${row.smail}"></c:out></td>
                <td><c:out value="${row.spw}"></c:out></td>
            </tr>
        </c:forEach>
        </table>
        
            <div>
                <h2>
                    <table>
                    <form action="deletusername.jsp"></td>
                        <tr>
                            <td><input  type="text" name="deletname"></td>
                            <td><button type="submit">DELETE</button></td>
                        </tr>   
                    </form>
                    </table>
                </h2>
            </div>
        
        </div>
    </body>
</html>

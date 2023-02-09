
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>deleting user</title>
    </head>
    <body>
        <h2>processing to delet user</h2>
        <%--<c:set var="delname" value="Ritesh"></c:set>--%>
        <sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/registerdb" user="root" password="rits@7" var="ds"></sql:setDataSource>
        <sql:update dataSource="${ds}" var="rs">
            delete from servletdb where sname=?;
            <sql:param value="${param.deletname}"></sql:param>  
        </sql:update>
        <h2>deleted username in DB </h2>
    </body>
</html>

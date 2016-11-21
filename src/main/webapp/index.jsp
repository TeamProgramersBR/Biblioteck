<%-- 
    Document   : index
    Created on : 21/11/2016, 20:08:09
    Author     : kai
--%>

<%@page import="br.harlock.dao.exemplarDAO"%>
<%@page import="br.harlock.conn.Conexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% 
        Conexao con = new Conexao();
        exemplarDAO dao = new exemplarDAO();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

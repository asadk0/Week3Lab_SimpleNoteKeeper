<%-- 
    Document   : viewnote
    Created on : Oct 2, 2020, 11:18:47 AM
    Author     : 759175
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><b>Title: ${note.title}</b></p>
        <p><b>Contents: </b><br> ${note.contents}</p>
        <a href="note?edit">Edit</a>
    </body>
</html>
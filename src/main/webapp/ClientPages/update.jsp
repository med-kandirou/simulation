<%@ page import="java.util.Optional" %>
<%@ page import="DTO.Client" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.function.Supplier" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 10/9/2023
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../Styles/style.css">
</head>
<body>
    <jsp:include page="../Component/header.jsp" />


    <div class="search-container">
        <input type="text" class="search-bar" placeholder="Rechercher...">
        <button class="search-button">Rechercher</button>
    </div>
    <div class="form-container">
        <%
            Optional<Client> c =(Optional<Client>)request.getAttribute("client");
            %>
        <form class="form" action="/client-update" method="post">
            <div hidden="hidden" class="form-group">
                <label >Code :</label>
                <input type="text" name="code" value="<%= c.get().getCode() %>">
            </div>
            <div class="form-group">
                <label >First Name :</label>
                <input type="text" name="fname" value="<%= c.get().getFirstName() %>">
            </div>
            <div class="form-group">
                <label >Last Name :</label>
                <input type="text" name="lname" value="<%= c.get().getLastName() %>">
            </div>
            <div class="form-group">
                <label >Birthday :</label>
                <input type="date" name="bday" value="<%= c.get().getBirthday() %>">
            </div>
            <div class="form-group">
                <label >Phone :</label>
                <input type="text" name="phone" value="<%= c.get().getPhone() %>">
            </div>
            <div class="form-group">
                <label >Adresse :</label>
                <input type="text" name="adresse" value="<%= c.get().getAdresse() %>">
            </div>
            <button type="submit" >Update</button>
        </form>

    </div>
</body>
</html>

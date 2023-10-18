<%@ page import="java.util.Optional" %>
<%@ page import="DTO.Client" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.function.Supplier" %>
<%@ page import="DTO.Employe" %><%--
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
        Optional<Employe> emp =(Optional<Employe>)request.getAttribute("employe");
    %>
    <form class="form" action="/employe-update" method="post">
        <div class="form-group">
            <label hidden="hidden" >Matricule :</label>
            <input type="text" name="matricule" value="<%= emp.get().getMatricule() %>">
        </div>
        <div class="form-group">
            <label >First Name :</label>
            <input type="text" name="fname" value="<%= emp.get().getFirstName() %>">
        </div>
        <div class="form-group">
            <label >Last Name :</label>
            <input type="text" name="lname" value="<%= emp.get().getLastName() %>">
        </div>
        <div class="form-group">
            <label >Birthday :</label>
            <input type="date" name="bday" value="<%= emp.get().getBirthday() %>">
        </div>
        <div class="form-group">
            <label >Phone :</label>
            <input type="text" name="phone" value="<%= emp.get().getPhone() %>">
        </div>
        <div class="form-group">
            <label >Adresse email:</label>
            <input type="text" name="adresseemail" value="<%= emp.get().getAdresseemail() %>">
        </div>
        <div class="form-group">
            <label >Recrutement Date :</label>
            <input type="date" name="drecrutement" value="<%= emp.get().getDaterecrutement() %>">
        </div>
        <button type="submit">Update</button>
    </form>

</div>
</body>
</html>

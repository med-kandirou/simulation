<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 10/9/2023
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>

<style>
    .navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 20px;
    }

    .navbar a {
        text-decoration: none;
        color: #000000;
        margin: 0 15px;
    }

    .logo {
        font-size: 20px;
    }

    .nav-links {
        list-style: none;
        display: flex;
    }

    .nav-links li {
        margin: 0 10px;
    }

    .nav-links a:hover {
        border-bottom: 2px solid #007bff;
        padding-bottom: 5px;
        transition: all 0.3s ease;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">
<nav class="navbar">
    <div class="logo">
        <img src="https://static.vecteezy.com/system/resources/previews/000/593/729/original/vector-bank-building-icon-isolated-on-white-background.jpg" height="100" width="100">
    </div>
    <ul class="nav-links">
        <li><a href="../index.jsp">Accueil</a></li>
        <li><a href="/client-display">Display clients</a></li>
        <li><a href="/client-create">Create client</a></li>
        <li><a href="/employe-display">Display employes</a></li>
        <li><a href="/employe-create">Create employe</a></li>
        <li><a href="/simulation-display">Simulation</a></li>
        <li><a href="/credit-display">Demandes</a></li>
    </ul>
</nav>


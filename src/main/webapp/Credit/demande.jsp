<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 10/21/2023
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css"  rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <jsp:include page="../Component/header.jsp" />
</head>
<body>

<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
    <div class="flex items-center justify-between pb-4 bg-white dark:bg-gray-900">
        <div>
            <button id="dropdownActionButton" data-dropdown-toggle="dropdownAction" class="inline-flex items-center text-gray-500 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-3 py-1.5 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700" type="button">
                <span class="sr-only">Action button</span>
                Action
                <svg class="w-2.5 h-2.5 ml-2.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
                </svg>
            </button>
            <!-- Dropdown menu -->
            <div id="dropdownAction" class="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700 dark:divide-gray-600">
                <ul class="py-1 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownActionButton">
                    <li>
                        <a href="/credit-display-etat?etat=encours" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">En cours</a>
                    </li>
                    <li>
                        <a href="/credit-display-etat?etat=accepte" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Accepte</a>
                    </li>
                    <li>
                        <a href="/credit-display-etat?etat=refuse" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Refuse</a>
                    </li>
                </ul>
            </div>
        </div>
        <label class="sr-only">Search</label>
        <div class="relative">
            <input type="date" id="search_date" class="block p-2 pl-10 text-sm text-gray-900 border border-gray-300 rounded-lg w-80 bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
        </div>
    </div>
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
        <tr>
            <th scope="col" class="px-6 py-3">
                Number Client
            </th>
            <th scope="col" class="px-6 py-3">
                Montant
            </th>
            <th scope="col" class="px-6 py-3">
                Taux
            </th>
            <th scope="col" class="px-6 py-3">
                Mensualité
            </th>
            <th scope="col" class="px-6 py-3">
                Dure
            </th>
            <th scope="col" class="px-6 py-3">
                Reamrks
            </th>
            <th scope="col" class="px-6 py-3">
                Date
            </th>
            <th scope="col" class="px-6 py-3">
                Status
            </th>
            <th scope="col" class="px-6 py-3">
                change status
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${credits}" var="credit">
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                <th scope="row" class="flex items-center px-6 py-4 text-gray-900 whitespace-nowrap dark:text-white">
                        ${credit.client.code}
                </th>
                <td class="px-6 py-4">
                        ${credit.montant}
                </td>
                <td class="px-6 py-4">
                        ${credit.taux}
                </td>
                <td class="px-6 py-4">
                        ${credit.mensualite}
                </td>
                <td class="px-6 py-4">
                        ${credit.dure}
                </td>
                <td class="px-6 py-4">
                        ${credit.remarks}
                </td>
                <td class="px-6 py-4">
                        ${credit.date}
                </td>
                <td class="px-6 py-4">
                        ${credit.etat}
                </td>
                <td class="px-6 py-4 flex gap-4 items-center justify-center">
                    <c:choose>
                        <c:when test="${credit.etat eq 'accepte'}">
                            <svg class="refuser" data-demande-num="${credit.number}" width="30px" height="30px" viewBox="0 0 512 512" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" fill="#ff0000" stroke="#ff0000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <style type="text/css"> .st0{fill:#ff0000;} .st1{fill:none;stroke:#ff0000;stroke-width:32;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;} </style> <g id="Layer_1"></g> <g id="Layer_2"> <g> <path class="st0" d="M263.24,43.5c-117.36,0-212.5,95.14-212.5,212.5s95.14,212.5,212.5,212.5s212.5-95.14,212.5-212.5 S380.6,43.5,263.24,43.5z M367.83,298.36c17.18,17.18,17.18,45.04,0,62.23v0c-17.18,17.18-45.04,17.18-62.23,0l-42.36-42.36 l-42.36,42.36c-17.18,17.18-45.04,17.18-62.23,0v0c-17.18-17.18-17.18-45.04,0-62.23L201.01,256l-42.36-42.36 c-17.18-17.18-17.18-45.04,0-62.23v0c17.18-17.18,45.04-17.18,62.23,0l42.36,42.36l42.36-42.36c17.18-17.18,45.04-17.18,62.23,0v0 c17.18,17.18,17.18,45.04,0,62.23L325.46,256L367.83,298.36z"></path> </g> </g> </g></svg>
                        </c:when>
                        <c:when test="${credit.etat eq 'refuse'}">
                            <i data-demande-num="${credit.number}" class="fa-solid fa-square-check text-3xl valider" style="color: #59ff00;"></i>
                        </c:when>
                        <c:when test="${credit.etat eq 'encours'}">
                            <svg class="refuser" data-demande-num="${credit.number}" width="30px" height="30px" viewBox="0 0 512 512" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" fill="#ff0000" stroke="#ff0000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <style type="text/css"> .st0{fill:#ff0000;} .st1{fill:none;stroke:#ff0000;stroke-width:32;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;} </style> <g id="Layer_1"></g> <g id="Layer_2"> <g> <path class="st0" d="M263.24,43.5c-117.36,0-212.5,95.14-212.5,212.5s95.14,212.5,212.5,212.5s212.5-95.14,212.5-212.5 S380.6,43.5,263.24,43.5z M367.83,298.36c17.18,17.18,17.18,45.04,0,62.23v0c-17.18,17.18-45.04,17.18-62.23,0l-42.36-42.36 l-42.36,42.36c-17.18,17.18-45.04,17.18-62.23,0v0c-17.18-17.18-17.18-45.04,0-62.23L201.01,256l-42.36-42.36 c-17.18-17.18-17.18-45.04,0-62.23v0c17.18-17.18,45.04-17.18,62.23,0l42.36,42.36l42.36-42.36c17.18-17.18,45.04-17.18,62.23,0v0 c17.18,17.18,17.18,45.04,0,62.23L325.46,256L367.83,298.36z"></path> </g> </g> </g></svg>
                            <i  data-demande-num="${credit.number}" class="fa-solid fa-square-check text-3xl valider" style="color: #59ff00;"></i>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $('#search_date').on('change', function() {
            var selectedDate = $('#search_date').val();
            window.location.href = "/credit-display-date?date=" + selectedDate;
        });


        $(".refuser").on('click', function () {
            var demandeNum = $(this).data("demande-num");
            var newStatus = "refuse";

            $.ajax({
                url: "/change-status-demande",
                type: "POST",
                data: {
                    demandeNum: demandeNum,
                    newStatus: newStatus
                },
                success: function (data) {
                    window.location.href = "/credit-display";
                },
                error: function (error) {
                    console.log("3yaaan");
                }
            });
        });

        $(".valider").on('click', function () {
            var demandeNum = $(this).data("demande-num");
            var newStatus = "accepte";

            $.ajax({
                url: "/change-status-demande",
                type: "POST",
                data: {
                    demandeNum: demandeNum,
                    newStatus: newStatus
                },
                success: function (data) {
                    window.location.href = "/credit-display";
                },
                error: function (error) {
                    console.log("3yaaan");
                }
            });
        });
    </script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>

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
                Dure(months)
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
                <td class="px-6 py-4">
                    <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">change status</a>
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
    </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>

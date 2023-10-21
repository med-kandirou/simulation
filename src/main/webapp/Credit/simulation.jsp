<%@ page import="DTO.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
<head>
    <title>Simulation</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css"  rel="stylesheet" />
    <jsp:include page="../Component/header.jsp" />
</head>
<body>


<div class="mb-4 border-b border-gray-200 dark:border-gray-700">
    <ul class="flex flex-wrap -mb-px text-sm font-medium text-center">
        <li class="mr-2" >
            <button class="inline-block p-4 border-b-2 rounded-t-lg" id="simulate_tab">Simulate my credit</button>
        </li>
        <li class="mr-2">
            <button class="inline-block p-4 border-b-2 border-transparent rounded-t-lg hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="search_tab" >Search</button>
        </li>
        <li class="mr-2">
            <button class="inline-block p-4 border-b-2 border-transparent rounded-t-lg hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="info_tab" >My personal information</button>
        </li>
    </ul>
</div>
<div id="myTabContent">
    <div class="p-4 rounded-lg bg-gray-50 dark:bg-gray-800" id="simulate">
        <form>
            <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">My project</label>
            <select class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option selected>Choose</option>
            </select>
            <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">I am </label>
            <select  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option selected>Choose</option>
            </select>
            <div class="mb-6">
                <label for="montant" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Montant (en DH)</label>
                <input type="range" min="5000" value="10000" max="600000" id="montant" oninput="this.nextElementSibling.value = this.value" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@flowbite.com" >
                <output>10000</output>
            </div>
            <div class="mb-6">
                <label for="dure" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Durée (en mois)</label>
                <input type="range" min="12" value="20" max="120" oninput="this.nextElementSibling.value = this.value" id="dure" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <output>20</output>
            </div>
            <div class="mb-6">
                <label for="mensualite" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Mensualités (en DH)</label>
                <input hidden type="number" id="mensualite" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
            </div>
            <button type="button" onclick="calcule()" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 ">Calculate</button>
            <button type="button" id="confirmPrix" onclick="confirmprix()" class="d-none text-blue bg-white-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 ">Confirm</button>
        </form>
    </div>
    <div class="hidden p-4 rounded-lg bg-gray-50 dark:bg-gray-800" id="search" >
        <div class="mb-6">
            <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Search client :</label>
           <input type="text" id="find"  name="find" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="search by attributs">
        </div>
        <button id="searchButton" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Search</button>
    </div>
    <div class="hidden p-4 rounded-lg bg-gray-50 dark:bg-gray-800" id="info">
        <form>
            <div hidden="hidden" class="relative z-0 w-full mb-6 group">
                <label for="code" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Code</label>
                <input type="text" name="code" value="testcode" id="code" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" >
            </div>
            <div class="relative z-0 w-full mb-6 group">
                <label for="fname" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Last Name</label>
                <input type="text" disabled name="fname" id="fname" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
            </div>
            <div class="relative z-0 w-full mb-6 group">
                <label for="lname" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Last Name</label>
                <input type="text" disabled name="lname" id="lname" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@flowbite.com" >
            </div>
            <div class="relative z-0 w-full mb-6 group">
                <label for="fname" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Birthday </label>
                <input type="date" disabled name="bday" id="birthday" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@flowbite.com" >
            </div>
            <div class="relative z-0 w-full mb-6 group">
                <label for="fname" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Phone</label>
                <input type="text" disabled name="phone" id="phone" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@flowbite.com" >
            </div>
            <div class="relative z-0 w-full mb-6 group">
                <label for="adresse" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Adresse</label>
                <input type="text" disabled name="adresse" id="adresse" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
            </div>
            <div class="relative z-0 w-full mb-6 group">
                <label for="remarks" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Remarks</label>
                <textarea type="text" name="remarks" id="remarks" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"></textarea>
            </div>
            <button type="button" id="confimDemande" class="bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 text-white font-medium rounded-lg text-sm px-5 py-2.5 w-full sm:w-auto text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                Confirm
            </button>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../script/simulation.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="model.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dealership Home</title>
</head>
<body>

sem vlozit tabulku udajov vs. aut a ich majitelov


<table id = "data">
    <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Plate number</th>
        <th>YOM</th>
        <th>Mileage</th>
        <th>Price</th>
    </tr>


<c:forEach items="${carList}" var="car">


    <tr>
        <td><c:out value="hodnota : ${car.id}"/></td>
        <td>${car.brand}</td>
        <td>${car.plate_num}</td>
        <td>${car.year_of_manufacture}</td>
        <td>${car.mileage}</td>
        <td>${car.price}</td>
    </tr>

</c:forEach>





</table>

</body>
</html>

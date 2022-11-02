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



<table id = "data">
    <tr>
        <th>Customer Name</th>
        <th>Customer Surname</th>
        <th>Customer Address</th>
        <th>Purchase Date</th>
        <th>Return Date</th>
        <th>Car Brand</th>
        <th>Plate number</th>
        <th>YOM</th>
        <th>Mileage</th>
        <th>Price</th>
    </tr>


<c:forEach items="${carOwnerList}" var="carOwner">
    <tr>
        <td>${carOwner.customer.first_name}</td>
        <td>${carOwner.customer.last_name}</td>
        <td>${carOwner.customer.address}</td>
        <td>${carOwner.purchase_date}</td>
        <td>${carOwner.return_date}</td>
        <td>${carOwner.car.brand}</td>
        <td>${carOwner.car.plate_num}</td>
        <td>${carOwner.car.year_of_manufacture}</td>
        <td>${carOwner.car.mileage}</td>
        <td>${carOwner.car.price}</td>
        <td>
            <form action="update">
                <input type="hidden" name="type" value="carOwnerUpdate">
                <input type="hidden" name="ID" value="${carOwner.id}">
                <input type="submit" value="UPDATE">
            </form>
        </td>
        <td>
            <form action="delete">
                <input type="hidden" name="type" value="carOwner">
                <input type="hidden" name="ID" value="${carOwner.id}">
                <input type="submit" id="del-btn" value="DELETE" onclick="if(!(confirm('Are you sure about deleting sale of car ${carOwner.car.brand} sold to ${carOwner.customer.last_name} ?'))) return false">

            </form>
        </td>
    </tr>
</c:forEach>


</table>

<form action="cars">
    <input type="submit" value="SHOW CARS">
</form>

<form action="customers">
    <input type="submit" value="SHOW CUSTOMERS">
</form>

<form action="update">
    <input type="hidden" name="type" value="carOwnerAdd">
    <input type="hidden" name="ID" value="">
    <input type="submit" value="ADD SOLD CAR">
</form>


</body>
</html>

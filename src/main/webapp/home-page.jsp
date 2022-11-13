<%@ page import="java.util.List" %>
<%@ page import="model.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Dealership Home</title>
</head>
<body>


<div class="container-lg mt-3">
<table id = "data" class="table table-primary table-hover">
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
        <th></th><th></th>
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
                <input type="submit" value="UPDATE" class="btn btn-warning">
            </form>
        </td>
        <td>
            <form action="delete">
                <input type="hidden" name="type" value="carOwner">
                <input type="hidden" name="ID" value="${carOwner.id}">
                <input type="submit" id="del-btn" value="DELETE" class="btn btn-danger" onclick="if(!(confirm('Are you sure about deleting sale of car ${carOwner.car.brand} sold to ${carOwner.customer.last_name} ?'))) return false">

            </form>
        </td>
    </tr>
</c:forEach>


</table>

    <div class="d-flex justify-content-center align-items-center">
    <form action="cars">
    <input type="submit" value="SHOW CARS" class="btn btn-primary btn-lg btn-block">
    </form>
    </div>

    <div class="d-flex justify-content-center align-items-center">
    <form action="customers">
    <input type="submit" value="SHOW CUSTOMERS" class="btn btn-primary btn-lg btn-block">
    </form>
    </div>

    <div class="d-flex justify-content-center align-items-center">
    <form action="update">
    <input type="hidden" name="type" value="carOwnerAdd">
    <input type="hidden" name="ID" value="">
    <input type="submit" value="ADD SOLD CAR" class="btn btn-primary btn-lg btn-block">
    </form>
    </div>
</div>


</body>
</html>

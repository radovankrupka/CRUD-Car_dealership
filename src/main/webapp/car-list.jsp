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
        <th>Car Brand</th>
        <th>Model</th>
        <th>Plate Number</th>
        <th>Year Of Manufacture</th>
        <th>Mileage</th>
        <th>Crashed</th>
        <th>Price</th>
    </tr>


<c:forEach items="${carBrandList}" var="carBrand">
    <tr>
        <td>${carBrand.brand.brand_name}</td>
        <td>${carBrand.brand.model}</td>
        <td>${carBrand.car.plate_num}</td>
        <td>${carBrand.car.year_of_manufacture}</td>
        <td>${carBrand.car.mileage}</td>
        <td>${carBrand.car.crashed}</td>
        <td>${carBrand.car.price}</td>
        <td><a href="update?type=car?${carBrand.car.id}"> Update </a> </td>
        <td><a href="deleteCar?carID=${carBrand.car.id}" onclick="if(!(confirm('Are you sure about deleting car ${carBrand.brand.brand_name} ${carBrand.brand.model} ?'))) return false"> Delete </a> </td>
    </tr>

</c:forEach>

</table>

<form action="add">
    <input type="submit" value="ADD CAR">
</form>

<form action="brands">
    <input type="submit" value="SHOW BRANDS">
</form>


</body>
</html>

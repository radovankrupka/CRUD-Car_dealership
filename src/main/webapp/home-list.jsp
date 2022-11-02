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


<c:forEach items="${carOwnerList}" var="carOwner">
    <tr>
        <td>${carBrand.brand.brand_name}</td>
        <td>${carBrand.brand.model}</td>
        <td>${carBrand.car.plate_num}</td>
        <td>${carBrand.car.year_of_manufacture}</td>
        <td>${carBrand.car.mileage}</td>
        <td>${carBrand.car.crashed}</td>
        <td>${carBrand.car.price}</td>
        <td><form action="update">
            <input type="hidden" name="type" value="car">
            <input type="hidden" name="ID" value="${carBrand.car.car_id}">
            <input type="submit" value="UPDATE">
           </form>
        </td>
        <td><form action="update">
            <input type="hidden" name="type" value="car">
            <input type="hidden" name="ID" value="${carBrand.car.car_id}">
            <input type="submit" value="DELETE" onclick="if(!(confirm('Are you sure about deleting car ${carBrand.brand.brand_name} ${carBrand.brand.model} ?'))) return false">
            </form>
        </td>
    </tr>

</c:forEach>

</table>

<form action="update">
    <input type="hidden" name="type" value="car">
    <input type="submit" value="ADD CAR">
</form>

<form action="brands">
    <input type="submit" value="SHOW BRANDS">
</form>


</body>
</html>

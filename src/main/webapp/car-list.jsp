<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>


<table id = "cars">
  <tr>
    <th>Car Brand</th>
    <th>Plate number</th>
    <th>Year of Manufacture</th>
    <th>Mileage</th>
    <th>Price</th>
  </tr>


  <c:forEach items="${carList}" var="car">
    <tr>
      <td>${car.brand}</td>
      <td>${car.plate_num}</td>
      <td>${car.year_of_manufacture}</td>
      <td>${car.mileage}</td>
      <td>${car.price}</td>
    </tr>
  </c:forEach>

</table>

<form action="home">
  <input type="submit" value="SHOW HOMEPAGE">
</form>

<form action="customers">
  <input type="submit" value="SHOW CUSTOMERS">
</form>

</body>
</html>

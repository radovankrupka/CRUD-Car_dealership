<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  <title>Cars</title>
</head>
<body>

<div class="container-lg mt-3">
<table id = "cars" class="table table-primary table-hover">
  <tr>
    <th>Car Brand</th>
    <th>Plate number</th>
    <th>Year of Manufacture</th>
    <th>Mileage</th>
    <th>Price</th>
    <th></th><th></th>
  </tr>


  <c:forEach items="${carList}" var="car">

    <tr>
      <td>${car.brand}</td>
      <td>${car.plate_num}</td>
      <td>${car.year_of_manufacture}</td>
      <td>${car.mileage}</td>
      <td>${car.price}</td>
      <td>

      <form action="update">
        <input type="hidden" name="type" value="carUpdate">
        <input type="hidden" name="ID" value="${car.id}">
        <input type="submit" value="UPDATE" class="btn btn-warning">
      </form>
      </td>
      <td>
      <form action="delete">
        <input type="hidden" name="type" value="car">
        <input type="hidden" name="ID" value="${car.id}">
        <input type="submit" id="del-btn" class="btn btn-danger" value="DELETE" onclick="if(!(confirm('Are you sure about deleting car ${car.brand} ${car.plate_num} ?'))) return false">

      </form>
      </td>
    </tr>
  </c:forEach>

</table>

<p style="color: red"> ${carError}</p>

<div class="d-flex justify-content-center align-items-center">

<form action="update">
  <input type="hidden" name="type" value="carAdd">
  <input type="hidden" name="ID" value="">
  <input type="submit" value="ADD CAR" class="btn btn-primary btn-lg btn-block">
</form>
</div>

  <div class="d-flex justify-content-center align-items-center">

  <form action="home">
  <input type="submit" value="SHOW HOMEPAGE" class="btn btn-primary btn-lg btn-block">
</form>
  </div>

    <div class="d-flex justify-content-center align-items-center">

    <form action="customers">
  <input type="submit" value="SHOW CUSTOMERS" class="btn btn-primary btn-lg btn-block">
</form>
    </div>

</div>

</body>
</html>

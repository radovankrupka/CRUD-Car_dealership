<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <title>Customers</title>
</head>
<body>

<div class="container-lg mt-3">
<table id = "customers" class="table table-primary table-hover">
  <tr>
    <th>Customer Name</th>
    <th>Customer Surname</th>
    <th>Customer Address</th>
    <th></th><th></th>

  </tr>


  <c:forEach items="${customerList}" var="customer">
    <tr>
      <td>${customer.first_name}</td>
      <td>${customer.last_name}</td>
      <td>${customer.address}</td>
      <td>
        <form action="update">
        <input type="hidden" name="type" value="customerUpdate">
        <input type="hidden" name="ID" value="${customer.id}">
        <input type="submit" value="UPDATE" class="btn btn-warning">
      </form>
      </td>
      <td>
        <form action="delete">
          <input type="hidden" name="type" value="customer">
          <input type="hidden" name="ID" value="${customer.id}">
          <input type="submit" id="del-btn" value="DELETE" class="btn btn-danger" onclick="if(!(confirm('Are you sure about deleting customer ${customer.first_name} ${customer.last_name} ?'))) return false">
        </form>
      </td>
    </tr>
  </c:forEach>


</table>

<p style="color: red"> ${customerError}</p>

  <div class="d-flex justify-content-center align-items-center">

<form action="update">
  <input type="hidden" name="type" value="customerAdd">
  <input type="hidden" name="ID" value="">
  <input type="submit" value="ADD CUSTOMER" class="btn btn-primary btn-lg btn-block">
</form>
  </div>

    <div class="d-flex justify-content-center align-items-center">

    <form action="home">
  <input type="submit" value="SHOW HOMEPAGE" class="btn btn-primary btn-lg btn-block">
</form>
    </div>

      <div class="d-flex justify-content-center align-items-center">

      <form action="cars">
  <input type="submit" value="SHOW CARS" class="btn btn-primary btn-lg btn-block">
</form>
      </div>


</div>
</body>
</html>

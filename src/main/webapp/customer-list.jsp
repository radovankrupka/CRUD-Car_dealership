<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customers</title>
</head>
<body>


<table id = "customers">
  <tr>
    <th>Customer Name</th>
    <th>Customer Surname</th>
    <th>Customer Address</th>
  </tr>


  <c:forEach items="${customerList}" var="customer">
    <tr>
      <td>${customer.first_name}</td>
      <td>${customer.last_name}</td>
      <td>${customer.address}</td>
    </tr>
  </c:forEach>


</table>

<form action="home">
  <input type="submit" value="SHOW HOMEPAGE">
</form>

<form action="cars">
  <input type="submit" value="SHOW CARS">
</form>


</body>
</html>

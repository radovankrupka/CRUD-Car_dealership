
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brands</title>
</head>
<body>

<table id = "brands-data">
  <tr>
    <th>Car Brand</th>
    <th>Model</th>
  </tr>


  <c:forEach items="${brandList}" var="brand">
    <tr>
      <td>${brand.brand_name}</td>
      <td>${brand.model}</td>
      <td><a href="update?carID=${brand.brand_id}"> Update </a> </td>
      <td><a href="delete?carID=${brand.brand_id}" onclick="if(!(confirm('Are you sure about deleting brand ${brand.brand_name} ${brand.model} ?'))) return false"> Delete </a> </td>
    </tr>

  </c:forEach>

</table>


<form action="addBrand">
  <input type="submit" value="ADD BRAND">
</form>

<form action="cars">
  <input type="submit" value="SHOW CARS">
</form>

</body>
</html>

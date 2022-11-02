
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
      <td><form action="update">
          <input type="hidden" name="type" value="brand">
          <input type="hidden" name="ID" value="${brand.brand_id}">
          <input type="submit" value="UPDATE">
          </form>
      </td>
      <td><form action="delete">
          <input type="hidden" name="type" value="brand">
          <input type="hidden" name="ID" value="${brand.brand_id}">
          <input type="submit" value="DELETE" onclick="if(!(confirm('Are you sure about deleting brand AND cars of type ${brand.brand_name} ${brand.model} ?'))) return false">
          </form>
      </td>
    </tr>

  </c:forEach>

</table>


<form action="add">
  <input type="submit" value="ADD BRAND">
</form>

<form action="cars">
  <input type="submit" value="SHOW CARS">
</form>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Radko
  Date: 31 Oct 2022
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Cars</title>
</head>
<body>

<form name="cars-form" method="get" action="save">
    <input type="hidden" name="car_id" value="${carBrand.car.car_id}">
    Car Brand                   <select name="brand" >
                                    <c:forEach var="brand" items="${brands}">
                                        <c:if test="${brand.model ne carBrand.brand.model}">
                                        <option value="${brand.brand_id}"> ${brand.brand_name} ${brand.model}</option>
                                        </c:if>
                                        </c:forEach>
                                    <option selected value="${carBrand.brand.brand_id}">${carBrand.brand.brand_name} ${carBrand.brand.model}</option>

                                </select> <br>

    Plate Number                <input type="text" name="plate_num" value="${carBrand.car.plate_num}"> <br>
    Year Of Manufacture         <input type="number" name="year_of_manufacture" value="${carBrand.car.year_of_manufacture}"><br>
    Mileage                     <input type="number" name="mileage" value="${carBrand.car.mileage}"><br>
    Crashed                     <input type="checkbox" checked name="crashed" value="${carBrand.car.crashed}"><br>
    Price                       <input type="number" name="price" value="${carBrand.car.price}">    <br>

    <input type="submit" value="SUBMIT">

</form>




</body>
</html>

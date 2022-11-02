<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Update Cars</title>
</head>
<body>

<form name="car-form" method="get" action="save">
    <input type="hidden" name="id" value="${car.id}">
    <%--Car Brand                   <select name="brands_id" >
                                    <c:forEach var="brand" items="${brands}">
                                        <c:if test="${brand.model ne carBrand.brand.model}">
                                        <option value="${brand.brand_id}"> ${brand.brand_name} ${brand.model}</option>
                                        </c:if>
                                        </c:forEach>
                                    <option selected value="${carBrand.brand.brand_id}">${carBrand.brand.brand_name} ${carBrand.brand.model}</option>

                                </select> <br>
--%>
    Car Brand                   <input type="text" name="brand" value="${car.brand}"> <br>
    Plate Number                <input type="text" name="plate_num" value="${car.plate_num}"> <br>
    Year Of Manufacture         <input type="number" name="year_of_manufacture" value="${car.year_of_manufacture}"><br>
    Mileage                     <input type="number" name="mileage" value="${car.mileage}"><br>
    Price                       <input type="number" name="price" value="${car.price}">    <br>

    <input type="submit" value="SUBMIT">

</form>




</body>
</html>

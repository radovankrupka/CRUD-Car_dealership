<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Car Owner Form</title>
</head>
<body>

<form name="carowner-form" method="get" action="save">
    <input type="hidden" name="type" value="carOwner">
    <input type="hidden" name="id" value="${carOwner.id}">

    Customer            <select name="customers_id" >
                            <c:forEach var="customer" items="${customerList}">
                                <c:if test="${carOwner.customer.id ne customer.id}">
                                    <option value="${customer.id}"> ${customer.first_name} ${customer.last_name}</option>
                                </c:if>
                            </c:forEach>
                            <option selected value="${carOwner.customer.id}">${carOwner.customer.first_name} ${carOwner.customer.last_name}</option>
                        </select> <br>
    carowner-customer-first name : ${carOwner.customer.first_name} ${carOwner.id} <br>

    Car                 <select name="cars_id" >
                            <c:forEach var="car" items="${carList}">
                                <c:if test="${carOwner.car.id ne car.id}">
                                    <option value="${car.id}"> ${car.brand} ${car.plate_num}</option>
                                </c:if>
                            </c:forEach>
                            <option selected value="${carOwner.car.id}">${carOwner.car.brand} ${carOwner.car.plate_num}</option>
                        </select> <br>

    Purchase Date(RRRR-MM-DD)             <input required type="date" name="purchase_date" value="${carOwner.purchase_date}"> <br>
    Return Date(RRRR-MM-DD)               <input type="date" name="return_date" value="${carOwner.return_date}"> <br>

    <input type="submit" value="SUBMIT">

</form>

<%--Car Brand                   <select name="brands_id" >
                                    <c:forEach var="brand" items="${brands}">
                                        <c:if test="${brand.model ne carBrand.brand.model}">
                                        <option value="${brand.brand_id}"> ${brand.brand_name} ${brand.model}</option>
                                        </c:if>
                                        </c:forEach>
                                    <option selected value="${carBrand.brand.brand_id}">${carBrand.brand.brand_name} ${carBrand.brand.model}</option>

                                </select> <br>
--%>

</body>
</html>

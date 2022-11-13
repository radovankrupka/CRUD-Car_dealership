<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Car Owner Form</title>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-4">
            <h2> Form for adding sale of a car </h2>

<form name="carowner-form" method="get" action="save"  >
    <input type="hidden" name="type" value="carOwner">
    <input type="hidden" name="id" value="${carOwner.id}">

    <label for="customers_id"> Customer: </label>
                <select name="customers_id"  class="form-select" >
                            <c:forEach var="customer" items="${customerList}">
                                <c:if test="${carOwner.customer.id ne customer.id}">
                                    <option value="${customer.id}"> ${customer.first_name} ${customer.last_name}</option>
                                </c:if>
                            </c:forEach>
                            <option selected value="${carOwner.customer.id}">${carOwner.customer.first_name} ${carOwner.customer.last_name}</option>
                        </select> <br>


    <label for="cars_id"> Car: </label>
                    <select name="cars_id" class="form-select">
                            <c:forEach var="car" items="${carList}">
                                <c:if test="${carOwner.car.id ne car.id}">
                                    <option value="${car.id}"> ${car.brand} ${car.plate_num}</option>
                                </c:if>
                            </c:forEach>
                            <option selected value="${carOwner.car.id}">${carOwner.car.brand} ${carOwner.car.plate_num}</option>
                        </select> <br>


    <label for="purchase_date">   Purchase Date(RRRR-MM-DD): </label>
             <input required type="date" name="purchase_date" value="${carOwner.purchase_date}"> <br>

    <label for="return_date">   Return Date(RRRR-MM-DD)   :</label>
    <input type="date" name="return_date" value="${carOwner.return_date}"> <br>


    <input type="submit" value="SUBMIT" class="btn btn-primary btn-lg btn-block ">

</form>
        </div>
    </div>
</div>


</body>
</html>

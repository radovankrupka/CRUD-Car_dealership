<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Update Cars</title>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-4">
            <h2> Form for adding a car </h2>
<form name="car-form" method="get" action="save">
    <input type="hidden" name="id" value="${car.id}">
    <input type="hidden" name="type" value="car">

    <label for="brand" > Car Brand</label>
                   <input type="text" name="brand" value="${car.brand}" placeholder="Toyota,..."> <br>
    Plate Number                <input type="text" name="plate_num" value="${car.plate_num}" placeholder="NR234FF,..."> <br>
    Year Of Manufacture         <input type="number" name="year_of_manufacture" value="${car.year_of_manufacture}"><br>
    Mileage                     <input type="number" name="mileage" value="${car.mileage}"><br>
    Price                       <input type="number" name="price" value="${car.price}">  EUR  <br>
    <br> <br>
    <input type="submit" value="SUBMIT" class="btn btn-primary btn-lg btn-block ">

</form>


</div>
    </div>
</div>


</body>
</html>

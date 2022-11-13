<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Brand Form</title>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-4">
            <h2> Form for adding a customer </h2>
<form name="customer-form" method="get" action="save">
    <input type="hidden" name="type" value="customer">
    <input type="hidden" name="id" value="${customer.id}">
    Customer First Name            <input type="text" name="first_name" value="${customer.first_name}"> <br>
    Customer Last Name             <input type="text" name="last_name" value="${customer.last_name}"> <br>
    Customer Address               <input type="text" name="address" value="${customer.address}"> <br>

    <input type="submit" value="SUBMIT"  class="btn btn-primary btn-lg btn-block ">

</form>
        </div>
    </div>
</div>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brand Form</title>
</head>
<body>

<form name="customer-form" method="get" action="save">
    <input type="hidden" name="type" value="customer">
    <input type="hidden" name="id" value="${customer.id}">
    Customer First Name            <input type="text" name="first_name" value="${customer.first_name}"> <br>
    Customer Last Name             <input type="text" name="last_name" value="${customer.last_name}"> <br>
    Customer Address               <input type="text" name="address" value="${customer.address}"> <br>

    <input type="submit" value="SUBMIT">

</form>

</body>
</html>

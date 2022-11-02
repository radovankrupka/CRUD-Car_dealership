<%--
  Created by IntelliJ IDEA.
  User: Radko
  Date: 1 Nov 2022
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brand Form</title>
</head>
<body>

<form name="brand-form" method="get" action="save">
                    <input type="hidden" name="brand_id" value="${brand.brand_id}">
  Brand Name        <input type="text" name="brand_name" value="${brand.brand_name}">
  Model             <input type="text" name="model" value="${brand.model}">

    <input type="submit" value="SUBMIT">

</form>

</body>
</html>

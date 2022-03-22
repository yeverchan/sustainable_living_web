<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product.name}</title>
</head>
<body>
<div>
    <h3 name="product_name">${product.name}</h3>
    <h3 name="product_price">${product.price}</h3>
    <h3 name="product_created">${product.created_At}</h3>
</div>
<div>
    <h3 name="product_description">${product.description}</h3>
</div>
</body>
</html>

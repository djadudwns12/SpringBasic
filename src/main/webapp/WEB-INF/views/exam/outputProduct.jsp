<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>outputProduct.jsp</title>
</head>
<body>


	<h1>outputProduct.jsp</h1>

	<div>제품번호 : ${product.productNo}</div>
	<div>제품이름 : ${product.productName}</div>
	<div>제품수량 : ${product.qty}</div>
	<div>제품가격 : ${product.price}</div>
	<div>제품별칭 : ${product.productNickName}</div>

</body>
</html>
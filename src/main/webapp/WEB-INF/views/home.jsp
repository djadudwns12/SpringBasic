<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
	// 쿼리스트링에  status라는 변수의 값이 "success"일때만 alert를 띄워야한다.
	let status = '${param.status}';
	
	if(status == 'success')
	{		
		window.alert("product success");
	}
	
	
	
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  상태는 :  ${status}. </P>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/authentication" method="post">
		<h3>
		Authentication
		</h3>
		<input type="text" placeholder="Verify Number" name="code"/>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
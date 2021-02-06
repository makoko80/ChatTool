<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会話アプリ（仮）</title>
<style>
body{
text-align:center;
}
</style>
</head>
<body>

	<p>ようこそ<c:out value="${loginUser.name }"/>さん！</p>
	<a href="/chatTool/LoginServlet?action=loginSuccess">さあ会話を楽しもう！</a>

</body>
</html>
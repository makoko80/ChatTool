<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会話アプリ</title>
<style>
body{
	background-color: silver;
}
.Mutter{
	border-bottom:solid 1px;
}
form{
	border-bottom: solid 2px;
	padding:5px;
}
.reply{
text-align:right;
}
</style>
</head>
<body>
	<h1>会話Botくん(仮)</h1>
	<p><c:out value="${loginUser.name }"/>さんログイン中
	</p>
	<a href="/chatTool/LogoutServlet">ログアウト</a>
	<form action="/chatTool/MainServlet" method="post">
		<input type="text" name="text">
		<input type="submit" value="つぶやく">
	</form>
	<c:if test="${not empty errorMsg }">
	<p>${errorMsg }</p>
	</c:if>

	<c:forEach var="mutter" items="${saidMutterList }">
	<div class="Mutter">
		<c:out value="${mutter.dateNow}"/>
		<p><c:out value="${loginUser.name }"/>:
		<c:out value="${mutter.text }"/>
		</p>
		<p class="reply">チャットBotくん「<c:out value="${mutter.reply} "/>」</p>
	</div>
	</c:forEach>



</body>
</html>
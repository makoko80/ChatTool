<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会話アプリ（仮）ユーザー登録</title>
<style>
body{
text-align:center;
}
div{
margin:100px;
}
</style>
</head>
<body>
<div>
<p>こちらの内容で登録してよろしいですか？</p>

<p>名前：<c:out value="${legisterUser.name }"/></p>

<p>パスワード：<c:out value="${legisterUser.pass }"/></p>

<a href="/chatTool/LegisterServlet?action=back">戻る</a>
<a href="/chatTool/LegisterServlet?action=legister">登録する</a>
</div>
</body>
</html>
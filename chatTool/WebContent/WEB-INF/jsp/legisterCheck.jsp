<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会話アプリ（仮）ユーザー登録</title>
</head>
<body>

<p>こちらの内容で登録してよろしいですか？</p>
<dl>
<dt>名前：</dt><dd><c:out value="${legisterUser.name }"/></dd>
</dl>
<dl>
<dt>パスワード：</dt><dd><c:out value="${legisterUser.pass }"/></dd>
</dl>
<a href="/chatTool/LegisterServlet?action=back">戻る</a>
<a href="/chatTool/LegisterServlet?action=legister">登録する</a>
</body>
</html>
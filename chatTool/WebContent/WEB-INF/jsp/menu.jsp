<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会話アプリ（仮）</title>
<style>
body {
	width: 100%;
	text-align: center;
}
.menu{
width: 40%;
	height: 100px;
	margin: 100px auto;
	padding: 50px; text-align : center;
	border-radius: 20px 20px 20px 20px;
	background-color: aqua;
	margin: 100px auto;
	text-align: center;

}
</style>
</head>
<body>

	<h1>会話アプリ（仮）</h1>
	<div class="menu">
	<p>メニュー</p>
	<p>
		<a href="/chatTool/LoginServlet">ログイン</a>
	</p>
	<p>
		<a href="/chatTool/LegisterServlet">ユーザー登録</a>
	</p>
	</div>
</body>
</html>
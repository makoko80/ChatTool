<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会話アプリ（仮）</title>

<style>
div{
width: 40%;
	height: 50px;
	margin: 50px auto;
	padding: 50px; text-align : center;
	border-radius: 20px 20px 20px 20px;
	text-align: center;

}
form{
  background-color: aqua;
  padding:30px 50px;
  border-radius: 20px 20px 20px 20px;
}

form dl dt{
  width: 165px;
  padding:10px 20px;
  float:left;
  clear:both;
}

form dl dd{
  padding:10px 0;
}
span{
  color:red;
}
a{
  margin: 0 10px;
}


</style>
</head>
<body>
<div>
<h3>ログイン</h3>
<form action="/chatTool/LoginServlet" method="post">
<dl>
<dt>名前：</dt><dd><input type="text" name="name"></dd>
</dl>
<dl>
<dt>パスワード：</dt><dd><input type="text" name="pass"></dd>
</dl>
<a href="/chatTool/MenuServlet">戻る</a>
<input type="submit" value="ログイン">
	<span><c:if test="${not empty errorMsg }">
	<p>${errorMsg }</p>
	</c:if></span>
</form>
</div>
</body>
</html>
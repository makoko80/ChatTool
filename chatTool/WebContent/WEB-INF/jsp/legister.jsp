<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会話アプリ（仮）ユーザー登録</title>
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
  background-color: #CCCCFF;
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
<h3>ユーザー登録</h3>
<form action="/chatTool/LegisterServlet" method="post">
<dl>
<dt>名前：</dt><dd><input type="text" name="name" placeholder="任意の文字列"
	value="<c:out value='${legisterUser.name }'/>"></dd>
</dl>
<dl>
<dt>パスワード：</dt><dd><input type="text" name="pass" placeholder="半角英数字"
	value="<c:out value='${legisterUser.pass }'/>"></dd>
</dl>
<a href="/chatTool/MenuServlet">戻る</a>
<input type="submit" value="確認する">
	<span><c:if test="${not empty errorMsg }">
	<p>${errorMsg }</p>
	</c:if></span>
</form>
</div>

</body>
</html>
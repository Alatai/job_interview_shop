<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<h3>hello</h3>

<a href="account/findAll">findAll</a><br>

<form action="account/insert" method="post">
    <div><label for="uid">uid：<input id="uid" name="uid" type="text"></label></div>
    <div><label for="money">money：<input id="money" name="money" type="text"></label></div>
    <div><input type="submit" value="提交"></div>
</form>

</body>
</html>

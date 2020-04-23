<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/23
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/testMethod" method="post">
    <input type="submit" value="submit"/>
</form>
<br>
<a href="/testParamerANdHanders?username=qingqiang&age=11">Test testParamerANdHanders</a>
<br>
<a href="helloworld">helloworld</a>
<br><br>
<a href="testPathVariable/101">testPathVariable</a>
<a href="/testRequestParam?username=qiangqiang&age=10">testPathVariable</a>

<br>
<br>
<br>
<br>
<<a href="/testServletAPI">testServletAPI</a>

<br>
<br>
<a href="testMap">testMap</a>
<br>
<br>
<form action="testFileUpload" method="post" enctype="multipart/form-data">
    file:<input type="file" name="file"/>
    Desc:<input type="text" name="desc"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>

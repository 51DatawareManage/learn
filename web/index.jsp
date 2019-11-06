<%@ page contentType="text/html; charset=gbk"%>

<html>
<head>
    <title>login</title>
</head>
<body>
<!-- <p1>test!</p1> -->
<h2 align="center">»¶Ó­µÇÂ¼</h2>
<form name=loginForm action="http://127.0.0.1:8088/learn/test" method=post>
    <table align="center">
        <tr>
            <td>ÓÃ»§Ãû£º</td><td><input type=text name=username /></td>
        </tr>
        <tr>
            <td>ÃÜÂë£º</td><td><input type=password name=pwd /></td>
        <tr/>
        <tr>
            <td colspan="2",align="center">
                <input type="submit" value="submit" />
                <input type="reset" value="reset" />
            </td>
        </tr>
    </table>

</form>
<h1>${request.getParameter("username")} </h1>
</body>
</html>
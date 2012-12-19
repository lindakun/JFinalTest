<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/hello/save" method="post">
		<fieldset class="solid">
			<legend>添加用户</legend>
			
			<div>
				<label>用户名：</label> <input type="text" name="user.username"
					value="${user.username}" />${unMsg}
			</div>
			<div>
				<label>密码：</label> <input type="text" name="user.password"
					value="${user.password}" />${upMsg}
			</div>
			<div>
				<label>&nbsp;</label> <input value="提交" type="submit">
			</div>
		</fieldset>
	</form>
</body>
</html>
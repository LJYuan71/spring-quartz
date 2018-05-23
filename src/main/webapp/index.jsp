<%@page pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>首页</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/quartz/listJob.do">方式1</a><br />
	<a href="${pageContext.request.contextPath }/task/taskList.do">方式2</a>
</body>
</html>

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>百度网盘搜索</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="百度网盘搜索|网盘搜索|百度云搜索" />
<meta name="description" content="百度网盘搜索，搜索百度网盘资源" />
<style>
.vertical-center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<div class="vertical-center">
		<form action="search" method="post">
			<input type="text" name="keyword" /> <input type="hidden"
				name="searchType" value="BING" /> <input type="submit"
				value="百度网盘搜索" />
		</form>
	</div>
</body>
</html>

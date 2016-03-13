<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<body>
<body>
	<form action="search" method="post">
		<input type="text" name="keyword" value="${keyword }" /> <input
			type="hidden" name="searchType" value="BING" /> <input type="submit"
			value="查询" />
	</form>
	<hr />
	<c:if test="${result.totalPage <= 0 }" var="noResult">没有查询到结果,请重试.....</c:if>
	<c:if test="${!noResult }">
		<c:forEach items="${result.results }" var="data">
			<p>
				<a href="${data.url }">${data.title }</a>
			</p>
			<p>${data.desc}</p>
			<br />
		</c:forEach>
		<c:if test="${currentPage - 1 > 0 }" var="prefix">
			<a
				href="search?keyword=${keyword }&searchType=BING&currentPage=${currentPage - 1}">上一页</a>
		</c:if>


		<c:forEach begin="${result.startPage }" end="${result.endPage }"
			var="num">
			<a
				href="search?keyword=${keyword }&searchType=BING&currentPage=${num }">${num }</a>
		</c:forEach>
	当前页:<a
			href="search?keyword=${keyword }&searchType=BING&currentPage=${currentPage }">${currentPage }</a>
		<c:if test="${currentPage < result.totalPage }">
			<a
				href="search?keyword=${keyword }&searchType=BING&currentPage=${currentPage + 1}">下一页</a>
		</c:if>

	</c:if>
</body>
</html>

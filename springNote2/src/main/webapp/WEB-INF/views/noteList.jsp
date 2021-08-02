<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note List 2</title>
</head>
<body>
<h3>Note List 2</h3><br>

<table width="500" border="1">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>내용</th>
		<th>삭제</th>
	</tr>
	<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.writer}</td>
			<td>${dto.content}</td>
			<td><a href="delete?id=${dto.id}">삭제</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4">작성</td>
	</tr>
</table>

</body>
</html>
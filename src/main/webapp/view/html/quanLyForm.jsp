<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>STT</th>
				<th>Tiêu đề</th>
				<th>Nội dung</th>
				<th>Liên kết</th>
				<th>Danh mục</th>
				<th>Chức năng</th>
			</tr>
				<c:forEach var="tintuc" items="${tinTucList}" varStatus="index">
			<tr>
					<td>${index.count}</td>
					<td>${tintuc.tieuDe}</td>
					<td>${tintuc.noiDungTinTuc}</td>
					<td>${tintuc.lienKet}</td>
					<td>${tintuc.maDanhMuc}</td>
					<td><a
						href="${pageContext.request.contextPath}/QuanLyFormServlet?action=delete&id=${tintuc.maTinTuc}">Delete</a></td>
			</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 80%;
	border-collapse: collapse;
	margin: 0 auto;
}

tr {
	text-align: center;
}

table th, table td {
	border: 1px solid black;
}

.content {
	height: 500px;
}

.menu {
	display: flex;
	justify-content: space-evenly;
	height: 30px;
}

.menu a {
	line-height: 30px;
}
</style>
</head>
<body>
	<div>
		<table>
			<tr>
				<td><img
					src="${pageContext.request.contextPath}/view/imgs/logo.png"></td>
			</tr>
			<tr>
				<td class="menu">
					<a href="${pageContext.request.contextPath}">Danh sách tin tức</a> 
					<a href="${pageContext.request.contextPath}/TinTucFormServlet?action=showAddForm">Thêm tin tức mới</a> 
					<a href="${pageContext.request.contextPath}/QuanLyFormServlet?action=quanLy">Chức năng quản lý</a>
				</td>
			</tr>
			<tr class="content">
				<td>
					<table>
						<tr>
							<th>STT</th>
							<th>Tiêu đề</th>
							<th>Nội dung</th>
							<th>Liên kết</th>
							<th>Danh mục</th>
						</tr>
						<tr>
							<td colspan="5">
								<%
								if (pageContext.findAttribute("tinTucList") == null) {
									out.println("Không có dữ liệu");
								}
								%>
							</td>
						</tr>
						<c:forEach items="${tinTucList}" var="tinTuc" varStatus="index">
							<tr>
								<td>${index.count}</td>
								<td>${tinTuc.tieuDe}</td>
								<td>${tinTuc.noiDungTinTuc}</td>
								<td>${tinTuc.lienKet}</td>
								<td>${tinTuc.maDanhMuc}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td>Phạm Văn Thành - 21089891 - DHKTPM17BTT</td>
			</tr>
		</table>
	</div>
</body>
</html>
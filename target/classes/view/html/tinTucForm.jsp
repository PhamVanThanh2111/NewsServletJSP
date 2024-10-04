<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
}

table {
	width: 80%;
	margin: auto;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ddd;
	padding: 8px;
}

th {
	text-align: left;
}

td {
	text-align: center;
}

input[type="text"] {
	width: 100%;
	margin: 5px 0;
	height: 30px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.container {
	width: 100%;
	display: flex;
	flex-direction: column;
}

.aContainer {
	display: flex;
	justify-content: space-evenly;
}
</style>
</head>
<body>
	<div class="container">
		<div class="aContainer">
			<a href="">Danh sách tin tức</a> <a href="">Chức năng quản lý</a>
		</div>
		<div class="formContainer">
			<form action="TinTucFormServlet?action=add" method="POST">
				<table>
					<c:if test="${errors != null}">
					<tr>
						<td colspan="2" style="color: red"><c:out value="${errors}" /></td>
					</tr>
					</c:if>
					<tr>
						<th>Tiêu đề</th>
						<td><input type="text" name="tieuDe"></td>
					</tr>
					<tr>
						<th>Nội dung</th>
						<td><input type="text" name="noiDung"></td>
					</tr>
					<tr>
						<th>Liên kết</th>
						<td><input type="text" name="lienKet"></td>
					</tr>
					<tr>
						<th>Danh mục</th>
						<td><select name="category">
								<c:forEach items="${categoryList}" var="category">
									<option value="${category.maDanhMuc}">${category.tenDanhMuc}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
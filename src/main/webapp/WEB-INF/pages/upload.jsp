<%@ page contentType="text/html;charset=UTF-8" language="java"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<title>Title</title>
</head>
<body>

	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
		<table>
			<tr>
				<td>Укажите путь к файлу для загрузки</td>
				<td><input type="file" name="file" /></td>
				<td style="color: red; font-style: italic;">
				<form:errors path="file" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Загрузить файл СЗВ-К" /></td>
				<td></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
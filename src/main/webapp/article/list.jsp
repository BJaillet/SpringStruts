<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Products</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Titre</th>
			<th>Prix</th>
			<th>Action</th>
		</tr>
		<s:iterator value="articles" var="art">
			<tr>
				<td>${art.id}</td>
				<td>${art.titre}</td>
				<td>${art.prix}</td>
				<td colspan="3">
					<a href="delete.action?id=${art.id}">Delete</a>
					<a href="update.action?id=${art.id}">Update</a>
					<a href="../commande/addArticle.action?article.id=${art.id}">Buy</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>

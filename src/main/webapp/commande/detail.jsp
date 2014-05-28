<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Commande n°${commande.id} nb article : ${articlesCommande.size() }
<table>
		<tr>
			<th>ID</th>
			<th>Titre</th>
			<th>Prix</th>
			<th>Action</th>
		</tr>
		<s:iterator value="articlesCommande" var="art">
			<tr>
				<td>${art.id}</td>
				<td>${art.titre}</td>
				<td>${art.prix}</td>
				<td>
					<a href="removeArticle.action?commande.id=${commande.id}&article.id=${art.id}">Remove</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<a href="../article/list.action">Liste articles</a>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h2>Add Article</h2>
        
        <s:fielderror key="titre"/>
        
        <s:form action="add" >
        	<input type="hidden" name="id" value="${article.id}"/>
            <input type="text" name="titre" value="${article.titre}"/>
            <input type="text" name="prix" value="${article.prix}"/>
            <s:submit/>
        </s:form>     
        
        
        
    </body>
</html>

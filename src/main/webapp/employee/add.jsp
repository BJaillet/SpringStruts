<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h2>Add Employee</h2>
        
        <s:actionerror/>
        
        <s:form action="/hello/world" >
            <s:textfield name="id" label="Id"  />
            <s:textfield name="name" label="Name"  />
            <s:submit />
        </s:form>

       
        
    </body>
</html>

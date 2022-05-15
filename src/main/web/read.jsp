<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html>
<head>
    <title>Struts : Read</title>
</head>
<body>
<h1 align="center">Read Data from DB</h1>
<table align="center" border="1" cellspacing="5" cellpadding="5">
    <thead>
    <tr>
        <td>Id</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>City</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <logic:iterate id="user" name="userList">
        <tr>
            <td><bean:write name="user" property="id"/></td>
            <td><bean:write name="user" property="firstName"/></td>
            <td><bean:write name="user" property="lastName"/></td>
            <td><bean:write name="user" property="email"/></td>
            <td><bean:write name="user" property="city"/></td>
            <td><html:link action="/update" paramId="id" paramName="user" paramProperty="id">Click</html:link></td>
            <td><html:link action="/delete" paramId="id" paramName="user" paramProperty="id">Click</html:link></td>
        </tr>
    </logic:iterate>
    </tbody>
</table>
</body>
</html>

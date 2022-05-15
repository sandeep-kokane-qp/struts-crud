<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title>Struts : Insert</title>
</head>
<body>
<h1 align="center">Insert using Struts Tags</h1>
<html:form action="/register" focus="firstName">
    <table align="center">
        <tbody>
        <tr>
            <td>First Name</td>
            <td><html:text property="firstName"/></td>
            <td><html:errors property="firstName_e"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><html:text property="lastName"/></td>
            <td><html:errors property="lastName_e"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><html:text property="email"/></td>
            <td><html:errors property="email_e"/></td>
        </tr>
        <tr>
            <td>City</td>
            <td><html:text property="city"/></td>
            <td><html:errors property="city_e"/></td>
        </tr>
        <tr>
            <td><html:submit value="Insert"/></td>
            <td><html:reset value="Reset"/></td>
        </tr>
        </tbody>
    </table>
</html:form>
</body>
</html>

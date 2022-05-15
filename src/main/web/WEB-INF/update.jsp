<%@ page import="com.proj.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title>Struts : Update</title>
</head>
<body>
<h1>Update</h1>
<%
    User user = (User) request.getAttribute("user");
%>
<html:form action="/register" focus="firstName">
    <table>
        <tbody>
        <html:hidden property="id" value="<%=user.getId()%>"/>
        <tr>
            <td>First Name</td>
            <td><html:text property="firstName" value='<%=user.getFirstName()%>'/></td>
            <td><html:errors property="firstName_e"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><html:text property="lastName" value="<%=user.getLastName()%>"/></td>
            <td><html:errors property="lastName_e"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><html:text property="email" value="<%=user.getEmail()%>"/></td>
            <td><html:errors property="email_e"/></td>
        </tr>
        <tr>
            <td>City</td>
            <td><html:text property="city" value="<%=user.getCity()%>"/></td>
            <td><html:errors property="city_e"/></td>
        </tr>
        <tr>
            <td><html:submit value="Update"/></td>
            <td><html:reset value="Reset"/></td>
        </tr>
        </tbody>
    </table>
</html:form>

</body>
</html>

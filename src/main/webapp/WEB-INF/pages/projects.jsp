<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<body>
<h1>${message}</h1>


<c:if test="${not empty projects}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>projectName</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projects}" var="project">
            <tr>
                <td>${project.projectId}</td>
                <td>${project.projectName}</td>
                <td><a href="/editProject?projectId=${project.projectId}">edit project</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<a href="addProject">Create project</a>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<a href="*/addProject">Create project</a>

</body>
</html>
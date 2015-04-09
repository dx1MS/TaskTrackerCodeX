<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1>${message}</h1>


<c:if test="${not empty tasks}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Descr</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.descr}</td>
                <td><a href="/${task.id}">show task</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
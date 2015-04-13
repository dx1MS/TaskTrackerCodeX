<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<body>
<h1>${message}</h1>

<sec:authorize access="hasRole('MANAGER')">
<!-- For login user -->
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <form:form id="addProject" action="/saveProject" method="POST" modelAttribute="project">

        <form:hidden path="projectId"/>
        <form:input path="projectName" type="text"/>
        <br>
        <%--<c:choose>--%>
            <%--<c:when test="${project.tasks == null}">--%>
                <%--<form:input path="tasks[0].descr" type="text"/>--%>

                <%--<form:select path="tasks[0].user">--%>
                    <%--<form:option value="" label="--- Select ---"/>--%>
                    <%--<form:options items="${developersList}"/>--%>
                <%--</form:select>--%>
            <%--</c:when>--%>
            <%--<c:when test="${project.tasks != null}">--%>
                <%--<form:input path="tasks[${project.tasks.size() + 1}].descr" type="text"/>--%>

                <%--<form:select path="tasks[${project.tasks.size() + 1}].user">--%>
                    <%--<form:option value="" label="--- Select ---"/>--%>
                    <%--<form:options items="${developersList}"/>--%>
                <%--</form:select>--%>
            <%--</c:when>--%>
        <%--</c:choose>--%>
        <%--<button>submit</button>--%>
    </form:form>
    <c:forEach items="${project.tasks}" varStatus="i">
        <%--<br>--%>
        <%--<form:input path="tasks[${i.index}].descr" type="text"/>--%>
        <%--&lt;%&ndash;<form:select  path="tasks[${i.index}].user" type="text"/>&ndash;%&gt;--%>

        <%--<form:select path="tasks[${i.index}].user">--%>
        <%--<form:option value="" label="--- Select ---"/>--%>
        <%--<form:options items="${developerMap}" />--%>
        <%--</form:select>--%>
        <br>
        <tr>
            <td>${project.tasks[i.index].descr}</td>
            <td>${project.tasks[i.index].user}</td>
        </tr>

    </c:forEach>

<br>
<a href="/new_task?projectId=${projectId}">add Task</a>

<a href="/projects">back</a>
</sec:authorize>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<body>
<h1>${message}</h1>

<form:form id="addProject" action="/saveProject" method="POST" modelAttribute="project">

    <form:hidden  path="projectId"/>
    <form:input path="projectName" type="text"/>

    <c:forEach items="${project.tasks}" varStatus="i">

        <form:input path="tasks[${i.index}].descr" type="text"/>
        <%--<form:select  path="tasks[${i.index}].user" type="text"/>--%>

        <form:select path="tasks[${i.index}].user">
            <form:option value="" label="--- Select ---"/>
            <form:options items="${developerMap}" />
        </form:select>

    </c:forEach>

    <button>submit</button>
</form:form>



<a href="/new_task?projectId=${projectId}">add Task</a>

<a href="/projects">back</a>

</body>
</html>
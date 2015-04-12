<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>

<form:form id="task" action="/save_task?projectId=${projectId}" method="POST" modelAttribute="task">

    ${task.id}

    <form:input path="descr" type="text"/>

    <form:select path="userId">
        <form:option value="" label="--- Select ---"/>
        <form:options itemLabel="userName" itemValue="userId" items="${developersList}"/>
    </form:select>

    <button>save</button>
</form:form>

<a href="/project">back</a>
</body>
</html>
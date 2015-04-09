<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Descr</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${task.id}</td>
        <td>${task.descr}</td>
    </tr>
    </tbody>
</table>

<a href="/project">back</a>
</body>
</html>
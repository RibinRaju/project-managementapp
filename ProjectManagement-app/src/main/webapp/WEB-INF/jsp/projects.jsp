<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Projects</title>
</head>
<body>
    <h1>Projects</h1>
    <form action="${pageContext.request.contextPath}/projects" method="post">
        <input type="text" name="title" placeholder="Project Title" required/>
        <button type="submit">Create Project</button>
    </form>
    <ul>
        <c:forEach var="project" items="${projects}">
            <li>
                <a href="${pageContext.request.contextPath}/projects/${project.id}">${project.title}</a>
                <form action="${pageContext.request.contextPath}/projects/${project.id}/delete" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>

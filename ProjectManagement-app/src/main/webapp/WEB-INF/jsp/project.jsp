<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project Details</title>
</head>
<body>
    <h1>${project.title}</h1>
    <form action="${pageContext.request.contextPath}/projects/${project.id}/update" method="post">
        <input type="text" name="title" value="${project.title}" required/>
        <button type="submit">Update Project</button>
    </form>
    <h2>Todos</h2>
    <form action="${pageContext.request.contextPath}/projects/${project.id}/todos" method="post">
        <input type="text" name="description" placeholder="Todo Description" required/>
        <input type="text" name="status" placeholder="Status" required/>
        <button type="submit">Add Todo</button>
    </form>
    <ul>
        <c:forEach var="todo" items="${todos}">
            <li>
                ${todo.description} - ${todo.status}
                <form action="${pageContext.request.contextPath}/projects/${project.id}/todos/${todo.id}/update" method="post" style="display:inline;">
                    <input type="text" name="description" value="${todo.description}" required/>
                    <input type="text" name="status" value="${todo.status}" required/>
                    <button type="submit">Update</button>
                </form>
                <form action="${pageContext.request.contextPath}/projects/${project.id}/todos/${todo.id}/delete" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </li>
        </c:forEach>
    </ul>
    <a href="${pageContext.request.contextPath}/projects">Back to Projects</a>
</body>
</html>

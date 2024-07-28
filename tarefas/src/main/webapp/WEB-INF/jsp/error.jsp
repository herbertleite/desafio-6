<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Erro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
    <div class="container mt-5">
        <h1>Erro</h1>
        <div class="alert alert-danger">
            <c:out value="${errorMessage}"/>
        </div>
        <a href="/" class="btn btn-primary">Voltar para a Lista</a>
    </div>
</body>
</html>

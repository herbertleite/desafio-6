<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <style>
        .btn[disabled] {
            cursor: not-allowed;
            opacity: 0.65;
        }
        .btn-group {
            margin-right: 5px;
        }
        footer {
            padding: 20px;
            background-color: #f5f5f5;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
    <title><c:out value="${pageTitle}"/> Tarefas</title>
</head>
<body>
    <!-- Header -->
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">P&aacute;gina inicial</a>
            </div>
        </div>
    </nav>

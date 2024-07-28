<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="container mt-5">
    <a href="/" class="btn btn-primary">Voltar</a>
    <h1 class="mb-4">Nova Tarefa</h1>
    <form action="/novo" method="post">
        <div class="form-group">
            <label for="titulo">T&iacute;tulo:</label>
            <input type="text" id="titulo" name="titulo" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="descricao">Descri&ccedil;&atilde;o:</label>
            <textarea id="descricao" name="descricao" class="form-control" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Criar Tarefa</button>
    </form>
</div>
<%@ include file="footer.jsp" %>

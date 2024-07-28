<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="container mt-5">
    <a href="/" class="btn btn-primary mb-4">Voltar para a Lista</a>
    <h1 class="mb-4">Editar Tarefa</h1>
    <form action="/tarefas/${tarefa.id}/atualizar" method="post">
        <div class="form-group">
            <label for="titulo">T&iacute;tulo</label>
            <input type="text" id="titulo" name="titulo" class="form-control" value="${tarefa.titulo}" required />
        </div>
        <div class="form-group">
            <label for="descricao">Descri&ccedil;&atilde;o</label>
            <textarea id="descricao" name="descricao" class="form-control" rows="4">${tarefa.descricao}</textarea>
        </div>
        <div class="form-group">
            <label for="concluida">
                <input type="checkbox" id="concluida" name="concluida" <c:if test="${tarefa.concluida}">checked</c:if> />
                Conclu&iacute;da
            </label>
        </div>
        <input type="hidden" name="dataCriacao" value="${tarefa.dataCriacao}" />
        <input type="hidden" name="dataConclusao" value="${tarefa.dataConclusao}" />
        <button type="submit" class="btn btn-success">Atualizar</button>
    </form>
</div>
<%@ include file="footer.jsp" %>

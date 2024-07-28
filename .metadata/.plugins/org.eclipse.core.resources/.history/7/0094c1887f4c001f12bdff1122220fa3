<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="container">
    <h1>Lista de Tarefas</h1>
    <!-- Botão Nova Tarefa -->
    <a href="/novo" class="btn btn-primary spaced-button">Nova Tarefa</a>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>T&iacute;tulo</th> 
                <th>Descri&ccedil;&atilde;o</th> 
                <th>Conclu&iacute;da</th> 
                <th>A&ccedil;&otilde;es</th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tarefa" items="${tarefas}">
                <tr>
                    <td>${tarefa.id}</td>
                    <td>${tarefa.titulo}</td>
                    <td>${tarefa.descricao}</td>
                    <td><c:if test="${tarefa.concluida}">Sim</c:if><c:if test="${!tarefa.concluida}">N&atilde;o</c:if></td>
                    <td>
                        <a href="/tarefas/${tarefa.id}" class="btn btn-info btn-group">Visualizar</a>
                        
                        <a href="/tarefas/${tarefa.id}/editar" class="btn btn-warning btn-group">Editar</a>
                        
                        <form action="/tarefas/${tarefa.id}/deletar" method="post" style="display:inline;">
                            <button type="submit" class="btn btn-danger btn-group">Deletar</button>
                        </form>
                        
                        <form action="/tarefas/${tarefa.id}/concluir" method="post" style="display:inline;">
                            <button type="submit" class="btn btn-success btn-group"
                                    <c:if test="${tarefa.concluida}">disabled</c:if>>Concluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody> 
    </table>
</div>
<!-- Incluir o Rodapé -->
<%@ include file="footer.jsp" %>
</body>
</html>

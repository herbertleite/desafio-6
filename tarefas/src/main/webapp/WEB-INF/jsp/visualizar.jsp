<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<div class="container mt-5">
    <a href="/" class="btn btn-primary">Voltar para a Lista</a>
    <h1 class="mb-4">Detalhes da Tarefa</h1>
    <div class="card">
        <div class="card-header">
            <h3 class="card-title">Tarefa ID: ${tarefa.id}</h3>
        </div>
        <div class="card-body">
            <p><strong>Titulo:</strong> ${tarefa.titulo}</p>
            <p><strong>Descricao:</strong> ${tarefa.descricao}</p>
            <p><strong>Data de Criacao:</strong> <fmt:formatDate value="${tarefa.dataCriacao}" pattern="dd/MM/yyyy" /></p> 
            <p><strong>Data de Conclusao:</strong> <fmt:formatDate value="${tarefa.dataConclusao}" pattern="dd/MM/yyyy" /></p> 
            <p><strong>Concluida:</strong> <c:if test="${tarefa.concluida}">Sim</c:if><c:if test="${!tarefa.concluida}">Nao</c:if></p> 
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

# API de Gerenciamento de Tarefas

Esta API permite gerenciar tarefas, incluindo a criação, visualização, edição, atualização, deleção e conclusão de tarefas.

## Endpoints

### Listar Tarefas

#### `GET /`
Retorna a lista de todas as tarefas.

**Resposta:**
- `200 OK`: Retorna uma página com a lista de todas as tarefas.

### Exibir Tarefa

#### `GET /tarefas/{id}`
Exibe os detalhes de uma tarefa específica.

**Parâmetros:**
- `id` (path): ID da tarefa a ser exibida.

**Resposta:**
- `200 OK`: Retorna uma página com os detalhes da tarefa especificada.
- `404 Not Found`: Caso a tarefa com o ID especificado não seja encontrada.

### Editar Tarefa

#### `GET /tarefas/{id}/editar`
Retorna uma página para editar uma tarefa específica.

**Parâmetros:**
- `id` (path): ID da tarefa a ser editada.

**Resposta:**
- `200 OK`: Retorna uma página com um formulário para editar a tarefa especificada.
- `404 Not Found`: Caso a tarefa com o ID especificado não seja encontrada.

### Atualizar Tarefa

#### `POST /tarefas/{id}/atualizar`
Atualiza uma tarefa específica.

**Parâmetros:**
- `id` (path): ID da tarefa a ser atualizada.
- `tarefaAtualizada` (body): Objeto tarefa com os dados atualizados.

**Resposta:**
- `302 Found`: Redireciona para a página inicial após a atualização.
- `404 Not Found`: Caso a tarefa com o ID especificado não seja encontrada.

### Deletar Tarefa

#### `POST /tarefas/{id}/deletar`
Deleta uma tarefa específica.

**Parâmetros:**
- `id` (path): ID da tarefa a ser deletada.

**Resposta:**
- `302 Found`: Redireciona para a página inicial após a deleção.
- `404 Not Found`: Caso a tarefa com o ID especificado não seja encontrada.

### Concluir Tarefa

#### `POST /tarefas/{id}/concluir`
Marca uma tarefa específica como concluída.

**Parâmetros:**
- `id` (path): ID da tarefa a ser concluída.

**Resposta:**
- `302 Found`: Redireciona para a página inicial após marcar como concluída.
- `404 Not Found`: Caso a tarefa com o ID especificado não seja encontrada.

### Nova Tarefa - Formulário

#### `GET /novo`
Retorna uma página com um formulário para criar uma nova tarefa.

**Resposta:**
- `200 OK`: Retorna uma página com um formulário para criar uma nova tarefa.

### Criar Tarefa

#### `POST /novo`
Cria uma nova tarefa.

**Parâmetros:**
- `tarefa` (body): Objeto tarefa com os dados da nova tarefa.

**Resposta:**
- `302 Found`: Redireciona para a página inicial após a criação da tarefa.

### Tratamento de Exceções

#### Global Exception Handler

**Parâmetros:**
- `TarefaNotFoundException`: Exceção lançada quando uma tarefa não é encontrada.

**Resposta:**
- `404 Not Found`: Retorna uma página de erro com a mensagem "Tarefa não encontrada".

---

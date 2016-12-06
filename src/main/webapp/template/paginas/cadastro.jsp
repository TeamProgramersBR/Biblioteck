<%@page import="br.harlock.model.Usuario"%>
<%
    Usuario u = (Usuario) session.getAttribute("login");
    if (u == null) {
        u = new Usuario();
            u.setNome("");
            u.setSenha("");
            u.setCpf("");
            u.setMatriculaEducacional("");
            u.setEmail("");
            u.setEnderecoCEP("");
            u.setEnderecoCidade("");
            u.setEnderecoCEP("");
            u.setEnderecoEstado("");
            u.setEnderecoLogadouro("");
            u.setEnderecoPais("Brasil");
            u.setNivelDeAcesso("Aluno");
            u.setNumeroCelular("");
            u.setNumeroComercial("");
            u.setNumeroResidencial("");
        }
    Usuario cadastrado = new Usuario();
    if (request.getAttribute("usuario") != null) {
            cadastrado = (Usuario) request.getAttribute("usuario");
        }else{
        cadastrado.setIdUsu(0);
            
            
            cadastrado.setIdUsu(0);
            cadastrado.setNome("");
            cadastrado.setSenha("");
            cadastrado.setMatriculaEducacional("");
            cadastrado.setCpf("");
            cadastrado.setEmail("");
            cadastrado.setEnderecoCEP("");
            cadastrado.setEnderecoCidade("");
            cadastrado.setEnderecoCEP("");
            cadastrado.setEnderecoEstado("");
            cadastrado.setEnderecoLogadouro("");
            cadastrado.setEnderecoPais("Brasil");
            cadastrado.setNivelDeAcesso("Aluno");
            cadastrado.setNumeroCelular("");
            cadastrado.setNumeroComercial("");
            cadastrado.setNumeroResidencial("");
    }
%>
<% if(u.getNivelDeAcesso().equals("Adminstrador") || u.getNivelDeAcesso().equals("Funcionario")){%>
<div class="containerX">
    <div class="col-5 float-l">
        <h2><%if(cadastrado.getIdUsu()!=0){%>Editar Usuario<%}else{%>Cadastrar usuario<%}%></h2>
    </div>
    <div class="col-5 float-l">
        <a onclick="voltar()" class="float-r"><button class="botaoX verde">Voltar</button></a>
    </div>
</div>
<%}%>
<div class="containerX">
    <div class="containerMD">
        <form class="form-login" name="salvarForm" action="Usuario.do" id="salvarForm" method="post">
            <input type="hidden" name="acao" id="acao" value="cadastrar">
            <div class="float-l">
                <input type="hidden" name="ID" class="campo-form" value="<%=cadastrado.getIdUsu()%>" size="30"> </div>
            <div class="float-l">
                <label>Nome</label>
                <input type="text" name="nome" class="campo-form" value="<%=cadastrado.getNome()%>" size="30"> </div>
            <div class="float-l">
                <label>CPF</label>
                <input type="text" name="CPF" id="cpf" class="campo-form" value="<%=cadastrado.getCpf()%>" size="30"> </div>
            <div class="float-l">
                <label>Email</label>
                <input type="text" name="email" class="campo-form" value="<%=cadastrado.getEmail()%>" size="30"> </div>
            <div class="float-l">
                <label>Senha</label>
                <input type="password" name="senha" class="campo-form" value="<%=cadastrado.getSenha()%>" size="30"> </div>
            <div class="float-l">
                <label>Telefone Residencial:</label>
                <input type="text" name="telres" class="campo-form" value="<%=cadastrado.getNumeroResidencial()%>" size="30"> </div>
            <div class="float-l">
                <label>Telefone Celular:</label>
                <input type="text" name="telcel" class="campo-form" value="<%=cadastrado.getNumeroCelular()%>" size="30"> </div>
            <div class="float-l">
                <label>Telefone Comercial:</label>
                <input type="text" name="telcom" class="campo-form" value="<%=cadastrado.getNumeroComercial()%>" size="30"> </div>
            <div class="float-l">
                <label>Matricula</label>
                <input type="text" name="matricula" class="campo-form" value="<%=cadastrado.getMatriculaEducacional()%>" size="30"> </div>
            <div class="float-l">
                <label>Logradouro</label>
                <input type="text" name="logr" class="campo-form" value="<%=cadastrado.getEnderecoLogadouro()%>" size="30"> </div>
            <div class="float-l">
                <label>CEP</label>
                <input type="text" name="CEP" class="campo-form" value="<%=cadastrado.getEnderecoCEP()%>" size="30"> </div>
            <div class="float-l">
                <label>Cidade</label>
                <input type="text" name="cidade" class="campo-form" value="<%=cadastrado.getEnderecoCidade()%>" size="30"> </div>
            <div class="float-l">
                <label>Estado</label>
                <input type="text" name="estado" class="campo-form" value="<%=cadastrado.getEnderecoEstado()%>" size="30"> </div>
            <div class="float-l">
                <label>Pais</label>
                <input type="text" name="pais" class="campo-form" value="<%=cadastrado.getEnderecoPais()%>" size="30"> </div>
                
            <div class="float-l">
                <label>Tipo de conta:</label>
                <select class="" name="acesso" id="acesso">
                    <option value="option">Tipo de conta</option>
                    <%if(cadastrado.getNivelDeAcesso()!="")%> <option value="<%=cadastrado.getNivelDeAcesso()%>" selected=""><%=cadastrado.getNivelDeAcesso()%></option> <%;%>
                    <option value="4">Aluno</option>
                    <option value="3">Professor</option>
                    <% if(u.getNivelDeAcesso().equals("Adminstrador") || u.getNivelDeAcesso().equals("Funcionario")){%>
                    <option value="1">Admin</option>
                    <option value="2">Funcionario</option>
                    <%}%>
                    
                </select>
            </div>
            
            <div class="float-l">
                <% if(u.getNivelDeAcesso().equals("Adminstrador") || u.getNivelDeAcesso().equals("Funcionario")){%>
                <label>Status</label>
                <select id="status" name="status" >
                    <%if(cadastrado.getStatusDoUsuario()!=""){%> <option value="<%=cadastrado.getStatusDoUsuario()%>" selected=""><%=cadastrado.getStatusDoUsuario()%></option> <%}%>
                    <option value="liberado" >liberado</option>
                    <option value="Pendente">Pendente</option>
                    <option value="Inativo">Inativo</option>
                </select>
                <%}%>
            <div class="float-l">
                <a onclick="salvar('salvar')">
                    <input type="button" class="botaoX verde" name="cadastrar" value="Salvar">
                </a>
            </div>
        </form>
    </div>
</div>
<script>
    function salvar(acao) {
        document.getElementById("acao").value = acao;
        document.getElementById("salvarForm").submit();
    }
       function voltar() {
                window.history.back();
            }
</script>
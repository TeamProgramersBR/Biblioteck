<div class="containerX">
    <div class="containerMD">
        <form class="form-login" name="salvarForm" action="Usuario.do" id="salvarForm" method="post">
            <input type="hidden" name="acao" id="acao" value="cadastrar">
            <div class="float-l">
                <label>ID</label>
                <input type="text" name="ID" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Nome</label>
                <input type="text" name="nome" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>CPF</label>
                <input type="text" name="CPF" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Email</label>
                <input type="text" name="email" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Senha</label>
                <input type="password" name="senha" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Telefone Residencial:</label>
                <input type="text" name="telres" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Telefone Celular:</label>
                <input type="text" name="telcel" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Telefone Comercial:</label>
                <input type="text" name="telcom" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Matricula</label>
                <input type="text" name="matricula" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Logradouro</label>
                <input type="text" name="logr" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>CEP</label>
                <input type="text" name="CEP" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Cidade</label>
                <input type="text" name="cidade" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Estado</label>
                <input type="text" name="estado" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Pais</label>
                <input type="text" name="pais" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <label>Tipo de conta:</label>
                <select class="" name="acesso">
                    <option value="option">Tipo de conta</option>
                    <option value="1">Admin</option>
                    <option value="2">Funcionario</option>
                    <option value="3">Professor</option>
                    <option value="4">Aluno</option>
                </select>
            </div>
            <div class="float-l">
                <label>Status</label>
                <input type="text" name="sts" class="campo-form" value="" size="30"> </div>
            <div class="float-l">
                <a onclick="salvar('cadastrar')">
                    <input type="button" class="botaoX verde" name="cadastrar" value="cadastrar">
                </a>
            </div>
            <div class="float-l">
                <a onclick="salvar('atualizar')">
                    <input type="button" class="botaoX azul" name="atualizar" value="atualizar">
                </a>
            </div>
            <div class="float-l">
                <a onclick="salvar('remover')">
                    <input type="button" class="botaoX vermelho" name="remover" value="remover">
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
</script>
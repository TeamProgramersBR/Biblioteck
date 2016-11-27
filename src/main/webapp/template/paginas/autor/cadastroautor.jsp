<%@page import="br.harlock.model.Autor"%>
<%@page import="br.harlock.model.Sistema"%>
<%
    Sistema s = new Sistema();
    Autor autor = new Autor();
    if (request.getAttribute("autor") != null) {
        autor = (Autor) request.getAttribute("autor");
    }else{
        autor.setNome("");
        autor.setIdAutor(0);
        autor.setNomeFantasia("");
        autor.setNacionalidade(" ");
    }
%>
<div class="containerX">
    <div class="col-5 float-l">
        <h2><%if(autor.getIdAutor()!=0){%>Editar Autor<%}else{%>Cadastrar Autor<%}%></h2>
    </div>
    <div class="col-5 float-l">
        <a onclick="voltar()" class="float-r"><button class="botaoX verde">Voltar</button></a>
    </div>
</div>
<div class="containerX">
    <div class="containerMD">
        <form class="form-login" name="salvarForm" action="<%=s.url%>Autor.do?acao=salvar" id="salvarForm" method="post">
            <input type="hidden" id="acao" name="acao" value="cadastrar" />
            <div class="float-l">
                <input type="hidden" name="ID" class="campo-form" value="<%=autor.getIdAutor()%>" size="30"> 
            </div>
            <div class="float-l">
                <label>Nome</label>
                <input type="text" name="nome" class="campo-form" value="<%=autor.getNome()%>" size="30">
            </div>
            <div class="float-l">
                <label>Nome Fantasia</label>
                <input type="text" name="fantasia" class="campo-form" value="<%=autor.getNomeFantasia()%>" size="30"> 
            </div>
            <div class="float-l">
                <label>Nacionalidade</label>
                <input type="text" name="nacio" class="campo-form" value="<%=autor.getNacionalidade()%>" size="30"> 
            </div>
            <div class="float-l">
                <a onclick="salvar('salvar')">
                    <input type="button" class="botaoX verde" value="Salvar"> </a>
            </div>
            
        </form>
    </div>
</div>
<script>
    function salvar(acao) {
        document.getElementById("salvarForm").submit();
    }
    function voltar() {
    window.history.back();
}
</script>
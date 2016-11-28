<%@page import="br.harlock.model.Categoriaitemacervo"%>
<%@page import="br.harlock.model.Sistema"%>
<%
    Sistema s = new Sistema();
    Categoriaitemacervo cat = new Categoriaitemacervo();
    if (request.getAttribute("cat") != null) {
        cat = (Categoriaitemacervo) request.getAttribute("cat");
        }else{
        cat.setNomeCategoria(" ");
        cat.setDescricao(" ");
        cat.setIdCat(0);
        
    }
    
%>
<div class="containerX">
    <div class="col-5 float-l">
        <h2> <% if (cat.getIdCat()!=0){%>Editar Categoria<%}else{%>Cadastrar Categoria <% } %> </h2>
        
    </div>
    <div class="col-5 float-l">
        <a onclick="voltar()" class="float-r"><button class="botaoX verde">Voltar</button></a>
    </div>
</div>
<div class="containerX">
            <div class="containerMD">
                <form class="form-login" name="salvarForm" action="<%=s.url%>Categoria.do" id="salvarForm" method="post">
                    <input type="hidden" id="acao" name="acao" value="cadastrar" />
                    <div class="float-l">
                        <input type="hidden" name="ID" class="campo-form" value="<%=cat.getIdCat()%>" size="30"> </div>
                    <div class="float-l">
                        <label>Nome</label>
                        <input type="text" name="nome" class="campo-form" value="<%=cat.getNomeCategoria()%>" size="30"> </div>
                    <div class="float-l">
                        <label>Descrição</label>
                        <input type="text" name="desc" class="campo-form" value="<%=cat.getDescricao()%>" size="30"> </div>
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
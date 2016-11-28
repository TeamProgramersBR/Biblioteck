<%@page import="br.harlock.model.ProdutoraConteudo"%>
<%@page import="br.harlock.model.Sistema"%>
    <%
Sistema s = new Sistema();
ProdutoraConteudo produtora = new ProdutoraConteudo();
if(request.getAttribute("produtora") != null){
    produtora = (ProdutoraConteudo) request.getAttribute("produtora");
}else{
    produtora.setCnpj("");
    produtora.setIdPdc(0);
    produtora.setNomeProdutora("");
    produtora.setDescricao("");
}
%>
<div class="containerX">
    <div class="col-5 float-l">
        <h2><%if(produtora.getIdPdc()!=0){%>Editar Produtora<%}else{%>Cadastrar Produtora<%}%></h2>
    </div>
    <div class="col-5 float-l">
        <a onclick="voltar()" class="float-r"><button class="botaoX verde">Voltar</button></a>
    </div>
</div>
        <div class="containerX">
            <div class="containerMD">
                <form class="form-login" action="<%=s.url%>Produtora.do?acao=salvar" name="salvarForm" id="salvarForm" method="post">
                    <input type="hidden" id="ID" name="ID" value="<%=produtora.getIdPdc()%>" />
                    <div class="float-l">
                        
                       <div class="float-l">
                        <label>Nome</label>
                        <input type="text" name="nome" class="campo-form" value="<%=produtora.getNomeProdutora()%>" size="30"> </div>
                    <div class="float-l">
                        <label>Descrição</label>
                        <input type="text" name="desc" class="campo-form" value="<%=produtora.getDescricao()%>" size="30"> </div>
                    <div class="float-l">
                        <label>CNPJ</label>
                        <input type="text" name="CNPJ" class="campo-form" value="<%=produtora.getCnpj()%>" size="30"> </div>
                    <div class="float-l">
                        <a onclick="salvar()">
                            <input type="button" class="botaoX vermelho" name="remover" value="Salvar">
                        </a>
                    </div>
                </form>
            </div>
        </div>
        <script>
            function salvar() {
                document.getElementById("salvarForm").submit();
            }
                function voltar() {
                window.history.back();
            }
        </script>
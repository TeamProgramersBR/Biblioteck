<%@page import="java.util.Iterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.ProdutoraConteudo"%>

<%
    boolean mostrar = false;
    ArrayList<ProdutoraConteudo> produtoras = new ArrayList();
    if (request.getAttribute("produtoras") != null) {
            mostrar = true;
            Iterator iterator = (Iterator) request.getAttribute("produtoras");
            while (iterator.hasNext()) {                    
                    produtoras.add((ProdutoraConteudo)iterator.next());
                }
        }
%>
<div class="containerX">
    <a href="index.jsp?pagina=produtoresui" class="float-r"><button class="botaoX verde">+Nova produtora</button></a>
</div>
<%if(mostrar){%>
<table>
    <tr>
        <th class="texto-centro">Nome da produtora</th>
        <th class="texto-centro">Descrição da produtora</th>
        <th class="texto-centro">CPNJ</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <%for(ProdutoraConteudo p: produtoras){%>
    <tr>
        
        <td><%=p.getNomeProdutora()%></td>
        <td><%=p.getDescricao()%></td>
        <td><%=p.getCnpj()%></td>
        <td class="float-r">
            <a href="Produtora.do?acao=update&ID=<%=p.getIdPdc()%>"><button class="botaoX azul">Editar</button></a>
            <a href="Produtora.do?acao=remover&ID=<%=p.getIdPdc()%>"><button class="botaoX verde">Excluir</button></a>
        </td>
        <%}%>
    </tr>

</table>
<%}else{%>
<h2>Ainda sem produtores</h2>
<%}%>
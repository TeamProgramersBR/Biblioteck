<%@page import="br.harlock.model.Categoriaitemacervo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>

<%
    boolean mostrar = false;
    Iterator iterator  = null;
    if (request.getAttribute("categorias") != null) {
        iterator = (Iterator) request.getAttribute("categorias");
        mostrar = true;
    }


%>

<div class="containerX">
    <a href="index.jsp?pagina=categoriaui" class="float-r"><button class="botaoX verde">+Nova Categoria</button></a>
</div>
<%if(mostrar){%>
<table>
    <tr>
        <th class="texto-centro">Nome</th>
        <th class="texto-centro">Descrição</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <%while (iterator.hasNext()) {
        Categoriaitemacervo cat = (Categoriaitemacervo) iterator.next();
    %>
    <tr>   
        <td><%=cat.getNomeCategoria()%></td>
        <td><%=cat.getDescricao()%></td>
        <td class="float-r">
            <a href="Categoria.do?acao=update&ID=<%=cat.getIdCat()%>"><button class="botaoX azul">Editar</button></a>
            <a href="Categoria.do?acao=remover&ID=<%=cat.getIdCat()%>"><button class="botaoX verde">Excluir</button></a>
        </td>
    </tr>
    <%}%>

</table>
<%}%>
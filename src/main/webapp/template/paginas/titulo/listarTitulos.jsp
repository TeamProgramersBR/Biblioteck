<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

    ArrayList titulos = new ArrayList();

    if (request.getAttribute("titulos") != null) {
        Iterator<Titulo> iterator = (Iterator) request.getAttribute("titulos");
        while (iterator.hasNext()) {
            titulos.add(iterator.next());
        }
    }
   
%>


<div class="containerX">
    <div class="float-r">
        <a href="index.jsp?pagina=tituloui"><button class="botaoX verde texto-branco">+ Titulo</button></a>
    </div>
</div>
<% if(titulos.isEmpty()){ %>
        <h2>Não há titulos cadastrados.</h2>
<%}else{%>
<table>
    <tr>
        <th class="texto-centro">Obra</th>
        <th class="texto-centro">Tipo</th>
        <th class="texto-centro">Categoria</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td class="float-r">
            <a href="Titulo.do?acao=editar"><button class="botaoX azul">Editar</button></a>
            <a href="Titulo.do?acao=editar"><button class="botaoX verde">Exemplares</button></a>
        </td>
    </tr>

</table>
<%}%>

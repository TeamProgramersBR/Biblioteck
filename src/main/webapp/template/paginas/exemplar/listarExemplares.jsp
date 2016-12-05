<%@page import="br.harlock.model.Exemplar"%>
<%@page import="br.harlock.model.Categoriaitemacervo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    boolean mostrar = false;
    Iterator iterator = null;
    String liberacao = " ";
    Titulo tid = new Titulo();
    if (request.getAttribute("IDt") != null) {
        tid = (Titulo) request.getAttribute("IDt");
    }
    if (request.getAttribute("exemplares") != null) {
        iterator = (Iterator) request.getAttribute("exemplares");
        mostrar = true;
    }


%>
<% int IDt = tid.getIdTitu();%>
<div class="containerX">
    <a href="Exemplar.do?acao=insert&IDt=<%=IDt%>&Disp=s"><button class="botaoX azul">Adicionar Disponivel</button></a>
    <a href="Exemplar.do?acao=insert&IDt=<%=IDt%>&Disp=n"><button class="botaoX verde">Adicionar Amostra</button></a>
</div>

<% if (mostrar) { %>
<table>
    <tr>
         <th class="texto-centro">ID </th>
        <th class="texto-centro">Status</th>
       
            <%--  <th class="texto-centro">Duração</th>
              <th class="texto-centro">Paginas</th> --%>
        <th class="texto-centro">Ação</th>
    </tr>
    <%while (iterator.hasNext()) {
      Exemplar  exemplar = (Exemplar) iterator.next();
    %>
    <%
        if (exemplar.getFkTitulo() == tid.getIdTitu()) {
    %>
    
    <tr>
        <td class="texto-centro"><%=exemplar.getIdExe()%>-<%=IDt%></td>
        <%
            if (exemplar.getLiberadoParaEmprestimo() == true) {
                liberacao = "Disponivel";
            } else if (exemplar.getLiberadoParaEmprestimo() == false) {
                liberacao = "Amostra";
            }
        %>
        
        <td class="texto-centro"><%=liberacao%></td>
        <%--  <td><%=exemplar.getDuracao()%></td>
          <td><%=exemplar.getQuantidadePaginas()%></td>
        --%>


        <% int ID = exemplar.getIdExe();%>

    <input type="hidden" id="asd" name="asd" value="<%=ID%>">
    <td class="float-r">

        <a href="Exemplar.do?acao=delete&ID=<%=ID%>&IDt=<%=IDt%>"><button class="botaoX vermelho">Deletar</button></a>
    </td>
</tr>
<%}
    }%>
</table>

<%} else {%>
<h2>Não há Exemplares para este titulo.</h2>
<%}%>

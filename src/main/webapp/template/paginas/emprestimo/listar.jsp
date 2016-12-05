<%@page import="java.util.Iterator"%>
<%@page import="br.harlock.model.Emprestimo"%>
<%@page import="java.util.ArrayList"%>
<%

    boolean mostrar = false;
     Iterator iterator = null;
    if (request.getAttribute("emprestimos") != null) {
        mostrar = true;
        iterator = (Iterator) request.getAttribute("emprestimos");
    }

%>
<div class="containerX">
    <div class="float-r">
        <a href="index.jsp?pagina=novoemprestimo"><button class="botaoX verde texto-branco">+ novo emprestimo</button></a>
    </div>
</div>
<% if (mostrar) { %>

<table>
    <tr>
        <th class="texto-centro">Destinado </th>
        <th class="texto-centro">Situação</th>
        <th class="texto-centro">Data de devolução</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <% while (iterator.hasNext()) {
        Emprestimo emp = (Emprestimo) iterator.next();
    %>
    <tr>
        <td><%=emp.getUsuarioDoSistema().getNome()%></td>
        <td><%=emp.getSituacao()%></td>
        <td><%=emp.getDataPrevDevolucao()%></td>
        <td class="float-r">
            <a href="Emprestimo.do?acao=detalhes&ID=<%=emp.getIdEmp()%>"><button class="botaoX verde">Detalhes</button></a>
        </td>
    </tr>
    <%}%>
</table>
<%}else{%>
<h2>Não há emprestimos cadastrados.</h2>
<%}%>
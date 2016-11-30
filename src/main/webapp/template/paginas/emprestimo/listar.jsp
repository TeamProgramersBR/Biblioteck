<%@page import="java.util.Iterator"%>
<%@page import="br.harlock.model.Emprestimo"%>
<%@page import="java.util.ArrayList"%>
<%

    ArrayList<Emprestimo> emprestimos = new ArrayList();

    if (request.getAttribute("emprestimos") != null) {
        Iterator<Emprestimo> iterator = (Iterator) request.getAttribute("emprestimos");
        while (iterator.hasNext()) {
            emprestimos.add(iterator.next());
        }
    }

%>
<div class="containerX">
    <div class="float-r">
        <a href="index.jsp?pagina=novoemprestimo"><button class="botaoX verde texto-branco">+ novo emprestimo</button></a>
    </div>
</div>
<% if (emprestimos.isEmpty()) { %>
<h2>Não há emprestimos cadastrados.</h2>
<%} else {%>
<table>
    <tr>
        <th class="texto-centro">Destinado </th>
        <th class="texto-centro">Situação</th>
        <th class="texto-centro">Data de devolução</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <%for (Emprestimo emp : emprestimos) {%>
    <tr>
        <td><%=emp.getUsuarioDoSistema().getNome()%></td>
        <td><%=emp.getSituacao()%></td>
        <td><%=emp.getDataPrevDevolucao()%></td>
        <td class="float-r">
            <a href="Emprestimo.do?acao=editar&ID=<%=emp.getIdEmp()%>"><button class="botaoX azul">Editar</button></a>
            <a href="Emprestimo.do?acao=detalhes&ID=<%=emp.getIdEmp()%>"><button class="botaoX verde">Detalhes</button></a>
        </td>
    </tr>
    <%}%>
</table>
<%}%>
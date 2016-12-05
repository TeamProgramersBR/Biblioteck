<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Usuario"%>
<%
    boolean mostrar = false;
    Iterator iterator = null;
    if (request.getAttribute("usuarios") != null) {
            mostrar = true;
            iterator = (Iterator) request.getAttribute("usuarios");
        }
%>
<div class="containerX">
    <a href="index.jsp?pagina=usuarioui" class="float-r"><button class="botaoX verde">+Novo usuario</button></a>
</div>
<%if(mostrar){%>
<table>
    <tr>
        <th class="texto-centro">Nome</th>
        <th class="texto-centro">Status</th>
        <th class="texto-centro">Matricula</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <%while(iterator.hasNext()){
        Usuario p = (Usuario) iterator.next();
    %>
    <tr>
        
        <td><%=p.getNome()%></td>
        <td><%=p.getStatusDoUsuario()%></td>
        <td><%=p.getMatriculaEducacional()%></td>
        <td class="float-r">
            <a href="Usuario.do?acao=update&ID=<%=p.getIdUsu()%>"><button class="botaoX azul">Editar</button></a>
            <a href="Usuario.do?acao=remover&ID=<%=p.getIdUsu()%>"><button class="botaoX verde">Excluir</button></a>
        </td>
        <%}%>
    </tr>

</table>
<%}else{%>
<h2>Ainda sem Usuarios</h2>
<%}%>
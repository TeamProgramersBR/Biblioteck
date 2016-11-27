<%@page import="br.harlock.model.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>

<%
    boolean mostrar = false;
    ArrayList<Autor> autores = new ArrayList();
    if (request.getAttribute("autores") != null) {
        Iterator iterator = (Iterator) request.getAttribute("autores");
        mostrar = true;

        if (iterator.hasNext()) {

            while (iterator.hasNext()) {
                autores.add((Autor) iterator.next());
            }
        }
    }

%>
<div class="containerX">
    <a href="index.jsp?pagina=autorui" class="float-r"><button class="botaoX verde">+Novo Autor</button></a>
</div>
<%if (mostrar) {%>
<table>
    <tr>
        <th class="texto-centro">Nome</th>
        <th class="texto-centro">Nome fantasia</th>
        <th class="texto-centro">Nacionalidade</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <%for (Autor autor: autores) {%>
    <tr>
        <td><%=autor.getNome()%></td>
        <td><%=autor.getNomeFantasia()%></td>
        <td><%=autor.getNacionalidade()%></td>
        <td class="float-r">
            <a href="Autor.do?acao=update&ID=<%=autor.getIdAutor()%>"><button class="botaoX azul">Editar</button></a>
            <a href="Autor.do?acao=remover&ID=<%=autor.getIdAutor()%>"><button class="botaoX verde">Excluir</button></a>
        </td>
    </tr>
    <%}%>
</table>
<%} else {%>
<h2>Não há autores cadastrados ainda.</h2>
<%}%>
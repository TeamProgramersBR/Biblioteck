
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="br.harlock.dao.TituloDAO"%>
<%
    TituloDAO dao = new TituloDAO();
    Iterator listar = null;

    if (request.getParameter("pesquisa") != null) {
        listar = dao.consutlarporTitulo(request.getParameter("pesquisa"));
    } else {
        listar = dao.ConsultarTodos();
    }
    int cont = 1;
%>
<div class="containerX">
    <form class="search-container" method="post" action="index.jsp">
        <input type="text" id="search-bar" name="pesquisa" placeholder="O que posso te ajudar a encontrar hoje?">
        <button>Pesquisar</button>
    </form>
</div>
<div class="espaceembranco">

</div>


<%if (listar.hasNext()) {%>
<ul class="exibeListaTitulo">
    <% while (listar.hasNext() && cont != 5) {
            cont++;
            Titulo titulo = (Titulo) listar.next();
    %>
    <li class="imagem">
        <img src="template/imgs/imgindisponivel.png" width="160" height="240">
        <a href="index.jsp?pagina=resultadoTitulo&idT=<%=titulo.getIdTitu()%>"> <%=titulo.getObra()%></a>
    </li>
    <%}%>

</ul>
<%} else {%>
<h2><center>A pesquisa obteve zero resultado</center>
        <%}%>

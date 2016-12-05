<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="br.harlock.dao.TituloDAO"%>
<div class="containerX">
  <form class="search-container">
    <input type="text" id="search-bar" placeholder="O que posso te ajudar a encontrar hoje?">
    <a href="#"><img class="search-icon" src="template/imgs/search-icon.png"></a>
  </form>
</div>
<div class="espaceembranco">

</div>
<%
    TituloDAO dao = new TituloDAO();
    Iterator listar = (Iterator) dao.ConsultarTodos();
    int cont = 1;
    %>


<ul class="exibeListaTitulo">
    <% while(listar.hasNext() && cont !=5){
        cont++;
    Titulo titulo = (Titulo) listar.next();
%>
    <li class="imagem">
        <img src="template/imgs/imgindisponivel.png" width="160" height="240">
        <%=titulo.getObra()%>
    </li>
    <%}%>
  
</ul>


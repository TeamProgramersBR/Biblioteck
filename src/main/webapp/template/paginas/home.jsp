
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="br.harlock.dao.TituloDAO"%>
<div class="containerX">
  <form class="search-container">
    <input type="text" id="search-bar" placeholder="O que posso te ajudar a encontrar hoje?">
    <a href="#"><img class="search-icon" src="template/imgs/search-icon.png"></a>
  </form>
</div>
  <div class="containerMD">
      <form class="search-container" method="post" action="index.jsp">
      <input type="text" id="search-bar" name="pesquisa" placeholder="O que posso te ajudar a encontrar hoje?">
      <button><img class="search-icon" src="imgs/search-icon.png"></button>
    </form>
  </div>
<div class="espaceembranco">

</div>
<%
    TituloDAO dao = new TituloDAO();
    Iterator listar = null;
    
    if(request.getParameter("pesquisa") != null){ 
       listar =  dao.consutlarporTitulo(request.getParameter("pesquisa"));
    }else{
       listar =  dao.ConsultarTodos(); 
    }
    int cont = 1;
    %>

<%if(listar.hasNext()){%>
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
<%}else{%>
<h2><center>A pesquisa obteve zero resultado</center>
<%}%>

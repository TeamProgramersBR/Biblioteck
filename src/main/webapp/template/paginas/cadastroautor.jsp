<%@page import="br.harlock.model.Sistema"%>
<%
Sistema s = new Sistema();
%>

<div class="containerX">
  <div class="containerMD">
      <form class="form-login" action="<%=s.url%>Autor.do?acao=cadastrar" method="post">
        <div class="float-l">
            
        <label>Nome</label>
        <input type="text" name="nome" class="campo-form" value="" size="30" >
      </div>
      <div class="float-l">
        <label>Nome Fantasia</label>
        <input type="text" name="fantasia" class="campo-form" value="" size="30" >
      </div>
      <div class="float-l">
        <label>Nacionalidade</label>
        <input type="text" name="nacio" class="campo-form" value="" size="30" >
      </div>
      
      
      <div class="float-l">
        <input type="submit" class="botaoX verde" name="cadastrar" value="cadastrar">
      </div>
    </form>
  </div>
</div>

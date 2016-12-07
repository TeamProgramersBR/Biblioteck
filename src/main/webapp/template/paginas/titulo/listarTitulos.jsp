<%@page import="br.harlock.model.Categoriaitemacervo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    boolean mostrar = false;
    Iterator iteratorTitulos = null; 
    
if (request.getAttribute("titulos") != null) {
         iteratorTitulos = (Iterator) request.getAttribute("titulos");
        mostrar = true;
    }



   
%>


<div class="containerX">
    <div class="float-r">
        <a href="Titulo.do?acao=tituloui"><button class="botaoX verde texto-branco">+ Titulo</button></a>
    </div>
</div>
<% if(mostrar){ %>
        <table>
    <tr>
        <th class="texto-centro">Obra</th>
        <th class="texto-centro">Tipo</th>
        <th> </th>
        <th class="texto-centro">Categoria</th>
        <th class="texto-centro">A��o</th>
    </tr>
     <%while (iteratorTitulos.hasNext()) {
            Titulo titulo = (Titulo) iteratorTitulos.next();
            String s = titulo.getCategoriaitemacervo().getNomeCategoria();
     %>
     
     
    <tr>
        <td><%=titulo.getObra()%></td>
       
        <td><%=titulo.getTipoDeObra()%><td/>
           <td><%=s%></td>
    
    
         <% int ID = titulo.getIdTitu(); %>
    <input type="hidden" id="asd" name="asd" value="<%=ID%>">
 <% String ref1 ="Titulo.do?acao=exemplar&ID="+ID; String ref ="Titulo.do?acao=update&ID="+ID;%>
        <td class="float-r">
            <a href="<%=ref%>"><button class="botaoX azul">Editar</button></a>
            <a href="<%=ref1%>"><button class="botaoX verde">Exemplares</button></a>
        </td>
    </tr>
<%}%>
        </table>
        
<%}else{%>
<h2>N�o h� titulos cadastrados.</h2>
<%}%>

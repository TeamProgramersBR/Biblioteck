<%@page import="br.harlock.model.Categoriaitemacervo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    boolean mostrar = false;
    ArrayList<Titulo> titulos = new ArrayList();
     ArrayList<Categoriaitemacervo> categorias = new ArrayList();
if (request.getAttribute("titulos") != null) {
        Iterator iterator = (Iterator) request.getAttribute("titulos");
        mostrar = true;

        if (iterator.hasNext()) {

            while (iterator.hasNext()) {
                titulos.add((Titulo) iterator.next());
            }
        }
    }

if (request.getAttribute("categorias") != null) {
        Iterator iterator2 = (Iterator) request.getAttribute("categorias");
        

        if (iterator2.hasNext()){

            while (iterator2.hasNext()) {
                categorias.add((Categoriaitemacervo) iterator2.next());
            }
        }
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
        <th class="texto-centro">Categoria</th>
        <th class="texto-centro">Ação</th>
    </tr>
     <%for (Titulo titulo: titulos) {%>
     
     
    <tr>
        <td><%=titulo.getObra()%></td>
        <td><%=titulo.getTipoDeObra()%></td>
        <%  int ct =titulo.getFkItemAcervo();
            
            for (Categoriaitemacervo categoria: categorias) {
            String s ="";
            if (ct == categoria.getIdCat()) {
                    s=categoria.getNomeCategoria();
                    %><td><%=s%></td>
                         <%}%>
        
       
        <%}%>
    
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
<h2>Não há titulos cadastrados.</h2>
<%}%>

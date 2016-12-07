<script src="template/js/jquery-barcode.min.js" charset="utf-8"></script>
<%@page import="br.harlock.model.Usuario"%>
<%@page import="br.harlock.model.Exemplar"%>
<%@page import="br.harlock.dao.ExemplarDAO"%>
<%@page import="br.harlock.model.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="br.harlock.dao.TituloDAO"%>
<%
    boolean mostrar = false;
    TituloDAO pesquisaTitulo = new TituloDAO();
    ExemplarDAO exemplarDAO = new ExemplarDAO();
    Titulo titulo = new Titulo();
    Iterator exemplares = null;
    if (request.getParameter("idT") != null) {
        mostrar = true;
        titulo.setIdTitu(Integer.parseInt(request.getParameter("idT")));
        titulo = pesquisaTitulo.Pesquisar(titulo);
        exemplares = exemplarDAO.listarDeTitulo(titulo);
    }
    Usuario u = null;
     if (session.getAttribute("login") != null) {
        u = (Usuario) session.getAttribute("login");
    }
%>
<%if (mostrar) {%>
<div class="containerX">
    <div class="col-12">
        <div class="col-3 azul float-l" >
            <legend class="texto-branco"><%=titulo.getObra()%></legend>
            <img src="template/imgs/imgindisponivel.png" width="160" height="240">
        </div>
        <div class="col-6  float-l">
            <h2>Descrição</h2>
            <h3><%=titulo.getDescricao()%></h3>
            <p>
                Obra do tipo: <%=titulo.getTipoDeObra()%>
            </p>
        </div>
    </div>
    <div class="col-12">
        <table>
            <tr>
                <th class="texto-centro">ID </th>
                <th class="texto-centro">Status</th>

            </tr>
            <%while (exemplares.hasNext()) {
                    Exemplar exemplar = (Exemplar) exemplares.next();
            %>

            <tr>
                <td class="texto-centro"><div id="<%=exemplar.getIdExe()%>-<%=exemplar.getFkTitulo()%>"></div>
                  <%=exemplar.getIdExe()%>-<%=exemplar.getFkTitulo()%></td>
                
            <script>
                var texto = '<%=exemplar.getIdExe()%>-<%=exemplar.getFkTitulo()%>';
                $("#<%=exemplar.getIdExe()%>-<%=exemplar.getFkTitulo()%>").barcode("<%=exemplar.getIdExe()%>-<%=exemplar.getFkTitulo()%>", "code39",{barWidth:2, barHeight:30});     
            </script>
                <% String liberacao = "";
                    if (exemplar.getLiberadoParaEmprestimo() == true) {
                        liberacao = "Disponivel";
                    } else if (exemplar.getLiberadoParaEmprestimo() == false) {
                        liberacao = "Amostra";
                    }
                %>

                <td class="texto-centro"><%=liberacao%></td>

                <% int ID = exemplar.getIdExe();%>

            <input type="hidden" id="asd" name="asd" value="<%=ID%>">
         
            </tr>
            <%}%>
        </table>

    </div>
</div>
<%} else {%>
<h1>Algo deu errado volte e tente novamente.</h1>
<%}%>

<div class="espaceembranco">
    
</div>
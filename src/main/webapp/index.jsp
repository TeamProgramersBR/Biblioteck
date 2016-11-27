<%-- 
    Document   : index
    Created on : 21/11/2016, 20:08:09
    Author     : Harlock
--%>
<%@ page import="br.harlock.model.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page session="true" %>

<%
    Usuario u = (Usuario) session.getAttribute("login");
    String pagina = "home";
    if (request.getParameter("pagina") != null) {
        pagina = request.getParameter("pagina");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
        <link rel="stylesheet" href="template/css/estilo.css" media="screen" title="no title">
    </head>
    <body>
        <div class="container bg">
            <div  class="containerLogo">
                <div class="containerMD">
                    <img  class="logo" src="template/imgs/logo.png" alt="" />
                </div>
                <div class="containerMD direita horizontal">
                    <%if (u == null) {%>
                    <div class="col-9">
                        <a href="index.jsp?pagina=entrar" ><button class="botaoX azul">Entrar</button></a>
                        <a href="index.jsp?pagina=cadastro"  ><button class="botaoX vermelho">Cadastrar</button></a>
                    </div>

                    <%} else {%>
                    <div class="col-9">
                        <div class="col-9 float-l txt-branco"><%=u.getNome()%>
                            <a href="Auth.do?acao=sair"><button class="botaoX vermelho">Sair</button></a>
                        </div>
                    </div>


                    <%}%>
                </div>
            </div>
        </div>
        <div class="containerX">
            <nav >
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="index.jsp?pagina=titulosCTRL">Titulos</a></li>
                    <li><a href="Autor.do?acao=autores">Autores</a></li>
                    <li><a href="index.jsp?pagina=produtoresCTRL">Produtores de Conteudo</a></li>
                    <li><a href="index.jsp?pagina=emprestimosCTRL">Emprestimos</a></li>
                    <li><a href="index.jsp?pagina=usuariosCTRL">Usuários</a></li>
                </ul>
            </nav>
        </div>
        <!--- aqui vai corpo -->

        <div class="containerX">
            <%if (pagina.equals("cadastro")) {%>
            <jsp:include page = "template/paginas/cadastro.jsp" />
            <%} else if (pagina.equals("entrar")) {%>
            <jsp:include page = "template/paginas/login.html" />
            <%} else if (pagina.equals("titulosCTRL")) {%>
            <jsp:include page = "template/paginas/titulo/listarTitulos.jsp" />
            <%} else if (pagina.equals("tituloui")) {%>
            <jsp:include page = "template/paginas/titulo/tituloui.jsp" />
            <%} else if (pagina.equals("autoresCTRL")) {%>
            <jsp:include page = "template/paginas/autor/listar.jsp" />
            <%} else if (pagina.equals("editarAutor")) {%>
            <jsp:include page = "template/paginas/autor/cadastroautor.jsp" />
            <%} else if (pagina.equals("produtoresCTRL")) {%>
            <%} else if (pagina.equals("produtoresCTRL")) {%>
            <%} else if (pagina.equals("produtoresCTRL")) {%>
            <jsp:include page = "template/paginas/login.html" />
            <%} else if (pagina.equals("emprestimosCTRL")) {%>
            <jsp:include page = "template/paginas/login.html" />
            <%} else if (pagina.equals("usuariosCTRL")) {%>
            <jsp:include page = "template/paginas/login.html" />
            <%} else {%>
            <jsp:include page = "template/paginas/home.html" />
            <%}%>
        </div>
    </div>

    <!-- aqui vai css -->
    <script src="template/js/jquery-3.1.1.min.js"></script>
    <!--<script src="js/sessao.js" charset="utf-8"></script>-->
    <!--<script src="js/formularios.js" charset="utf-8"></script>-->
</body>
</html>

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
    Boolean liberadoADMN = false;
    Usuario u = null;
    if (session.getAttribute("login") != null) {
        u = (Usuario) session.getAttribute("login");
        if (u.getNivelDeAcesso().equals("Adminstrador")) {
            liberadoADMN = true;
        }
    }

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
        <link rel="stylesheet" href="template/js/jquery-ui.css" media="screen" title="no title">
    </head>
    <body>
        <!-- aqui vai css -->
    
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
                        <%if (liberadoADMN) {%>
           <%--      <li><a href="Titulo.do?acao=tituloui">Titulos</a></li> --%>
                  <li><a href="Titulo.do?acao=titulos">Titulos</a></li>  
                    <li><a href="Autor.do?acao=autores">Autores</a></li>
                    <li><a href="Produtora.do?acao=produtoras">Produtores de conteudo</a></li>
                    <li><a href="Categoria.do?acao=categorias">Categorias de conteúdo</a></li>
                    <li><a href="Emprestimo.do?acao=emprestimos">Emprestimos</a></li>
                    <li><a href="Usuario.do?acao=usuarios">Usuários</a></li>
                        <%}%>
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
            <jsp:include page = "template\paginas\autor\listar.jsp" />
            <%} else if (pagina.equals("exemplaresCTRL")) {%>
            <jsp:include page = "template/paginas/exemplar/listarExemplares.jsp" />
            <%} else if (pagina.equals("autorui")) {%>
            <jsp:include page = "template/paginas/autor/cadastroautor.jsp" />
            <%} else if (pagina.equals("produtoresCTRL")) {%>
            <jsp:include page = "template/paginas/produtora/listar.jsp" />
            <%} else if (pagina.equals("produtoresui")) {%>
            <jsp:include page = "template/paginas/produtora/cadastroprodutora.jsp" />
            <%} else if (pagina.equals("categoriasCTRL")) {%>
            <jsp:include page = "template/paginas/categoria/listar.jsp" />
            <%} else if (pagina.equals("categoriaui")) {%>
            <jsp:include page = "template/paginas/categoria/cadastrocategoria.jsp" />
            <%} else if (pagina.equals("usuariosCTRL")) {%>
            <jsp:include page = "template/paginas/usuario/listar.jsp" />
            <%} else if (pagina.equals("usuarioui")) {%>
            <jsp:include page = "template/paginas/cadastro.jsp" />
            <%} else if (pagina.equals("emprestimosCTRL")) {%>
            <jsp:include page = "template/paginas/emprestimo/listar.jsp" />
            <%} else if (pagina.equals("novoemprestimo")) {%>
            <jsp:include page = "template/paginas/emprestimo/realizar.jsp" />
            <%} else {%>
            <jsp:include page = "template/paginas/home.html" />
            <%}%>
        </div>
    </div>
<script src="template/js/jquery-3.1.1.min.js"></script>
    <!--<script src="js/sessao.js" charset="utf-8"></script>-->
    <script src="template/js/formularios.js" charset="utf-8"></script>
    
</body>
</html>

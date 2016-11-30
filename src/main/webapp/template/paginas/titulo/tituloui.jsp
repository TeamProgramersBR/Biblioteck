<%@page import="br.harlock.model.Titulo"%>
<%@page import="br.harlock.model.Autor"%>
<%@page import="br.harlock.model.ProdutoraConteudo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%
    ArrayList<Autor> autores = new ArrayList();
    ArrayList<ProdutoraConteudo> produtoras = new ArrayList();
    if (request.getAttribute("autores") != null && request.getAttribute("prdoutoras") != null) {
        Iterator iteratorAutores = (Iterator) request.getAttribute("autores");
        Iterator iteratorProdutoraDeConteudo = (Iterator) request.getAttribute("prdoutoras");
        while (iteratorAutores.hasNext()) {
            autores.add((Autor) iteratorAutores.next());
        }
        while (iteratorProdutoraDeConteudo.hasNext()) {
            produtoras.add((ProdutoraConteudo) iteratorProdutoraDeConteudo.next());
        }
    }
    Titulo titulo = new Titulo(" ");
    if (request.getAttribute("titulo") != null) {
        titulo = (Titulo) request.getAttribute("titulo");
    }
    String[] tipoDeTitulo = {"Livro", "Vídeo", "Artigo", "Revista"};
%>

<form method="POST" action="Titulo.do?acao=salvar" name="salvar" id="form" >

    <div class="col-12">
        <label>Nome da obra</label>
        <input type="text" name="obra" >
        <input type="hidden" id="idTitulo" value="<%=titulo.getIdTitu()%>"

               <div class="col-10 float-l">
            <label>tipo de obra</label>
            <select onclick="tipoDeTitulo()" id="tipoobra" name="tipoObra">
                <option>Selecione</option>
                <%
                    for (String tipo : tipoDeTitulo) {
                        if (tipo == titulo.getTipoDeObra()) {
                %>
                <option value="<%=tipo%>" selected=""><%=tipo%></option>
                <% } else {%>
                <option value=""><%=tipo%></option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <div class="col-5 float-l">
            <label>Descrição</label>
            <textarea id="descricao" name="descricao" value="<%=titulo.getDescricao()%>"></textarea>
        </div>
        <div class="col-5 float-l">
            <label>Imagem</label>
            <input type="file" name="inp" id="inp" accept="image/*">
            <img id="img" width="140" height="170">
            <input type="hidden" name="base64img" id="base64img" value="<%=titulo.getCapa()%>">
        </div>
        <div class="col-10">
            <label >ISBN</label>
            <input type="text" id="ISBN" name="ISBN"  value="<%=titulo.getIsbn()%>">
        </div>
        <br>

        <div class="col-10">

            <label>ISSN</label>
            <input type="text" name="ISSN" id="ISSN"  value="<%=titulo.getIssn()%>">
        </div>
        <div class="col-5 float-l">
            <label>Editor</label>
            <select id="editor">
                <option>
                    Selecione um editor
                </option>
                <%for (Autor a : autores) {%>
                <option value="<%=a.getIdAutor()%>"><%=a.getNome()%></option>
                <%}%>
            </select>
        </div>
        <div class="col-5 float-l">
            <label>Volume</label>
            <input type="text" id="Volume" name="Volume" value="<%=titulo.getEdicao()%>"
        </div>
    </div>

    <div class="col-5 float-l">
        <label>Duração</label>
        <input type="text" name="duracao" id="duracao"  value="<%=titulo.getDuracao()%>">
    </div>
    <div class="col-5 float-l">
        <label>Número de páginas </label>
        <input type="text" name="numeropaginas" id="numeropaginas"  value="<%=titulo.getQuantidadePaginas()%>">
    </div>
    <div class="col-4 float-l">
        <label>Data de publicação</label>
        <input type="date" name="datapublicacao"  value="<%=titulo.getDataDePublicacao()%>">
    </div>
    <div class="col-10 float-l">
        <label>Estado de Publicacao</label>
        <select id="estado" name="estado"  value="<%=titulo.getEstadoPublicacao()%>">
            <option value="goias">Goias</option>
        </select>
    </div>
    <div class="col-5 float-l">
        <label>Cidade de publicação</label>
        <select id="cidade" name="cidade"  value="<%=titulo.getCidadePublicacao()%>">
            <option value="gyn">Goiania</option>
        </select>
    </div>


    <div class="col-5 float-l">
        <label>Idioma Original</label>
        <select id="idiomaObra" name="idiomaObra"  value="<%=titulo.getIdioma()%>">
            <option value="gyn">Goiania</option>
        </select>
    </div>

    <div class="col-5 float-l">
        <label>Idioma da tradução</label>
        <select id="traducao" name="traducao"  value="<%=titulo.getTraducao()%>">
            <option value="gyn">Goiania</option>
        </select>
    </div>
    <div class="col-10 float-l">
        <label>Produtora</label>
        <select id="produtora" name="produtora">
            <% for (ProdutoraConteudo p : produtoras) {%>
            <% if (p.getIdPdc() == titulo.getFkItemPdc()) {%>
            <option value="<%=p.getIdPdc()%>" selected=""><%=p.getNomeProdutora()%></option>
            <%}else{%>
            <option value="<%=p.getIdPdc()%>"><%=p.getNomeProdutora()%></option>
            <% }}%>
        </select>
    </div>
    <div class="col-5 float-l">
        <label>Autores e co-autores</label>
        <table id="AutoresTb" name="AutoresTb">
            <tbody>
                <tr>
                    <th class="texto-centro">Tipo de autor</th>
                    <th class="texto-centro">Nome autor </th>
                    <th><a onclick="addRowAutores()"><input type='button' value='+' class='botaoS verde'></a></th>
                </tr>
            </tbody>

        </table>
    </div>
    <div class="col-5 float-l">
        <label>Exemplares</label>
        <table id="exemplaresTB" name="exemplaresTB">
            <tbody>
                <tr>
                    <th class="texto-centro">ID</th>
                    <th class="texto-centro">Código</th>
                    <th class="texto-centro">Apenas consulta<th>
                    <th><a onclick="addRowExemplares()"><input type='button' value='+' class='botaoS verde'></a></th>
                </tr>
            </tbody>

        </table>
    </div>

    <div class="col-5 float-l"></div>
    <div class="col-5 float-l"> 
        <button type="submit" class="botaoX verde float-r">Salvar</button>
        <div class="float-r"></div>
    </div>


</form>


<script>

    function addRowAutores() {
        
        var html = "<tr><td><select id='tipoDeAutor' name='autores'><option value='Autor'>Autor</option><option value='Co-autor'>Co-autor</option></select></td><td><select id='autorObra'><%for (Autor a : autores) {%><option value='<%=a.getIdAutor()%>'><%=a.getNome()%></option><%}%></select></td><td><a onclick='deletarRowAutores(this);'><button class='botaos vermelho'>-</button></a> </td></tr>";

        $('#AutoresTb > tbody:last-child').append(html);
    }

    function addRowExemplares() {
        var html = "<tr><td><input type='hidden' name='exemplar' value='salvar'>Pendente</td><td>Pendente</td><td><input type='checkbox' name='liberadoParaEmprestimo' value='1' > </td><td><a onclick='deletarRowExemplares(this)'><button class='botaos vermelho'>-</button></a></td></tr>";
        $('#exemplaresTB > tbody:last-child').append(html);
    }

    function deletarRowAutores(remove) {
        $(remove).parent().parent().remove();
    }
    function deletarRowExemplares(remove) {
        $(remove).parent().parent().remove();
    }
    function tipoDeTitulo() {
        switch ($("#tipoobra option:selected").text()) {
            case "Livro":
                todoscamposTituloUInormal();
                document.getElementById("ISSN").value = "";
                document.getElementById("ISSN").disabled = true;
                document.getElementById("duracao").value = "";
                document.getElementById("duracao").disabled = true;
                break;
            case "Revista":
                todoscamposTituloUInormal();
                document.getElementById("ISBN").value = "";
                document.getElementById("ISBN").disabled = true;

                document.getElementById("duracao").value = "";
                document.getElementById("duracao").disabled = true;
                break;
            case "Artigo":
                todoscamposTituloUInormal();
                todoscamposTituloUInormal();
                document.getElementById("ISBN").value = "";
                document.getElementById("ISBN").disabled = true;
                break;
            case "Vídeo":
                todoscamposTituloUInormal();
                document.getElementById("numeropaginas").value = "";
                document.getElementById("numeropaginas").disabled = true;
                document.getElementById("ISSN").value = "";
                document.getElementById("ISSN").disabled = true;
                document.getElementById("ISBN").value = "";
                document.getElementById("ISBN").disabled = true;

        }
        function todoscamposTituloUInormal() {
            document.getElementById("ISBN").disabled = false;
            document.getElementById("ISSN").disabled = false;
            document.getElementById("duracao").disabled = false;
            document.getElementById("numeropaginas").disabled = false;
//            document.getElementById("ISBN").disabled = false;

        }
        ;

        function readFile() {
            if (this.files && this.files[0]) {
                var FR = new FileReader();
                FR.onload = function (e) {
                    document.getElementById("img").src = e.target.result;
                    console.log(e.target.result);
//                    document.getElementById("b64").innerHTML = e.target.result;
                };
                FR.readAsDataURL(this.files[0]);
            }
        }

        document.getElementById("inp").addEventListener("change", readFile, false);
    }


</script>







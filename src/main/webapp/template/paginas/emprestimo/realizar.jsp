<%@page import="br.harlock.model.Exemplar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.harlock.model.Usuario"%>
<%
    Usuario logado;
    Usuario requerinte = null;
    boolean requerinteexiste = false;
    ArrayList<Exemplar> carrinho = new ArrayList();
    String t = null;
    if (session.getAttribute("titulos") != null) {

    }
    if (session.getAttribute("usuarioRequere") != null) {
        requerinte = (Usuario) session.getAttribute("usuarioRequere");
        requerinteexiste = true;
    }
    if (session.getAttribute("login") != null) {
        logado = (Usuario) session.getAttribute("login");
        if (logado.getNivelDeAcesso().equals("Aluno") || logado.getNivelDeAcesso().equals("Professor")) {
            requerinte = logado;
        }
    }

    if (session.getAttribute("carrinho") != null) {
        carrinho = (ArrayList) session.getAttribute("carrinho");
    }
    String mensagem = "";
    boolean mensagemmostrar = false;
    //Mensagens de alerta para exemplar
    if (request.getParameter("como") != null) {
        String temp = request.getParameter("como");
        mensagemmostrar = true;
        if (temp.equals("ExemplarNaoExiste")) {
            mensagem = "O exemplar pesquisado não existe.";
        } else if (temp.equals("jaestanacesta")) {
            mensagem = "O exemplar já esta na cesta.";
        } else if (temp.equals("indisponivel")) {
            mensagem = "O exemplar está indisponível.";
        }

    }
    if (request.getParameter("usur") != null) {
        mensagemmostrar = true;
        String temp = request.getParameter("usur");
        if (temp.equals("indisponivel")) {
            mensagem = "O usuário pesquisado não costa na base de dados.";
        }
    }
    String tipoEmprestimo = "";
    if (session.getAttribute("tipoDeEmprestimo") != null) {
        tipoEmprestimo = (String) session.getAttribute("tipoDeEmprestimo");
    }
%>
<div class="containerX">

    <div class="col-12 float-l">
        <a onclick="voltar()" class="float-r"><button class="botaoX verde">Voltar</button></a>
        <%if (requerinteexiste) {%>
        <a href="Emprestimo.do?acao=cancelar" class="float-r"><button class="botaoX vermelho">Cancelar</button></a>    
        <%}%>

    </div>
</div>
<%if (mensagemmostrar) {%>
<div class="containerX">
    <div class="alert">
        <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
        <strong>Aviso!</strong> <%=mensagem%>
    </div>
</div>
<%}%>
<%if (requerinteexiste) {%>
<div class="containerX">
    <div class="col-12 float-l">
        <label><%=requerinte.getNivelDeAcesso()%>: <%=requerinte.getNome()%></label>
        <select id="tipoDeEmprestimo" class="col-4" name="tipoDeEmprestimo"  readonly>
            <option value="Emprestimo">Emprestimo</option>
            <option value="Reserva">Reserva</option>
        </select>
    </div>

</div>
<%}%>
<div class="containerX">

    <table>
        <tbody>
            <tr>
                <td>
                    <%if (!requerinteexiste) {%>
                    <form method="post" action="Emprestimo.do?acao=verificarUsuario">
                        <table>
                            <tr>
                                <td><input type="text" id="cpf" name="cpfR" placeholder="C.P.F" class="inputN"></td>
                                <td>
                                    <select id="tipoDeEmprestimo" name="tipoDeEmprestimoA">
                                        <option value="Emprestimo">Emprestimo</option>
                                        <option value="Reserva">Reserva</option>
                                    </select></td>
                                <td style="">

                                </td>
                                <td><button type="submit" class="botaoX azul texto-branco">Usuario</button></td>
                            </tr>

                        </table>
                    </form>
                    <%}%>
                </td>

                <td>
                    <%if (requerinteexiste) {%>
                    Data de Locação <input type="date" id="datainput"  onkeypress="verificarData()" name="dataemprestimo" style="width: 140px;">
                    Data prevista devoluçao <input type="date" id="DATAD"  style="width: 140px;" readonly="">
                    <%} else {%>
                    Primeiro diga quem esta querendo fazer um emprestimo ou reserva
                    <%}%>
                </td>

                <td colspan="2">
                    <%if (requerinteexiste) {%>
                    <form method="POST" id="adicionarExemplar" action="Emprestimo.do?acao=pesquisaExemplar" class="float-r">
                        <input type="search" name="pesquisa" id="pesquisaBara" size="10" >
                        <a onclick="adicionar()"><input type="button" class="botaoX azul" value="Adicionar" id="pesquisaBara"></a>
                        <input id="idT" name="idT" type="hidden">
                        <input id="idE" name="idE" type="hidden">
                    </form>
                    <%}%>
                </td>
            </tr>
        </tbody>
    </table>


    <table >
        <tbody>

            <tr>
                <td style="">Obra</td>
                <td style="">Tipo</td>
                <td style="">Código exemplar</td>

            </tr>
            <% if (carrinho != null) {
                    for (Exemplar ex : carrinho) {%>
            <tr>
                <td style=""><%=ex.getTitulo().getObra()%></td>
                <td style=""><%=ex.getTitulo().getTipoDeObra()%></td>
                <td style=""><%=ex.getIdExe()%>-<%=ex.getTitulo().getIdTitu()%></td>
                <td style=""></td>
            </tr>
            <%}
            } else {%>
        <h2>Ainda não tem exemplares escolhidos</h2>
        <%}%>

        </tbody>
    </table>
    <table>
        <tbody>
            <tr>
                <% if (carrinho != null) { %>
        <form id="salvar" action="Emprestimo.do?acao=concluirEmprestimo" method="post">
            <input name="dataLocacao" id="dataLocacao" type="hidden" value="">
            <input name="dataPrevisaoDevolucao" id="dataPrevisaoDevolucao" type="hidden"  value="">
            <input name="statusEmprestimo" type="hidden" id="statusEmprestimo"  value="">
            <a onclick="salvar()"><button type="button" class="botaoX azul">Concluir</button></a>
        </form>
        <%}%>
        </td>
        </tr>  
        </tbody>
    </table>
    <p>&nbsp;</p> 
</div>

<script>
    function salvar() {
        var ver = document.getElementById("datainput").value;
        if (ver == "" || ver == undefined) {
            alert("Defina a data.");
        } else {
            document.getElementById("salvar").submit();

        }
    }
    <%if (requerinteexiste) {%>
    var element = document.getElementById('tipoDeEmprestimo');
    element.value = "<%=tipoEmprestimo%>";
    var compara = "<%=tipoEmprestimo%>";
    var tipo = 1;
    if (compara == "Reserva") {
        tipo = 4;
    } else if (compara == "Emprestimo") {
        tipo = 1;
    }
    document.getElementById('statusEmprestimo').value = "" + tipo;
    <%}%>


    function voltar() {
        window.history.back();
    }


    function verificarData() {
        var dataInput = document.getElementById("datainput").value;

        dataInput = new Date(dataInput);
        var temp = dataInput.toISOString();
        temp = temp.split("T");
        document.getElementById("dataLocacao").value = temp[0];
    <%if (requerinte != null) {%>
        var datadev = new Date(dataInput);
        var dias = 3;
    <%if (requerinte.getNivelDeAcesso().equalsIgnoreCase("Professor")) {%>
        var dias = 5;
    <%}%>
        datadev.setDate(dataInput.getDate() + dias);
        var dia = datadev.getDay();
        if (dia == 0) {
            datadev.setDate(datadev.getDate() + 1);
        } else if (dia == 6) {
            datadev.setDate(datadev.getDate() + 2);
        }
        var dataD = datadev.toISOString();
        dataD = dataD.split("T");

        console.log(dataD);
        document.getElementById("DATAD").value = dataD[0];
        document.getElementById("dataPrevisaoDevolucao").value = dataD[0];
    <%}%>
    }
    ;

    function adicionar() {
        var correto = $('#pesquisaBara').val();
        var verifica = correto.split("-");
        if (verifica.length === 2) {
            $('#idT').val(verifica[0]);
            $('#idE').val(verifica[1]);
            $("#adicionarExemplar").submit();
        } else {
            alert('O Código inserido e invalido');
        }
    }
</script>
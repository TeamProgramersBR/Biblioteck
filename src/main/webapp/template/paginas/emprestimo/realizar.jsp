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
%>
<div class="containerX">

    <div class="col-12 float-l">
        <a onclick="voltar()" class="float-r"><button class="botaoX verde">Voltar</button></a>
        <%if(requerinteexiste){%>
        <a href="Emprestimo.do?acao=cancelar" class="float-r"><button class="botaoX vermelho">Cancelar</button></a>    
        <%}%>
        
    </div>
</div>
<div class="containerX">

    <table>
        <tbody>
            <tr>
                <td>
                    <%if (requerinteexiste) {%>
                    <%=requerinte.getNome()%>
                    <%} else {%>
                    <form method="post" action="Emprestimo.do?acao=verificarUsuario">
                        <table>
                            <tr>
                                <td><input type="text" id="cpf" name="cpfR" placeholder="C.P.F" class="inputN"></td>
                                <td><button type="submit" class="botaoX azul texto-branco">Usuario</button></td>
                            </tr>

                        </table>
                    </form>
                    <%}%>
                </td>

                <td>
                    <%if (requerinteexiste) {%>
                    Data de Locação <input type="date" id="datainput"  onkeypress="verificarData()" name="dataemprestimo" style="width: 140px;">
                    Data prevista devoluçao <input type="date" id="DATAD" disabled="" style="width: 140px;">
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
                <td style=""><select id="tipoDeEmprestimo">
                        <option>Emprestimo</option>
                        <option>Reserva</option>
                    </select></td>
                <td style="">

                    <a onclick=""><button class="botaoX azul">Concluir</button></a>
                </td>
            </tr>  
        </tbody>
    </table>
    <p>&nbsp;</p> 
</div>

<script>
    
    function voltar() {
        window.history.back();
    }
    $('#datainput').datepicker();
    
    function verificarData() {
        var dataInput = document.getElementById("datainput").value;
        var date = new Date( Date.parse( dataInput )); 
        date.setHours(0,0,0,0);
        var dataAgora = new Date();
        dataAgora.setHours(0,0,0,0)
        
        
          <%if(requerinte != null){%>
            var compara = "<%=requerinte.getNivelDeAcesso()%>";
            if (compara == "Aluno") {
                    var dayOffset = 20;
                    var millisecondOffset = 5 * 24 * 60 * 60 * 1000;
                    date.setTime(date.getTime() + millisecondOffset); 
                    $("#DATAD").value(date);
                }else{
                   var dayOffset = 20;
                   var millisecondOffset = 7 * 24 * 60 * 60 * 1000;
                   date.setTime(date.getTime() + millisecondOffset); 
                   $("#DATAD").value(date);
                };
            <%}%>
        
    };
    
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
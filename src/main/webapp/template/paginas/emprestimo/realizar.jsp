<%
    if (session.getAttribute("titulos") != null) {
    };
%>
<div class="containerX">

    <div class="col-12 float-l">
        <a onclick="voltar()" class="float-r"><button class="botaoX verde">Voltar</button></a>
    </div>
</div>
<div class="containerX">
    <table style="height: 213px;" width="427">
        <tbody>
            <tr>
                <td></td>
                <td colspan="3">
                    <form method="POST" id="adicionarExemplar" action="Emprestimo.do?acao=pesquisaExemplar" class="float-r">
                        <input type="search" name="pesquisa" id="pesquisaBara" size="10" >
                        <a onclick="adicionar()"><input type="button" class="botaoX azul" value="Adicionar"></a>
                        <input id="idT" name="idT" type="hidden">
                        <input id="idE" name="idE" type="hidden">
                    </form>
                </td>
            </tr>
            <tr>
                <td style="">Obra</td>
                <td style="">Tipo</td>
                <td style="">Data Prevista devolução</td>
                <td style="">Código exemplar</td>
            </tr>
            
              <tr>
                <td style="">&nbsp;</td>
                <td style="">&nbsp;</td>
                <td style="">&nbsp;</td>
                <td style="">&nbsp;</td>
            </tr>
            <tr>
                <td style="">&nbsp;</td>
                <td style="">&nbsp;</td>
                <td style="">&nbsp;</td>
                <td style="">
                    <select id="tipoDeEmprestimo">
                        <option>Emprestimo</option>
                        <option>Reserva</option>
                    </select>
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
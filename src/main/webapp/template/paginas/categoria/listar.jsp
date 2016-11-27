<%
    boolean visualizar = false;
%>

<%if(visualizar){%>
<table>
    <tr>
        <th class="texto-centro">Obra</th>
        <th class="texto-centro">Tipo</th>
        <th class="texto-centro">Categoria</th>
        <th class="texto-centro">Ação</th>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td class="float-r">
            <a href="Titulo.do?acao=editar"><button class="botaoX azul">Editar</button></a>
            <a href="Titulo.do?acao=editar"><button class="botaoX verde">Exemplares</button></a>
        </td>
    </tr>

</table>
<%}%>
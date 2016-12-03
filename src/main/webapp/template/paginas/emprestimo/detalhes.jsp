<%@page import="br.harlock.model.Exemplar"%>
<%@page import="br.harlock.model.Emprestimo"%>
<%@page import="java.util.Iterator"%>
<%
    boolean mostrar = true;
    Iterator iteratorExemplares = null;
    Emprestimo emprestimo = null;
if (request.getAttribute("emprestimo") != null && request.getAttribute("exemplares") != null) {
        iteratorExemplares = (Iterator) request.getAttribute("exemplares");
        emprestimo = (Emprestimo) request.getAttribute("emprestimo");
    }

%>
<%if (mostrar) {%>
<div class="containerX">

    <table>
        <tbody>
            <tr>
                <td>
                    <form method="post" action="Emprestimo.do?acao=verificarUsuario">
                        <table>
                            <tr>
                                <td>
                                    <label>Mudar status do emprestimo </label>
                                    <select id="status" class="col-4">
                                        <option value="1">Aberto</option>
                                        <option value="2">Fechado</option>
                                        <option value="3">Em Andamento</option>
                                        <option value="4">Reserva</option>
                                        <option value="5">Atrasado</option>
                                        <option value="6">Cancelado</option>
                                    </select>
                                </td>
                            </tr>

                        </table>
                    </form>
                </td>

                <td>
                    Data de Locação 
                    Data prevista devoluçao 
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
            <%while(iteratorExemplares.hasNext()){
                Exemplar exemplar = (Exemplar) iteratorExemplares.next();
            %>
            <tr>
                <td style=""><%=exemplar.getTitulo().getObra()%></td>
                <td style=""><%=exemplar.getTitulo().getTipoDeObra()%></td>
                <td style=""><%=exemplar.getIdExe()%>-<%=exemplar.getTitulo().getIdTitu()%></td>
                <td style="">
                    <select>
                        <option value="1">Devolvido</option>
                        <option value="2">A devolver</option>
                        <option value="3">Cancelado</option>
                        <option value="4">Em Reserva</option>
                    </select>
                </td>
            </tr>
            <%}%>
        
        

        </tbody>
    </table>
    <table>
        <tbody>
            <tr>
               
        <form id="salvar" action="Emprestimo.do?acao=concluirEmprestimo" method="post">
            <input name="dataLocacao" id="dataLocacao" type="hidden" value="">
            <input name="dataPrevisaoDevolucao" id="dataPrevisaoDevolucao" type="hidden"  value="">
            <input name="statusEmprestimo" type="hidden" id="statusEmprestimo"  value="">
            <a onclick="salvar()"><button type="button" class="botaoX azul">Concluir</button></a>
        </form>
        
        </td>
        </tr>  
        </tbody>
    </table>
<%}%>

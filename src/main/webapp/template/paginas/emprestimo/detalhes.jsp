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
    String[] statusExemplares = new String[6];
    statusExemplares[0] = "Devolvido";
    statusExemplares[1] = "A devolver";
    statusExemplares[2] = "Cancelado";
    statusExemplares[3] = "Em Reserva";

    
                        
%>
<%if (mostrar) {%>
<div class="containerX">
    <form method="post" action="Emprestimo.do?acao=mudarStatusEmprestimo">
        <input type="hidden" id="IDEMP" name="IDEMP" value="<%=emprestimo.getIdEmp()%>">
        <table>
            <tbody>
                <tr>
                    <td>

                        <table>
                            <tr>
                                <td>
                                    <label>Mudar status do emprestimo </label>
                                    <select id="status" name="status" class="col-4">
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
                <%while (iteratorExemplares.hasNext()) {
                        Exemplar exemplar = (Exemplar) iteratorExemplares.next();
                %>
                <tr>
                    <td style=""><%=exemplar.getTitulo().getObra()%></td>
                    <td style=""><%=exemplar.getTitulo().getTipoDeObra()%></td>
                    <td style=""><%=exemplar.getIdExe()%>-<%=exemplar.getTitulo().getIdTitu()%></td>
                    <td style="">
                        <%
                          boolean apenasleitura = false;  
                        if(exemplar.getStatusDeEmprestimo().equals("Devolvido") || exemplar.getStatusDeEmprestimo().equals("Cancelado")) apenasleitura = true;
                        %>
                        <select name="statusExemplar"
                                <%if(apenasleitura)%> readonly="" <%;%>
                                >
                            <%for (int i = 0; i <= 3; i++) {
                                    if (statusExemplares[i].equals(exemplar.getStatusDeEmprestimo())) {
                            %>
                            <option value="<%=i + 1%>#<%=exemplar.getIdExe()%>" selected=""><%=exemplar.getStatusDeEmprestimo()%></option>        
                            <%} else {%>
                            <option value="<%=i + 1%>#<%=exemplar.getIdExe()%>"><%=exemplar.getStatusDeEmprestimo()%></option>    
                            <%}
                            }%>
                            <option value="1#<%=exemplar.getIdExe()%>">Devolvido</option>
                            <option value="2#<%=exemplar.getIdExe()%>">A devolver</option>
                            <option value="3#<%=exemplar.getIdExe()%>">Cancelado</option>
                            <option value="4#<%=exemplar.getIdExe()%>">Em Reserva</option>
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
                <div class="espaceembranco"></div>
                <button type="submit" class="botaoX azul">Concluir</button>
            </form>

            </td>
            </tr>  
            </tbody>
        </table>
    </form>
    <%}%>
    <div class="espaceembranco"></div>
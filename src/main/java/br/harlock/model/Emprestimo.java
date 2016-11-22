package br.harlock.model;

import java.util.Date;

public class Emprestimo {

    private int idEmp;

    private int fKFuncionario;

    private int fkUsu;

    private Date dataEmprestimo;

    private Date dataPrevDevolucao;

    private Date dataDevolucao;

    private Long valorMulta;

    private String situacao;

    private Boolean reserva;

    private Usuario Funcionario;

    private Usuario UsuarioDoSistema;

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public int getfKFuncionario() {
        return fKFuncionario;
    }

    public void setfKFuncionario(int fKFuncionario) {
        this.fKFuncionario = fKFuncionario;
    }

    public int getFkUsu() {
        return fkUsu;
    }

    public void setFkUsu(int fkUsu) {
        this.fkUsu = fkUsu;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataPrevDevolucao() {
        return dataPrevDevolucao;
    }

    public void setDataPrevDevolucao(Date dataPrevDevolucao) {
        this.dataPrevDevolucao = dataPrevDevolucao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Long getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Long valorMulta) {
        this.valorMulta = valorMulta;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Boolean getReserva() {
        return reserva;
    }

    public void setReserva(Boolean reserva) {
        this.reserva = reserva;
    }

    public Usuario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Usuario Funcionario) {
        this.Funcionario = Funcionario;
    }

    public Usuario getUsuarioDoSistema() {
        return UsuarioDoSistema;
    }

    public void setUsuarioDoSistema(Usuario UsuarioDoSistema) {
        this.UsuarioDoSistema = UsuarioDoSistema;
    }

    
}

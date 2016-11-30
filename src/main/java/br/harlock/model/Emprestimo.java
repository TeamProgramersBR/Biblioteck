package br.harlock.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    
    private  boolean locado;
    public Emprestimo() {
    }

    
    public Emprestimo(int idEmp, int fKFuncionario, int fkUsu, String dataEmprestimo, String dataPrevDevolucao, String dataDevolucao, Long valorMulta, String situacao, Boolean reserva) throws ParseException {
        this.idEmp=idEmp;
        this.fKFuncionario = fKFuncionario;
        this.fkUsu = fkUsu;
        setDataEmprestimo(dataEmprestimo);
        setDataPrevDevolucao(dataPrevDevolucao);
        setDataDevolucao(dataDevolucao);
        this.valorMulta = valorMulta;
        this.situacao = situacao;
        this.reserva = reserva;
    }
    
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

    public void setDataEmprestimo(String dataEmprestimo) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dataEmprestimo);
        this.dataEmprestimo = date;
    }

    public Date getDataPrevDevolucao() {
        return dataPrevDevolucao;
    }

    public void setDataPrevDevolucao(String dataPrevDevolucao) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dataPrevDevolucao);
        this.dataPrevDevolucao = date;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dataDevolucao);
        this.dataDevolucao = date;
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

    public boolean isLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }

    
}

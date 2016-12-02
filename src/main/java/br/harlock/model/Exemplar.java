package br.harlock.model;

public class Exemplar {
    private String statusDeEmprestimo;
    private int idExe;

    private int fkTitulo;
    
    private int fkEmprestimo;
    
    private Boolean liberadoParaEmprestimo;

    private String duracao;

    private String quantidadePaginas;

    private Titulo titulo;

    public Exemplar() {
    }

    public Exemplar(int idExe, int fkTitulo, Boolean liberadoParaEmprestimo, String duracao, String quantidadePaginas) {
        this.idExe = idExe;
        this.fkTitulo = fkTitulo;
        this.liberadoParaEmprestimo = liberadoParaEmprestimo;
        this.duracao = duracao;
        this.quantidadePaginas = quantidadePaginas;
    }

    

    public int getIdExe() {
        return idExe;
    }

    public void setIdExe(int idExe) {
        this.idExe = idExe;
    }

    public int getFkTitulo() {
        return fkTitulo;
    }

    public void setFkTitulo(int fkTitulo) {
        this.fkTitulo = fkTitulo;
    }

    public Boolean getLiberadoParaEmprestimo() {
        return liberadoParaEmprestimo;
    }

    public void setLiberadoParaEmprestimo(Boolean liberadoParaEmprestimo) {
        this.liberadoParaEmprestimo = liberadoParaEmprestimo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(String quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public String getStatusDeEmprestimo() {
        return statusDeEmprestimo;
    }

    public void setStatusDeEmprestimo(String statusDeEmprestimo) {
        this.statusDeEmprestimo = statusDeEmprestimo;
    }

    public int getFkEmprestimo() {
        return fkEmprestimo;
    }

    public void setFkEmprestimo(int fkEmprestimo) {
        this.fkEmprestimo = fkEmprestimo;
    }
    
    
    
}

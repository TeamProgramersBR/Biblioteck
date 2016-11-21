package br.harlock.bll;

public class Exemplar {

    private int idExe;

    private int fkTitulo;

    private String isbn;

    private Boolean liberadoParaEmprestimo;

    private String duracao;

    private String quantidadePaginas;

    private Titulo titulo;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    
}

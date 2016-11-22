package br.harlock.model;

public class TituloTEMAutor {

    private int tituloidTitulo;

    private int autoridAutor;

    private String tipoDeAutor;

    private Autor autor;

    private Titulo titulo;

    public int getTituloidTitulo() {
        return tituloidTitulo;
    }

    public void setTituloidTitulo(int tituloidTitulo) {
        this.tituloidTitulo = tituloidTitulo;
    }

    public int getAutoridAutor() {
        return autoridAutor;
    }

    public void setAutoridAutor(int autoridAutor) {
        this.autoridAutor = autoridAutor;
    }

    public String getTipoDeAutor() {
        return tipoDeAutor;
    }

    public void setTipoDeAutor(String tipoDeAutor) {
        this.tipoDeAutor = tipoDeAutor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    
}

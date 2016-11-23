package br.harlock.model;

import java.util.List;

public class Autor {

    private Integer idAutor;

    private String nome;

    private String nomeFantasia;

    private String nacionalidade;

    private List<TituloTEMAutor> tituloTEMAutorCollection;

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<TituloTEMAutor> getTituloTEMAutorCollection() {
        return tituloTEMAutorCollection;
    }

    public void setTituloTEMAutorCollection(List<TituloTEMAutor> tituloTEMAutorCollection) {
        this.tituloTEMAutorCollection = tituloTEMAutorCollection;
    }

   
}

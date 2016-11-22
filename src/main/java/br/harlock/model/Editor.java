package br.harlock.model;

import java.util.List;

public class Editor {

    private Integer idEditor;

    private String nome;

    private String nacionalidade;

    private List<TitulohasEditor> titulohasEditorCollection;

    public Integer getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(Integer idEditor) {
        this.idEditor = idEditor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<TitulohasEditor> getTitulohasEditorCollection() {
        return titulohasEditorCollection;
    }

    public void setTitulohasEditorCollection(List<TitulohasEditor> titulohasEditorCollection) {
        this.titulohasEditorCollection = titulohasEditorCollection;
    }

    
}

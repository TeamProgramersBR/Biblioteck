package br.harlock.model;

import java.util.List;

public class Categoriaitemacervo {

    private Integer idCat;

    private String nomeCategoria;

    private String descricao;

    private List<Titulo> tituloCollection;

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Titulo> getTituloCollection() {
        return tituloCollection;
    }

    public void setTituloCollection(List<Titulo> tituloCollection) {
        this.tituloCollection = tituloCollection;
    }

    
}

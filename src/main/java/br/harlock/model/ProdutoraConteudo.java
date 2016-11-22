package br.harlock.model;

import java.util.List;

public class ProdutoraConteudo {

    private Integer idPdc;

    private String nomeProdutora;

    private String descricao;

    private String cnpj;

    private List<Titulo> tituloCollection;

    public Integer getIdPdc() {
        return idPdc;
    }

    public void setIdPdc(Integer idPdc) {
        this.idPdc = idPdc;
    }

    public String getNomeProdutora() {
        return nomeProdutora;
    }

    public void setNomeProdutora(String nomeProdutora) {
        this.nomeProdutora = nomeProdutora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Titulo> getTituloCollection() {
        return tituloCollection;
    }

    public void setTituloCollection(List<Titulo> tituloCollection) {
        this.tituloCollection = tituloCollection;
    }

    
}

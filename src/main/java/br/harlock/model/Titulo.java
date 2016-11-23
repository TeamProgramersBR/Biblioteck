package br.harlock.model;

import java.util.Date;
import java.util.List;

public class Titulo {

    private int idTitu;

    private int fkItemAcervo;

    private int fkItemPdc;

    private String isbn;

    private String issn;

    private String obra;

    private String descricao;

    private Date dataDePublicacao;

    private String cidadePublicacao;

    private String estadoPublicacao;

    private String edicao;

    private String idioma;

    private String traducao;

    private String capa;

    private Categoriaitemacervo categoriaitemacervo;

    private ProdutoraConteudo produtoraConteudo;

    private List<Exemplar> exemplarCollection;

    private List<TitulohasEditor> titulohasEditorCollection;

    private List<TituloTEMAutor> tituloTEMAutorCollection;

    public int getIdTitu() {
        return idTitu;
    }

    public void setIdTitu(int idTitu) {
        this.idTitu = idTitu;
    }

    public int getFkItemAcervo() {
        return fkItemAcervo;
    }

    public void setFkItemAcervo(int fkItemAcervo) {
        this.fkItemAcervo = fkItemAcervo;
    }

    public int getFkItemPdc() {
        return fkItemPdc;
    }

    public void setFkItemPdc(int fkItemPdc) {
        this.fkItemPdc = fkItemPdc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(Date dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public String getCidadePublicacao() {
        return cidadePublicacao;
    }

    public void setCidadePublicacao(String cidadePublicacao) {
        this.cidadePublicacao = cidadePublicacao;
    }

    public String getEstadoPublicacao() {
        return estadoPublicacao;
    }

    public void setEstadoPublicacao(String estadoPublicacao) {
        this.estadoPublicacao = estadoPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTraducao() {
        return traducao;
    }

    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public Categoriaitemacervo getCategoriaitemacervo() {
        return categoriaitemacervo;
    }

    public void setCategoriaitemacervo(Categoriaitemacervo categoriaitemacervo) {
        this.categoriaitemacervo = categoriaitemacervo;
    }

    public ProdutoraConteudo getProdutoraConteudo() {
        return produtoraConteudo;
    }

    public void setProdutoraConteudo(ProdutoraConteudo produtoraConteudo) {
        this.produtoraConteudo = produtoraConteudo;
    }

    public List<Exemplar> getExemplarCollection() {
        return exemplarCollection;
    }

    public void setExemplarCollection(List<Exemplar> exemplarCollection) {
        this.exemplarCollection = exemplarCollection;
    }

    public List<TitulohasEditor> getTitulohasEditorCollection() {
        return titulohasEditorCollection;
    }

    public void setTitulohasEditorCollection(List<TitulohasEditor> titulohasEditorCollection) {
        this.titulohasEditorCollection = titulohasEditorCollection;
    }

    public List<TituloTEMAutor> getTituloTEMAutorCollection() {
        return tituloTEMAutorCollection;
    }

    public void setTituloTEMAutorCollection(List<TituloTEMAutor> tituloTEMAutorCollection) {
        this.tituloTEMAutorCollection = tituloTEMAutorCollection;
    }

    
}

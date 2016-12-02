package br.harlock.model;

import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private Blob capa;
    private String volume;
    private String tipoDeObra;
    private float  duracao ;
    private float quantidadePaginas;
    
    private Categoriaitemacervo categoriaitemacervo;

    private ProdutoraConteudo produtoraConteudo;

    private List<Exemplar> exemplarCollection;

    private List<TitulohasEditor> titulohasEditorCollection;

    private List<TituloTEMAutor> tituloTEMAutorCollection;
        
    public Titulo(String empty) throws ParseException{
        this.idTitu = 0;
        this.fkItemAcervo = 0;
        this.fkItemPdc = 0;
        this.isbn = " ";
        this.issn = " ";
        this.obra = " ";
        this.descricao = " ";
        setDataDePublicacao("1900-01-01");
        this.cidadePublicacao = " ";
        this.estadoPublicacao = " ";
        this.edicao = " ";
        this.idioma = " ";
        this.traducao = " ";
        this.capa = null;
        this.quantidadePaginas = 0;
        this.duracao = 0;
        setVolume(" ");
        setTipoDeObra(" ");
    }
    public Titulo() {
    }

    public Titulo(int idTitu, int fkItemAcervo, int fkItemPdc, String isbn, String issn, String obra, String descricao, Date dataDePublicacao, String cidadePublicacao, String estadoPublicacao, String edicao, String idioma, String traducao, Blob capa) {
        this.idTitu = idTitu;
        this.fkItemAcervo = fkItemAcervo;
        this.fkItemPdc = fkItemPdc;
        this.isbn = isbn;
        this.issn = issn;
        this.obra = obra;
        this.descricao = descricao;
        this.dataDePublicacao = dataDePublicacao;
        this.cidadePublicacao = cidadePublicacao;
        this.estadoPublicacao = estadoPublicacao;
        this.edicao = edicao;
        this.idioma = idioma;
        this.traducao = traducao;
        this.capa = capa;
        
    }

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
    
    public void setDataDePublicacao(String dataDePublicacao) throws ParseException {
       try{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dataDePublicacao);
        this.dataDePublicacao = date;
        }catch(Exception e){
            e.printStackTrace();
        }
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

    public Blob getCapa() {
        return capa;
    }

    public void setCapa(Blob capa) {
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

    public String getTipoDeObra() {
        return tipoDeObra;
    }

    public void setTipoDeObra(String tipoDeObra) {
        this.tipoDeObra = tipoDeObra;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public float getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(float quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    
    
    
}

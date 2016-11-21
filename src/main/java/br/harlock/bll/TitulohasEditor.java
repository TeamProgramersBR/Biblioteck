package br.harlock.bll;

public class TitulohasEditor {

    private int tituloIDTITU;

    private int editorIDEDITOR;

    private String tipoDeEditor;

    private Editor editor;

    private Titulo titulo;

    public int getTituloIDTITU() {
        return tituloIDTITU;
    }

    public void setTituloIDTITU(int tituloIDTITU) {
        this.tituloIDTITU = tituloIDTITU;
    }

    public int getEditorIDEDITOR() {
        return editorIDEDITOR;
    }

    public void setEditorIDEDITOR(int editorIDEDITOR) {
        this.editorIDEDITOR = editorIDEDITOR;
    }

    public String getTipoDeEditor() {
        return tipoDeEditor;
    }

    public void setTipoDeEditor(String tipoDeEditor) {
        this.tipoDeEditor = tipoDeEditor;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

   
}

package br.harlock.model;

import java.util.List;

public class Usuario {

    private int idUsu;

    private String nivelDeAcesso;

    private String nome;

    private String cpf;

    private String email;

    private String numeroResidencial;

    private String numeroCelular;

    private String numeroComercial;

    private String matriculaEducacional;

    private String senha;

    private String enderecoLogadouro;

    private String enderecoCEP;

    private String enderecoCidade;

    private String enderecoEstado;

    private String enderecoPais;

    private String statusDoUsuario;

    private List<Emprestimo> emprestimoCollection;

    private List<Emprestimo> emprestimoCollection1;

    public Usuario() {
    }

    public Usuario(int idUsu, String nivelDeAcesso, String nome, String cpf, String email, String numeroResidencial, String numeroCelular, String numeroComercial, String matriculaEducacional, String senha, String enderecoLogadouro, String enderecoCEP, String enderecoCidade, String enderecoEstado, String enderecoPais, String statusDoUsuario) {
        this.idUsu = idUsu;
        this.nivelDeAcesso = nivelDeAcesso;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.numeroResidencial = numeroResidencial;
        this.numeroCelular = numeroCelular;
        this.numeroComercial = numeroComercial;
        this.matriculaEducacional = matriculaEducacional;
        this.senha = senha;
        this.enderecoLogadouro = enderecoLogadouro;
        this.enderecoCEP = enderecoCEP;
        this.enderecoCidade = enderecoCidade;
        this.enderecoEstado = enderecoEstado;
        this.enderecoPais = enderecoPais;
        this.statusDoUsuario = statusDoUsuario;
    }

    

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroResidencial() {
        return numeroResidencial;
    }

    public void setNumeroResidencial(String numeroResidencial) {
        this.numeroResidencial = numeroResidencial;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroComercial() {
        return numeroComercial;
    }

    public void setNumeroComercial(String numeroComercial) {
        this.numeroComercial = numeroComercial;
    }

    public String getMatriculaEducacional() {
        return matriculaEducacional;
    }

    public void setMatriculaEducacional(String matriculaEducacional) {
        this.matriculaEducacional = matriculaEducacional;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEnderecoLogadouro() {
        return enderecoLogadouro;
    }

    public void setEnderecoLogadouro(String enderecoLogadouro) {
        this.enderecoLogadouro = enderecoLogadouro;
    }

    public String getEnderecoCEP() {
        return enderecoCEP;
    }

    public void setEnderecoCEP(String enderecoCEP) {
        this.enderecoCEP = enderecoCEP;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    public String getEnderecoPais() {
        return enderecoPais;
    }

    public void setEnderecoPais(String enderecoPais) {
        this.enderecoPais = enderecoPais;
    }

    public String getStatusDoUsuario() {
        return statusDoUsuario;
    }

    public void setStatusDoUsuario(String statusDoUsuario) {
        this.statusDoUsuario = statusDoUsuario;
    }

    public List<Emprestimo> getEmprestimoCollection() {
        return emprestimoCollection;
    }

    public void setEmprestimoCollection(List<Emprestimo> emprestimoCollection) {
        this.emprestimoCollection = emprestimoCollection;
    }

    public List<Emprestimo> getEmprestimoCollection1() {
        return emprestimoCollection1;
    }

    public void setEmprestimoCollection1(List<Emprestimo> emprestimoCollection1) {
        this.emprestimoCollection1 = emprestimoCollection1;
    }

    
}

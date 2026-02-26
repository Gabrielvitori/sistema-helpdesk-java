package model;

public class Chamado {

    private String nomePc;
    private String problema;
    private String descricao;

    public Chamado() {
    }

    public Chamado(String nomePc, String problema, String descricao) {
        this.nomePc = nomePc;
        this.problema = problema;
        this.descricao = descricao;
    }

    public String getNomePc() {
        return nomePc;
    }

    public void setNomePc(String nomePc) {
        this.nomePc = nomePc;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
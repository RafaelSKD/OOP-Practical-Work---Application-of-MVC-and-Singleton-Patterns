package CESAE_Resort.Models;

public class Tipologia {
    private int idTipologia;    // id da tipologia        ex: 3 (1- Quarto Single, 2 - Quarto Duplo, 3 - Suite Programador)
    private String descricao;   // descricao da tipologia ex: Suite Programador
    private double preco;       // preco por semana       ex: 1200

    public Tipologia(int idTipologia, String descricao, double preco) {
        this.idTipologia = idTipologia;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getIdTipologia() {
        return idTipologia;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}

package CESAE_Resort.Models;

/**
 * Classe que representa a tipologia de um quarto, definindo
 * o tipo, descrição e preço semanal associado.
 */
public class Tipologia {
    private int idTipologia;    // ID único da tipologia, ex: 1 - Single, 2 - Duplo, 3 - Suite Programador
    private String descricao;   // Descrição da tipologia, ex: Suite Programador
    private double preco;       // Preço por semana para esta tipologia, ex: 1200

    /**
     * Construtor da Tipologia.
     *
     * @param idTipologia ID da tipologia do quarto.
     * @param descricao Descrição do tipo de quarto.
     * @param preco Preço semanal associado a esta tipologia.
     */
    public Tipologia(int idTipologia, String descricao, double preco) {
        this.idTipologia = idTipologia;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * @return o ID da tipologia.
     */
    public int getIdTipologia() {
        return idTipologia;
    }

    /**
     * @return a descrição da tipologia.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return o preço por semana da tipologia.
     */
    public double getPreco() {
        return preco;
    }
}

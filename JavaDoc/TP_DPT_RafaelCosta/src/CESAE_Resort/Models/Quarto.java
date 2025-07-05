package CESAE_Resort.Models;

/**
 * Classe que representa um quarto do resort.
 * Herda as características de uma tipologia (id, descrição, preço) e
 * adiciona o número específico do quarto.
 */
public class Quarto extends Tipologia {
    private int numQuarto; // Número único do quarto, ex: 101

    /**
     * Construtor do quarto.
     *
     * @param idTipologia ID da tipologia do quarto (relacionado ao tipo).
     * @param descricao Descrição da tipologia.
     * @param preco Preço por semana do quarto.
     * @param numQuarto Número específico do quarto no resort.
     */
    public Quarto(int idTipologia, String descricao, double preco, int numQuarto) {
        super(idTipologia, descricao, preco); // chama o construtor da superclasse Tipologia
        this.numQuarto = numQuarto;
    }

    /**
     * @return o número do quarto.
     */
    public int getNumQuarto() {
        return numQuarto;
    }
}

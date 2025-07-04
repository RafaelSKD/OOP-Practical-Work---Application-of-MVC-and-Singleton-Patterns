package CESAE_Resort.Models;

// subclasse de tipologia
public class Quarto extends Tipologia{
    private int numQuarto;      // numero do quarto   ex: 101

    // Construtor
    public Quarto(int idTipologia, String descricao, double preco, int numQuarto) {
        super(idTipologia, descricao, preco);
        this.numQuarto = numQuarto;
    }

    // Getters
    public int getNumQuarto() {
        return numQuarto;
    }
}

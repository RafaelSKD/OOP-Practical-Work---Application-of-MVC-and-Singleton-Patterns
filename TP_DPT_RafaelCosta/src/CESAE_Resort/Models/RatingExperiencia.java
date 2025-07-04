package CESAE_Resort.Models;


public class RatingExperiencia {
    private String idRating;       // Id do rating                ex: T001
    private String idExperiencia;  // Id da experiência avaliada  ex: E04
    private int ratingExperiencia; // Rating da experiência       ex: 5 (de 1 a 5)
    private int ratingGuia;        // Rating do guia              ex: 4 (de 1 a 5)

    // Construtor da classe RatingExperiencia
    public RatingExperiencia(String idRating, String idExperiencia, int ratingExperiencia, int ratingGuia) {
        this.idRating = idRating;
        this.idExperiencia = idExperiencia;
        this.ratingExperiencia = ratingExperiencia;
        this.ratingGuia = ratingGuia;
    }

    // Getters
    public String getIdRating() {
        return idRating;
    }

    public String getIdExperiencia() {
        return idExperiencia;
    }

    public int getRatingExperiencia() {
        return ratingExperiencia;
    }

    public int getRatingGuia() {
        return ratingGuia;
    }
}

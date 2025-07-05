package CESAE_Resort.Models;

/**
 * Classe que representa o rating de uma experiência e do guia
 * associado, fornecendo a avaliação tanto para a experiência quanto
 * para o guia que liderou a experiência.
 */
public class RatingExperiencia {
    private String idRating;       // ID único do rating, ex: T001
    private String idExperiencia;  // ID da experiência avaliada, ex: E04
    private int ratingExperiencia; // Rating da experiência (de 1 a 5), ex: 5
    private int ratingGuia;        // Rating do guia (de 1 a 5), ex: 4

    /**
     * Construtor da classe RatingExperiencia.
     *
     * @param idRating ID do rating.
     * @param idExperiencia ID da experiência avaliada.
     * @param ratingExperiencia Rating atribuído à experiência (de 1 a 5).
     * @param ratingGuia Rating atribuído ao guia (de 1 a 5).
     */
    public RatingExperiencia(String idRating, String idExperiencia, int ratingExperiencia, int ratingGuia) {
        this.idRating = idRating;
        this.idExperiencia = idExperiencia;
        this.ratingExperiencia = ratingExperiencia;
        this.ratingGuia = ratingGuia;
    }

    /**
     * @return ID do rating.
     */
    public String getIdRating() {
        return idRating;
    }

    /**
     * @return ID da experiência.
     */
    public String getIdExperiencia() {
        return idExperiencia;
    }

    /**
     * @return Rating da experiência (de 1 a 5).
     */
    public int getRatingExperiencia() {
        return ratingExperiencia;
    }

    /**
     * @return Rating do guia (de 1 a 5).
     */
    public int getRatingGuia() {
        return ratingGuia;
    }
}

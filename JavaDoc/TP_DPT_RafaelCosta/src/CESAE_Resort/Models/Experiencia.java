package CESAE_Resort.Models;

/**
 * Classe que representa uma experiência disponível no resort,
 * incluindo informações como nome, guia responsável e preços
 * para adultos e crianças.
 */
public class Experiencia {
    private String idExperiencia; // ID único da experiência, ex: E01
    private String nome;          // Nome da experiência, ex: Intro to Python
    private String idGuia;        // ID do guia que lidera a experiência, ex: EG01
    private double precoAdulto;   // Preço por adulto
    private double precoCrianca;  // Preço por criança

    /**
     * Construtor da experiência.
     *
     * @param idExperiencia ID único da experiência.
     * @param nome Nome da experiência.
     * @param idGuia ID do guia responsável.
     * @param precoAdulto Preço do bilhete para adultos.
     * @param precoCrianca Preço do bilhete para crianças.
     */
    public Experiencia(String idExperiencia, String nome, String idGuia, double precoAdulto, double precoCrianca) {
        this.idExperiencia = idExperiencia;
        this.nome = nome;
        this.idGuia = idGuia;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
    }

    /**
     * @return o ID da experiência.
     */
    public String getIdExperiencia() {
        return idExperiencia;
    }

    /**
     * @return o nome da experiência.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return o ID do guia responsável pela experiência.
     */
    public String getIdGuia() {
        return idGuia;
    }

    /**
     * @return o preço do bilhete para adultos.
     */
    public double getPrecoAdulto() {
        return precoAdulto;
    }

    /**
     * @return o preço do bilhete para crianças.
     */
    public double getPrecoCrianca() {
        return precoCrianca;
    }
}

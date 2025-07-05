package CESAE_Resort.Models;

/**
 * Classe que representa um guia do resort,
 * responsável por liderar experiências.
 */
public class Guia {
    private String idGuia;        // ID único do guia, ex: G01
    private String nome;          // Nome do guia, ex: Alice Code
    private String nacionalidade; // Nacionalidade do guia, ex: PT
    private String email;         // Email de contato, ex: alice@resort.com
    private String telemovel;     // Número de telemóvel, ex: 912345678

    /**
     * Construtor do guia.
     *
     * @param idGuia ID único do guia.
     * @param nome Nome do guia.
     * @param nacionalidade Nacionalidade do guia.
     * @param email Email do guia.
     * @param telemovel Número de telemóvel do guia.
     */
    public Guia(String idGuia, String nome, String nacionalidade, String email, String telemovel) {
        this.idGuia = idGuia;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telemovel = telemovel;
    }

    /**
     * @return o ID do guia.
     */
    public String getIdGuia() {
        return idGuia;
    }

    /**
     * @return o nome do guia.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return a nacionalidade do guia.
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @return o email do guia.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return o número de telemóvel do guia.
     */
    public String getTelemovel() {
        return telemovel;
    }
}

package CESAE_Resort.Models;

/**
 * Representa um cliente do CESAE Resort.
 * Esta classe guarda toda a informação relevante sobre um cliente,
 * incluindo dados pessoais e consentimento de marketing.
 */
public class Cliente {
    private String idCliente;         // ID único do cliente (ex: C009)
    private String nome;              // Nome do cliente (ex: Cliente 9)
    private String nacionalidade;     // Nacionalidade do cliente (ex: PT)
    private String email;             // Email do cliente (ex: cliente9@exemplo.com)
    private String telemovel;         // Número de telemóvel do cliente (ex: 998753260)
    private String dataNascimento;    // Data de nascimento do cliente (ex: 1969-05-03)
    private boolean consentimentoMarketing;  // Indica se o cliente aceitou receber marketing (true/false)

    /**
     * Construtor para criar um novo cliente com todas as informações obrigatórias.
     *
     * @param idCliente ID único do cliente
     * @param nome Nome completo do cliente
     * @param nacionalidade Nacionalidade do cliente
     * @param email Email do cliente
     * @param telemovel Número de telemóvel do cliente
     * @param dataNascimento Data de nascimento do cliente (formato YYYY-MM-DD)
     * @param consentimentoMarketing True se o cliente aceitou marketing, False caso contrário
     */
    public Cliente(String idCliente, String nome, String nacionalidade, String email, String telemovel, String dataNascimento, boolean consentimentoMarketing) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telemovel = telemovel;
        this.dataNascimento = dataNascimento;
        this.consentimentoMarketing = consentimentoMarketing;
    }

    // ===== Getters =====

    /**
     * @return o ID único do cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @return o nome completo do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return a nacionalidade do cliente.
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @return o email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return o número de telemóvel do cliente.
     */
    public String getTelemovel() {
        return telemovel;
    }

    /**
     * @return a data de nascimento do cliente.
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @return true se o cliente consentiu receber marketing, false caso contrário.
     */
    public boolean isConsentimentoMarketing() {
        return consentimentoMarketing;
    }
}

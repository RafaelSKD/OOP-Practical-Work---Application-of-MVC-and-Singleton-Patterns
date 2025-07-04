package CESAE_Resort.Models;

// Classe para clientes

public class Cliente {
    private String idCliente;         // id unico de cliente ex: C009
    private String nome;              // nome do cliente     ex: Cliente 9
    private String nacionalidade;     // nacionalidade       ex: PT
    private String email;             // email               ex: cliente9@exemplo.com
    private String telemovel;         // numero de telemovel ex: 998753260
    private String dataNascimento;    // data de nascimento  ex: 1969-05-03
    private boolean consentimentoMarketing;  // Se aceitou   ex: True

    // Construtor
    public Cliente(String idCliente, String nome, String nacionalidade, String email, String telemovel, String dataNascimento, boolean consentimentoMarketing) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telemovel = telemovel;
        this.dataNascimento = dataNascimento;
        this.consentimentoMarketing = consentimentoMarketing;
    }

    // Getters
    public String getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getEmail() {
        return email;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public boolean isConsentimentoMarketing() {
        return consentimentoMarketing;
    }
}

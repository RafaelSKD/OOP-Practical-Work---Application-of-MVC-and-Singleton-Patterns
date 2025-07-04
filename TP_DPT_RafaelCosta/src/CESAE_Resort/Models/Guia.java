package CESAE_Resort.Models;

// Classe para os Guias das experiencias
public class Guia {
    private String idGuia;            // id unico de Guia    ex: G01
    private String nome;              // nome do Guia        ex: Alice Code
    private String nacionalidade;     // nacionalidade       ex: PT
    private String email;             // email               ex: alice@resort.com
    private String telemovel;         // numero de telemovel ex: 912345678


    // Construtor
    public Guia(String idGuia, String nome, String nacionalidade, String email, String telemovel) {
        this.idGuia = idGuia;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telemovel = telemovel;
    }

    // Getters
    public String getIdGuia() {
        return idGuia;
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
}

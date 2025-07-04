package CESAE_Resort.Models;


// Classe para experiencia
public class Experiencia {
    private String idExperiencia;     // id unico da experiencia                     ex: E01
    private String nome;              // nome da experiencia                         ex: Intro to Python
    private String idGuia;            // id unico do guia que comanda a experiencia  ex: EG01
    private double precoAdulto;       // preco por adulto                            ex: 50
    private double precoCrianca;      // preco por crianca                           ex: 30

    // Construtor
    public Experiencia(String idExperiencia, String nome, String idGuia, double precoAdulto, double precoCrianca) {
        this.idExperiencia = idExperiencia;
        this.nome = nome;
        this.idGuia = idGuia;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
    }

    // Getters
    public String getIdExperiencia() {
        return idExperiencia;
    }

    public String getNome() {
        return nome;
    }

    public String getIdGuia() {
        return idGuia;
    }

    public double getPrecoAdulto() {
        return precoAdulto;
    }

    public double getPrecoCrianca() {
        return precoCrianca;
    }
}

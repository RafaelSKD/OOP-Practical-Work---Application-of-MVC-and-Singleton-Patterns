package CESAE_Resort.Models;

//id,num_quarto,id_cliente,ano,mes,semana
public class Reserva {
    private String idReserva;  // Id da reserva              ex: R0001
    private int numQuarto;     // Número do quarto reservado ex: 109
    private String idCliente;  // Id do cliente              ex: C006
    private int ano;           // Ano da reserva             ex: 2025
    private int mes;           // Mês da reserva             ex: 5 (maio)
    private int semana;        // Semana da reserva          ex: 5 (quinta semana do mês)

    // Construtor da classe Reserva
    public Reserva(String idReserva, int numQuarto, String idCliente, int ano, int mes, int semana) {
        this.idReserva = idReserva;
        this.numQuarto = numQuarto;
        this.idCliente = idCliente;
        this.ano = ano;
        this.mes = mes;
        this.semana = semana;
    }

    // Getters
    public String getIdReserva() {
        return idReserva;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getSemana() {
        return semana;
    }
}

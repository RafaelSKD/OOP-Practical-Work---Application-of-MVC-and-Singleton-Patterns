package CESAE_Resort.Models;

/**
 * Classe que representa uma reserva feita por um cliente em um quarto
 * do resort. Contém informações como o número do quarto reservado, o
 * cliente que fez a reserva, e a data em que a reserva foi realizada.
 */
public class Reserva {
    private String idReserva;  // ID único da reserva, ex: R0001
    private int numQuarto;     // Número do quarto reservado, ex: 109
    private String idCliente;  // ID único do cliente que fez a reserva, ex: C006
    private int ano;           // Ano da reserva, ex: 2025
    private int mes;           // Mês da reserva, ex: 5 (maio)
    private int semana;        // Semana da reserva (número da semana no mês), ex: 5

    /**
     * Construtor da classe Reserva.
     *
     * Inicializa uma nova reserva com as informações fornecidas.
     *
     * @param idReserva ID único da reserva.
     * @param numQuarto Número do quarto reservado.
     * @param idCliente ID do cliente que fez a reserva.
     * @param ano Ano da reserva.
     * @param mes Mês da reserva.
     * @param semana Semana da reserva.
     */
    public Reserva(String idReserva, int numQuarto, String idCliente, int ano, int mes, int semana) {
        this.idReserva = idReserva;
        this.numQuarto = numQuarto;
        this.idCliente = idCliente;
        this.ano = ano;
        this.mes = mes;
        this.semana = semana;
    }

    /**
     * @return ID da reserva.
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * @return Número do quarto reservado.
     */
    public int getNumQuarto() {
        return numQuarto;
    }

    /**
     * @return ID do cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @return Ano da reserva.
     */
    public int getAno() {
        return ano;
    }

    /**
     * @return Mês da reserva.
     */
    public int getMes() {
        return mes;
    }

    /**
     * @return Semana da reserva.
     */
    public int getSemana() {
        return semana;
    }
}

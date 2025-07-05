package CESAE_Resort.Models;

import java.time.LocalDate;

/**
 * Classe que representa a data atual, obtendo automaticamente o ano, mês,
 * dia e semana do mês no momento da criação do objeto.
 */
public class Data {
    private int ano;     // Ano atual
    private int mes;     // Mês atual (1-12)
    private int semana;  // Semana do mês atual (1-5)
    private int dia;     // Dia do mês atual (1-31)

    /**
     * Construtor que inicializa a data com os valores do sistema.
     * Calcula automaticamente a semana do mês com base no dia atual.
     */
    public Data() {
        LocalDate dataAtual = LocalDate.now(); // Obter a data atual do sistema
        this.ano = dataAtual.getYear();
        this.mes = dataAtual.getMonthValue();
        this.dia = dataAtual.getDayOfMonth();
        // Calcular semana do mês: dias 1-7 -> semana 1, 8-14 -> semana 2, etc.
        this.semana = ((dataAtual.getDayOfMonth() - 1) / 7) + 1;
    }

    /**
     * @return o ano atual.
     */
    public int getAno() {
        return ano;
    }

    /**
     * @return o mês atual (1 a 12).
     */
    public int getMes() {
        return mes;
    }

    /**
     * @return a semana do mês atual (1 a 5).
     */
    public int getSemana() {
        return semana;
    }

    /**
     * @return o dia do mês atual (1 a 31).
     */
    public int getDia() {
        return dia;
    }
}

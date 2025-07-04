package CESAE_Resort.Models;


public class VendaExperiencia {
    private String idVenda;               // Id da venda de experiência                ex: V0001
    private String idExperiencia;         // Id da experiência vendida                 ex: E04
    private String tipoCliente;           // Tipo de cliente                           ex: crianca (crianca, adulto)
    private int ano;                      // Ano da venda                              ex: 2025
    private int mes;                      // Mês da venda                              ex: 4 (abril)

    // Construtor da classe VendaExperiencia
    public VendaExperiencia(String idVenda, String idExperiencia, String tipoCliente, int ano, int mes) {
        this.idVenda = idVenda;
        this.idExperiencia = idExperiencia;
        this.tipoCliente = tipoCliente;
        this.ano = ano;
        this.mes = mes;
    }

    // Getters
    public String getIdVenda() {
        return idVenda;
    }

    public String getIdExperiencia() {
        return idExperiencia;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }
}

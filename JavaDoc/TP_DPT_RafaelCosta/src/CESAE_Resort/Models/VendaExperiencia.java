package CESAE_Resort.Models;

/**
 * Classe que representa uma venda de experiência no sistema.
 * Cada venda é associada a uma experiência específica e contém informações
 * sobre o tipo de cliente (adulto ou criança), além da data da venda.
 */
public class VendaExperiencia {
    private String idVenda;               // Id da venda de experiência                ex: V0001
    private String idExperiencia;         // Id da experiência vendida                 ex: E04
    private String tipoCliente;           // Tipo de cliente                           ex: crianca (crianca, adulto)
    private int ano;                      // Ano da venda                              ex: 2025
    private int mes;                      // Mês da venda                              ex: 4 (abril)

    /**
     * Construtor da classe VendaExperiencia.
     *
     * Inicializa uma nova venda com os parâmetros fornecidos.
     *
     * @param idVenda Id da venda de experiência (ex: V0001).
     * @param idExperiencia Id da experiência vendida (ex: E04).
     * @param tipoCliente Tipo de cliente (ex: "crianca" ou "adulto").
     * @param ano Ano da venda (ex: 2025).
     * @param mes Mês da venda (ex: 4 para abril).
     */
    public VendaExperiencia(String idVenda, String idExperiencia, String tipoCliente, int ano, int mes) {
        this.idVenda = idVenda;
        this.idExperiencia = idExperiencia;
        this.tipoCliente = tipoCliente;
        this.ano = ano;
        this.mes = mes;
    }

    /**
     * @return ID da venda de experiência.
     */
    public String getIdVenda() {
        return idVenda;
    }

    /**
     * @return ID da experiência vendida.
     */
    public String getIdExperiencia() {
        return idExperiencia;
    }

    /**
     * @return Tipo de cliente (ex: "adulto" ou "crianca").
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * @return Ano da venda (ex: 2025).
     */
    public int getAno() {
        return ano;
    }

    /**
     * @return Mês da venda (ex: 4 para abril).
     */
    public int getMes() {
        return mes;
    }
}

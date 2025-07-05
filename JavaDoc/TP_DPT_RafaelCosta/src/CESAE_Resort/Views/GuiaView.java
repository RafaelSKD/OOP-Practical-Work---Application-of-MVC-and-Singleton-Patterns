package CESAE_Resort.Views;

import CESAE_Resort.Controllers.GuiaController;
import java.util.Scanner;

import static CESAE_Resort.Controllers.GuiaController.*;
import static CESAE_Resort.Tools.RepositorySearch.findGuia;

/**
 * Classe responsável por apresentar o menu e funcionalidades disponíveis ao guia.
 */
public class GuiaView {

    private GuiaController guiaController;

    /**
     * Construtor padrão da classe GuiaView.
     * Inicializa o controlador do guia.
     */
    public GuiaView() {
        this.guiaController = new GuiaController();
    }

    /**
     * Exibe o menu principal para o guia e processa as opções selecionadas.
     *
     * @param id ID do guia autenticado (necessário para consultar dados específicos).
     */
    public void guiaMenu(String id) {

        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            // Menu principal do guia
            System.out.println("\n\n********** MENU GUIA **********");
            System.out.println("1. Consultar Histórico de Experiências");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextLine().trim();

            switch (opcao) {
                case "1":
                    // Mostra o histórico de experiências geridas pelo guia
                    consultarHistorico(id);
                    break;
                case "0":
                    // Voltar (termina o loop)
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        } while (!opcao.equals("0"));
    }

    /**
     * Mostra o histórico de experiências associadas ao guia.
     * Inclui experiências administradas, total de vendas (adultos, crianças e total).
     *
     * @param id ID do guia cujas experiências serão consultadas.
     */
    public static void consultarHistorico(String id) {
        // Mostra nome do guia no cabeçalho
        System.out.println("*** Guia " + findGuia(id).getNome() + " ***\n");

        // Lista de experiências associadas ao guia
        System.out.println("Experiências Administradas:\n");
        System.out.println(String.join("\n", findExperienciasGuia(id))); // String.join para melhor formatação

        // Cálculo e exibição dos totais de vendas
        System.out.println("Totais:\n");
        System.out.println("Total de Vendas: " +
                (int) (calcularTotalVendas("adultos", id) + calcularTotalVendas("criancas", id)));
        System.out.println("Dos quais:");
        System.out.println("     Adultos: " + (int) calcularTotalVendas("adultos", id));
        System.out.println("     Crianças: " + (int) calcularTotalVendas("criancas", id));
        System.out.println("\nTotal: " + calcularTotalVendas("total", id) + "$");
    }
}

package CESAE_Resort.Views;

import java.util.Scanner;
import static CESAE_Resort.Controllers.GestaoController.*;

/**
 * Classe responsável por apresentar o menu de gestão (rececionista)
 * e interagir com o utilizador para operações relacionadas com reservas.
 */
public class GestaoView {

    /**
     * Exibe o menu do rececionista e processa as opções escolhidas.
     */
    public void gestaoMenu() {

        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            // Exibe o menu principal
            System.out.println("\n\n********** MENU RECECIONISTA **********");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Quartos Reservados");
            System.out.println("3. Consultar Reservas Atuais");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextLine().trim(); // Lê a opção do utilizador e remove espaços extras

            switch (opcao) {
                case "1":
                    // Lista todos os quartos disponíveis na semana atual
                    System.out.println(String.join("\n\n", consultarQuartosDisponiveis()));
                    break;
                case "2":
                    // Lista os quartos que estão reservados, com dados dos clientes e datas
                    System.out.println(String.join("\n\n", consultarQuartosReservados()));
                    break;
                case "3":
                    // Mostra as reservas que coincidem com a semana atual
                    for (String linha : consultarReservasAtuais()) {
                        System.out.println(linha);
                    }
                    break;
                case "4":
                    // Permite criar uma nova reserva de quarto, se disponível
                    efetuarNovaReserva();
                    break;
                case "5":
                    // Permite reservar uma experiência para um cliente
                    reservarExperiencia();
                    break;
                case "0":
                    // Volta ao menu anterior ou termina a execução
                    break;
                default:
                    // Informa o utilizador se a opção for inválida
                    System.out.println("\nOpção Inválida!");
            }
        } while (!opcao.equals("0")); // Repete o menu até o utilizador escolher sair
    }
}

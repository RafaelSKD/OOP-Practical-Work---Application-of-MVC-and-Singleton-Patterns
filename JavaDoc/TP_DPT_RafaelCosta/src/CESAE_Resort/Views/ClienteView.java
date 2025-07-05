package CESAE_Resort.Views;

import java.util.Scanner;

import static CESAE_Resort.Controllers.ClienteController.*;
import static CESAE_Resort.Controllers.GestaoController.consultarQuartosDisponiveis;
import static CESAE_Resort.Tools.RepositorySearch.preencherRatingExperiencia;
import static CESAE_Resort.Tools.RepositorySearch.verificarExperiencia;

/**
 * Classe responsável por exibir o menu de cliente e capturar interações com o utilizador.
 */
public class ClienteView {

    /**
     * Mostra o menu de cliente e executa as opções selecionadas.
     */
    public void clienteMenu() {

        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            // Menu principal do cliente
            System.out.println("\n\n********** MENU CLIENTE **********");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Experiências Disponíveis");
            System.out.println("3. Consultar Experiência Favorita");
            System.out.println("4. Consultar Experiência Top-Seller");
            System.out.println("5. Avaliar uma Experiência");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextLine().trim(); // Limpa espaços e lê input

            switch (opcao) {
                case "1":
                    // Mostra lista de quartos disponíveis
                    System.out.println(String.join("\n\n", consultarQuartosDisponiveis()));
                    break;
                case "2":
                    // Mostra experiências disponíveis
                    System.out.println(String.join("\n\n", consultarExperienciasDisponiveis()));
                    break;
                case "3":
                    // Mostra a experiência favorita com base nos dados
                    consultarExperienciaFavorita();
                    break;
                case "4":
                    // Mostra a experiência mais vendida
                    consultarTopSeller();
                    break;
                case "5":
                    // Leva ao menu de avaliação
                    menuAvaliar();
                    break;
                case "0":
                    // Voltar (sai do loop)
                    break;
                default:
                    // Caso o utilizador introduza uma opção inválida
                    System.out.println("\nOpção Inválida!");
            }
        } while (!opcao.equals("0"));
    }

    /**
     * Mostra o sub-menu para o cliente avaliar uma experiência.
     * Permite avaliar tanto a experiência como o guia responsável.
     */
    private void menuAvaliar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n********** Avaliação **********");

        // Nome da experiência
        String experiencia;
        do {
            System.out.print("\nExperiência (ex: AI for Kids): ");
            experiencia = input.nextLine();
        } while (!verificarExperiencia(experiencia)); // Verifica se a experiência existe

        // Avaliação da experiência (entre 1 e 5)
        char ratingExperiencia;
        do {
            System.out.print("Rating da experiência (1 - 5): ");
            ratingExperiencia = input.nextLine().charAt(0);
        } while (ratingExperiencia < '1' || ratingExperiencia > '5');

        // Avaliação do guia (entre 1 e 5)
        char ratingGuia;
        do {
            System.out.print("Rating do Guia (1 - 5): ");
            ratingGuia = input.nextLine().charAt(0);
        } while (ratingGuia < '1' || ratingGuia > '5');

        // Confirmação de sucesso
        System.out.println("\nAvaliação realizada com sucesso!");

        // Envia a avaliação para o repositório
        preencherRatingExperiencia(
                experiencia,
                String.valueOf(ratingExperiencia),
                String.valueOf(ratingGuia)
        );
    }
}

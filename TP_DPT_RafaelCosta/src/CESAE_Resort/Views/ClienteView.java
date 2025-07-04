package CESAE_Resort.Views;

import java.util.Scanner;

import static CESAE_Resort.Controllers.ClienteController.*;

public class ClienteView {
    public void clienteMenu(){

        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {

            System.out.println("\n\n********** MENU CLIENTE **********");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Experiências Disponíveis");
            System.out.println("3. Consultar Experiência Favorita");
            System.out.println("4. Consultar Experiência Top-Seller");
            System.out.println("5. Avaliar uma Experiência");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcaoCliente= input.nextInt();


            switch (opcaoCliente){
                case 1: // Consultar Quartos Disponíveis: Imprime em formato tabelar num_quarto, tipologia, preco_por_semana.
                    consultarQuartosDisponiveis();
                    break;
                case 2 : // Consultar Experiências Disponíveis: Imprime em formato tabelar, nome, rating_experiencia, nome do guia, rating_guia, preco_adulto, preco_crianca.
                    consultarExperienciasDisponiveis();
                    break;
                case 3: // Consultar Experiência Favorita: Indica a experiência com melhor rating.
                    consultarExperienciaFavorita();
                    break;
                case 4: // Consultar Experiência Top-Seller: Indica a experiência com mais bilhetes vendidos.
                    consultarTopSeller();
                    break;
                case 5: // Avaliar uma Experiência: Permite escolher uma experiência, seguidamente, pergunta o rating da experiência e o rating do guia.
                    menuAvaliar();
                    break;
                case 0: // Voltar
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        }while (opcaoCliente!=0);
    }

    private void menuAvaliar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n********** Avaliacao **********");
        String experiencia = "";
        do{
            System.out.print("\nExperiencia (ex: AI for Kids): ");
            experiencia = input.nextLine();
        } while (!verificarExperiencia(experiencia));

        char ratingExperiencia;
        do{
            System.out.print("Rating da experiência (1 - 5): ");
            ratingExperiencia = input.nextLine().charAt(0);
        }while (ratingExperiencia < '1' || ratingExperiencia > '5');

        char ratingGuia;
        do{
            System.out.print("Rating do Guia (1 - 5): ");
            ratingGuia = input.nextLine().charAt(0);
        }while (ratingGuia < '1' || ratingGuia > '5');

        System.out.println("\nAvaliação realizada com sucesso!");

        preencherRatingExperiencia(experiencia, String.valueOf(ratingExperiencia), String.valueOf(ratingGuia));
    }
}

package CESAE_Resort.Views;
import java.util.ArrayList;
import java.util.Scanner;

import static CESAE_Resort.Controllers.GestaoController.*;


public class GestaoView {

    public void gestaoMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {

            System.out.println("\n\n********** MENU RECEPCIONISTA **********");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Quartos Reservados");
            System.out.println("3. Consultar Reservas Atuais");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcaoCliente = input.nextInt();

            switch (opcaoCliente) {
                case 1: // Consultar Quartos Disponíveis: Imprime em formato tabelar num_quarto, tipologia, preco_por_semana, que estão disponíveis na semana atual.
                    consultarQuartosDisponiveis();
                    break;
                case 2: // Consultar Quartos Reservados: Imprime em formato tabelar num_quarto, tipologia, idCliente, nome, email, nacionalidade, ano, mês e semana.
                    consultarQuartosReservados();
                    break;
                case 3: // Consultar Reservas Atuais: Imprime em formato tabelar num_quarto, tipologia, idCliente, nome, email, nacionalidade, as reservas da semana atual.
                    for (String linha : consultarReservasAtuais()){
                        System.out.println(linha);
                    }
                    break;
                case 4: // Efetuar uma Reserva: Pergunta as informações como idCliente, numQuarto, ano, mês e semana. Seguidamente verifica se o quarto está disponível e, se possível, efetua a reserva.
                    efetuarNovaReserva();
                    break;
                case 5: // Reservar uma Experiência: Pergunta as informações como idCliente e idReserva, número de adultos e número de crianças e efetua reserva de uma experiência.
                    reservarExperiencia();
                    break;
                case 0: // Voltar
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        } while (opcaoCliente != 0);
    }
}

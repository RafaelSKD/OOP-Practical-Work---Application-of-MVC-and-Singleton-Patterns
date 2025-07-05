package CESAE_Resort.Views;

import CESAE_Resort.Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CESAE_Resort.Controllers.AdminController.*;

/**
 * Classe responsável por exibir o menu de administração (admin)
 * e capturar interações do utilizador com as funcionalidades disponíveis para o administrador.
 */
public class AdminView {
    private AdminController adminController;

    /**
     * Construtor da vista do admin.
     *
     * @throws FileNotFoundException Caso algum ficheiro de dados não seja encontrado durante a inicialização.
     */
    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController();
    }

    /**
     * Mostra o menu principal do administrador e processa as opções selecionadas.
     */
    public void adminMenu() {

        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            // Mostra o menu com as várias funcionalidades disponíveis
            System.out.println("\n\n********** MENU ADMIN **********");
            System.out.println("1. Consultar Total de Reservas");
            System.out.println("2. Consultar Total de Receitas");
            System.out.println("3. Consultar Reservas/Receitas Mensais");
            System.out.println("4. Consultar Tipologia de Quarto Mais Reservada");
            System.out.println("5. Consultar Experiência Mais Procurada (Adultos)");
            System.out.println("6. Consultar Experiência Mais Procurada (Crianças)");
            System.out.println("7. Consultar Experiência Mais Lucrativa");
            System.out.println("8. Consultar Experiência Menos Lucrativa");
            System.out.println("9. Consultar Quarto com Melhor Preço/Semana");
            System.out.println("10. Adicionar Novo Login");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextLine().trim(); // Lê e limpa a entrada do utilizador

            // Processamento da opção escolhida
            switch (opcao) {
                case "1":
                    // Mostra o número total de reservas
                    System.out.println("Numero total de reservas: " + consultarReservas());
                    break;
                case "2":
                    // Mostra o total de receitas
                    consultarTotalReceitas();
                    break;
                case "3":
                    // Mostra as reservas e receitas por mês
                    consultarReservasReceitasMensais();
                    break;
                case "4":
                    // Mostra a tipologia de quarto mais reservada
                    consultarTipologiaTop();
                    break;
                case "5":
                    // Mostra a experiência mais procurada por adultos
                    consultarExperienciaTopAdulto();
                    break;
                case "6":
                    // Mostra a experiência mais procurada por crianças
                    consultarExperienciaTopCrianca();
                    break;
                case "7":
                    // Mostra a experiência mais lucrativa
                    consultarExperienciaTop();
                    break;
                case "8":
                    // Mostra a experiência menos lucrativa
                    consultarExperienciaLow();
                    break;
                case "9":
                    // Mostra o quarto com melhor preço/semana
                    consultarBestRoom();
                    break;
                case "10":
                    // Permite adicionar novo utilizador/login
                    addNewLogin();
                    break;
                case "0":
                    // Voltar ao menu anterior (fim do loop)
                    break;
                default:
                    System.out.println("\nOpção Inválida!"); // Caso de input inválido
            }
        } while (!opcao.equals("0")); // Continua até o utilizador escolher sair
    }
}

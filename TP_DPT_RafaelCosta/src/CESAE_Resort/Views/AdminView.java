package CESAE_Resort.Views;


import CESAE_Resort.Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CESAE_Resort.Controllers.AdminController.*;

public class AdminView {
    private AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController= new AdminController();
    }

    public void adminMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoAdmin;

        do {

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
            opcaoAdmin = input.nextInt();

            switch (opcaoAdmin) {
                case 1:
                    // Consultar Total de Reservas: Número total de reservas (passadas e futuras).
                    System.out.println("Numero total de reservas: " + consultarReservas());
                    break;
                case 2:
                    // Consultar Total de Receitas: Soma de preco_por_semana (quartos) + preços de bilhetes (experiências).
                    consultarTotalReceitas();
                    break;
                case 3:
                    // Consultar Reservas/Receitas Mensais: Pergunta ano e mês, apresenta receitas desse mês.
                    consultarReservasReceitasMensais();
                    break;
                case 4:
                    // Consultar Tipologia de Quarto Mais Reservada.
                    consultarTipologiaTop();
                    break;
                case 5:
                    // Consultar Experiência Mais Procurada (Adultos): Número de bilhetes vendidos.
                    consultarExperienciaTopAdulto();
                    break;
                case 6:
                    // Consultar Experiência Mais Procurada (Crianças): Número de bilhetes vendidos.
                    consultarExperienciaTopCrianca();
                    break;
                case 7:
                    // Consultar Experiência Mais Lucrativa: Valor total arrecadado.
                    consultarExperienciaTop();
                    break;
                case 8:
                    // Consultar Experiência Menos Lucrativa: Valor total arrecadado.
                    consultarExperienciaLow();
                    break;
                case 9:
                    // Consultar Quarto com Melhor Preço/Semana.
                    consultarBestRoom();
                    break;
                case 10:
                    // Adicionar Novo Login.
                    addNewLogin();
                    break;
                case 0:
                    // Voltar
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        } while (opcaoAdmin != 0);
    }

}

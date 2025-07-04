package CESAE_Resort.Views;



import CESAE_Resort.Controllers.GuiaController;

import java.util.Scanner;

import static CESAE_Resort.Controllers.GuiaController.consultarHistorico;

public class GuiaView {
    private GuiaController guiaController;

    public GuiaView() {
        this.guiaController= new GuiaController();

    }

    public void guiaMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoGuia;

        do {

            System.out.println("\n\n********** MENU GUIA **********");
            System.out.println("1. Consultar Histórico de Experiências");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcaoGuia = input.nextInt();

            switch (opcaoGuia) {
                case 1:
                    // Consultar Histórico de Experiências:
                    // Apresenta todas as experiências que são da responsabilidade do guia,
                    // mostrando total de adultos e crianças inscritos, e o valor total arrecadado.
                    consultarHistorico();
                    break;
                case 0:
                    // Voltar
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        } while (opcaoGuia != 0);
    }

}

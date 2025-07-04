package CESAE_Resort.Views;

import CESAE_Resort.Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    private LoginController loginController;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    public void mainMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcaoLogin;

        do {
            System.out.println("\n\n********** Bem-vindo/a ao Programa do CESAE Resort – Hotel Temático da Programação © **********\n");
            System.out.println("1. Login");
            System.out.println("2. Cliente");
            System.out.println("0. Terminar Programa");

            System.out.print("\nOpção: ");
            opcaoLogin = input.nextInt();

            switch (opcaoLogin) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                    ClienteView clienteView = new ClienteView();
                    clienteView.clienteMenu();
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar o nosso programa... Até à próxima!");
                    break;

                default:
                    System.out.println("\nOpção Inválida");
            }
        } while (opcaoLogin != 0);
    }


    public void loginMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print("\nUsername: ");
        String usernameInput = input.next();

        System.out.print("Password: ");
        String passwordInput = input.next();

        String accessType = this.loginController.validateLogin(usernameInput,passwordInput);

        switch (accessType){
            case "ADMIN":
                AdminView adminView = new AdminView();
                adminView.adminMenu();
                break;

            case "GESTAO":
                GestaoView gestaoView = new GestaoView();
                gestaoView.gestaoMenu();
                break;

            case "GUIA":
                GuiaView guiaView = new GuiaView();
                guiaView.guiaMenu();
                break;

            case "ERROR":
                System.out.println("Acessos inválidos");
                break;
        }
    }
}

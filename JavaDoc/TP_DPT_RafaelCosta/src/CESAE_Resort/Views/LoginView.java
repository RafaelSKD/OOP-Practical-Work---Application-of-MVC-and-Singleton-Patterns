package CESAE_Resort.Views;

import CESAE_Resort.Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe responsável pela interface de login e menu principal da aplicação.
 */
public class LoginView {

    private LoginController loginController;

    /**
     * Construtor da classe LoginView.
     *
     * @throws FileNotFoundException caso os ficheiros de dados não estejam acessíveis.
     */
    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    /**
     * Exibe o menu principal da aplicação, com opções de login, cliente ou sair.
     *
     * @throws FileNotFoundException caso haja erro ao carregar dados de login.
     */
    public void mainMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        char opcao;

        do {
            // Exibe o menu inicial
            System.out.println("\n\n********** Bem-vindo/a ao Programa do CESAE Resort – Hotel Temático da Programação © **********\n");
            System.out.println("1. Login");
            System.out.println("2. Cliente");
            System.out.println("0. Terminar Programa");

            System.out.print("\nOpção: ");
            opcao = input.nextLine().charAt(0); // Lê apenas o primeiro caractere da linha

            switch (opcao) {
                case '1':
                    // Vai para o menu de login
                    loginMenu();
                    break;
                case '2':
                    // Acede diretamente ao menu do cliente (sem login)
                    ClienteView clienteView = new ClienteView();
                    clienteView.clienteMenu();
                    break;
                case '0':
                    // Termina a aplicação
                    System.out.println("\nObrigado por utilizar o nosso programa... Até à próxima!");
                    break;
                default:
                    // Opção inválida
                    System.out.println("\nOpção Inválida: escolha uma opção do menu.");
            }
        } while (opcao != '0'); // Repete até o utilizador escolher sair
    }

    /**
     * Menu de autenticação. Solicita username e password e redireciona
     * para o menu correspondente ao tipo de acesso (ADMIN, GESTAO, GUIA).
     *
     * @throws FileNotFoundException caso haja erro ao carregar dados.
     */
    public void loginMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        // Solicita credenciais ao utilizador
        System.out.print("\nUsername: ");
        String usernameInput = input.next();

        System.out.print("Password: ");
        String passwordInput = input.next();

        // Valida as credenciais e obtém o tipo de acesso
        String accessType = this.loginController.validateLogin(usernameInput, passwordInput);

        switch (accessType) {
            case "ADMIN":
                // Acesso ao menu de administrador
                AdminView adminView = new AdminView();
                adminView.adminMenu();
                break;

            case "GESTAO":
                // Acesso ao menu de rececionista/gestão
                GestaoView gestaoView = new GestaoView();
                gestaoView.gestaoMenu();
                break;

            case "GUIA":
                // Acesso ao menu de guia (envia o username como ID)
                GuiaView guiaView = new GuiaView();
                guiaView.guiaMenu(usernameInput);
                break;

            case "ERROR":
                // Credenciais inválidas
                System.out.println("Acessos inválidos");
                break;
        }
    }
}

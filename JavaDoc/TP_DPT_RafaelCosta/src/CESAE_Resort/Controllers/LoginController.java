package CESAE_Resort.Controllers;

import CESAE_Resort.Models.User;
import CESAE_Resort.Repositories.UsersRepository;

import java.io.FileNotFoundException;

/**
 * Controlador responsável pelo login de usuários.
 */
public class LoginController {

    private UsersRepository usersRepository;

    /**
     * Construtor que inicializa o repositório de usuários.
     *
     * @throws FileNotFoundException se o arquivo do repositório não for encontrado.
     */
    public LoginController() throws FileNotFoundException {
        this.usersRepository = UsersRepository.getInstance();
    }

    /**
     * Valida o login do usuário comparando username e password.
     *
     * @param usernameInput Nome de usuário fornecido.
     * @param passwordInput Senha fornecida.
     * @return Tipo de acesso do usuário ("ADMIN", "GESTAO", "GUIA"), ou "ERROR" se credenciais inválidas.
     */
    public String validateLogin(String usernameInput, String passwordInput) {
        // Percorre todos os usuários no repositório
        for (User userAtual : this.usersRepository.getUserArray()) {
            // Verifica se o username e a password conferem
            if (userAtual.getUsername().equals(usernameInput) && userAtual.getPassword().equals(passwordInput)) {
                // Encontrou usuário válido, retorna o tipo de acesso dele
                return userAtual.getTipoAcesso();
            }
        }
        // Caso nenhum usuário válido seja encontrado, retorna "ERROR"
        return "ERROR";

    }
}

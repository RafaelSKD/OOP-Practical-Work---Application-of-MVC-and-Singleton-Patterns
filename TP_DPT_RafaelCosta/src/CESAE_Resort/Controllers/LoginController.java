package CESAE_Resort.Controllers;

import CESAE_Resort.Models.User;
import CESAE_Resort.Repositories.UsersRepository;

import java.io.FileNotFoundException;

public class LoginController {

    private UsersRepository usersRepository;

    public LoginController() throws FileNotFoundException {
        this.usersRepository = UsersRepository.getInstance();
    }

    public String validateLogin(String usernameInput, String passwordInput){

        for(User userAtual : this.usersRepository.getUserArray()){
            if(userAtual.getUsername().equals(usernameInput) && userAtual.getPassword().equals(passwordInput)){
                // Encontramos o match (username e password)
                return userAtual.getTipoAcesso();
            }
        }
        return "ERROR";
    }
}

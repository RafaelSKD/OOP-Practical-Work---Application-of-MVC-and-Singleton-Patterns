package CESAE_Resort.Models;

// Classe para os logins

public class User {
    private String username;  // username para o login ex: admin
    private String password;  // password para login ex: admin123
    private String tipoAcesso;  // Tipo de acesso : ADMIN,GESTAO,GUIA

    // Construtor
    public User(String username, String password, String tipoAcesso) {
        this.username = username;
        this.password = password;
        this.tipoAcesso = tipoAcesso;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }
}

package CESAE_Resort.Models;

/**
 * Classe que representa um usuário do sistema de login.
 * Cada usuário possui um nome de usuário, uma senha e um tipo de acesso.
 */
public class User {
    private String username;  // Nome de usuário para o login, ex: admin
    private String password;  // Senha para login, ex: admin123
    private String tipoAcesso;  // Tipo de acesso do usuário: ADMIN, GESTAO, GUIA

    /**
     * Construtor da classe User.
     *
     * Inicializa um novo usuário com o nome de usuário, senha e tipo de acesso fornecidos.
     *
     * @param username Nome de usuário para o login.
     * @param password Senha para login.
     * @param tipoAcesso Tipo de acesso do usuário (ADMIN, GESTAO, GUIA).
     */
    public User(String username, String password, String tipoAcesso) {
        this.username = username;
        this.password = password;
        this.tipoAcesso = tipoAcesso;
    }

    /**
     * @return Nome de usuário.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return Senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return Tipo de acesso do usuário (ADMIN, GESTAO, GUIA).
     */
    public String getTipoAcesso() {
        return tipoAcesso;
    }
}

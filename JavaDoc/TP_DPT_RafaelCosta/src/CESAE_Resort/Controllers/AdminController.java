package CESAE_Resort.Controllers;

import CESAE_Resort.Repositories.ExperienciasRepository;
import CESAE_Resort.Repositories.ReservasRepository;

import java.io.FileNotFoundException;

/**
 * Classe responsável por fornecer funcionalidades administrativas
 * como consultar estatísticas de reservas, receitas e experiências.
 */
public class AdminController {

    private static ReservasRepository reservasRepository;

    // Bloco estático para inicializar o repositório de experiências
    static {
        try {
            reservasRepository = ReservasRepository.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            reservasRepository = null;
        }
    }

    /**
     * Consulta o número total de reservas registadas.
     *
     * @return número total de reservas.
     */
    public static int consultarReservas() {
        return reservasRepository.getReservasArray().size();
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de calcular o total de receitas ainda não foi implementada.
     */
    public static void consultarTotalReceitas() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de consultar reservas/receitas mensais ainda não foi implementada.
     */
    public static void consultarReservasReceitasMensais() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de encontrar a tipologia mais reservada ainda não foi implementada.
     */
    public static void consultarTipologiaTop() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de consultar a experiência mais procurada por adultos ainda não foi implementada.
     */
    public static void consultarExperienciaTopAdulto() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de consultar a experiência mais procurada por crianças ainda não foi implementada.
     */
    public static void consultarExperienciaTopCrianca() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de consultar a experiência mais lucrativa ainda não foi implementada.
     */
    public static void consultarExperienciaTop() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de consultar a experiência menos lucrativa ainda não foi implementada.
     */
    public static void consultarExperienciaLow() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de consultar o melhor quarto por preço/semana ainda não foi implementada.
     */
    public static void consultarBestRoom() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe uma mensagem de erro, pois a funcionalidade de adicionar novo login ainda não foi implementada.
     */
    public static void addNewLogin() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }
}

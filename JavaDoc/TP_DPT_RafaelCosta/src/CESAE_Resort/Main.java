package CESAE_Resort;

import CESAE_Resort.Views.LoginView;
import java.io.IOException;

import static CESAE_Resort.Tools.FileUpdate.updateFiles;

/**
 * Classe principal que inicia a aplicação do CESAE Resort.
 */
public class Main {

    /**
     * Método principal que inicia o programa.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     * @throws IOException Se ocorrer erro na leitura/escrita dos ficheiros.
     */
    public static void main(String[] args) throws IOException {
        LoginView lv = new LoginView();
        lv.mainMenu();
        updateFiles();
    }
}

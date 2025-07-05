package CESAE_Resort.Repositories;

import CESAE_Resort.Models.User;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de usuários (logins).
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados de usuários a partir de um arquivo CSV.
 */
public class UsersRepository {
    private static UsersRepository instance; // Instância única da classe (Singleton)
    private ArrayList<User> userArray; // Lista de usuários carregada dos arquivos CSV

    /**
     * Construtor privado para inicializar o repositório de usuários.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados dos usuários não seja encontrado.
     */
    private UsersRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.userArray = csvFR.usersFileReader("Files/logins.csv");
        // Carrega os usuários a partir do arquivo CSV
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de usuários.
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados dos usuários não seja encontrado.
     */
    public static synchronized UsersRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new UsersRepository(); // Cria a instância caso ainda não tenha sido criada
        }
        return instance;
    }

    /**
     * Método para obter a lista de usuários carregada.
     *
     * @return A lista de usuários armazenada no repositório.
     */
    public ArrayList<User> getUserArray() {
        return userArray;
    }
}

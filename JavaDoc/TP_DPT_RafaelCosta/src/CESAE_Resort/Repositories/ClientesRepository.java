package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Cliente;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de clientes.
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados dos clientes a partir de um arquivo CSV.
 */
public class ClientesRepository {
    private static ClientesRepository instance; // Instância única da classe (Singleton)
    private ArrayList<Cliente> clienteArray;    // Lista de clientes carregada do arquivo CSV

    /**
     * Construtor privado para inicializar o repositório de clientes.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados dos clientes não seja encontrado.
     */
    private ClientesRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.clienteArray = csvFR.clientesFileReader("Files/clientes.csv"); // Carrega os dados dos clientes
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de clientes.
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados dos clientes não seja encontrado.
     */
    public static synchronized ClientesRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ClientesRepository(); // Cria a instância caso não tenha sido criada ainda
        }
        return instance;
    }

    /**
     * Método para obter a lista de clientes carregada.
     *
     * @return A lista de clientes armazenada no repositório.
     */
    public ArrayList<Cliente> getClienteArray() {
        return clienteArray;
    }
}

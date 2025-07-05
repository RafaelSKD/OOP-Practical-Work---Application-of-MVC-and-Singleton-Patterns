package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Quarto;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de quartos.
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados dos quartos a partir de arquivos CSV.
 */
public class QuartosRepository {
    private static QuartosRepository instance; // Instância única da classe (Singleton)
    private ArrayList<Quarto> quartosArray; // Lista de quartos carregada dos arquivos CSV

    /**
     * Construtor privado para inicializar o repositório de quartos.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso os arquivos CSV contendo os dados dos quartos e tipologias não sejam encontrados.
     */
    private QuartosRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.quartosArray = csvFR.quartosFileReader("Files/quartos.csv", "Files/tipologia.csv");
        // Carrega os quartos a partir dos arquivos CSV
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de quartos.
     * @throws FileNotFoundException Caso os arquivos CSV contendo os dados dos quartos e tipologias não sejam encontrados.
     */
    public static synchronized QuartosRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new QuartosRepository(); // Cria a instância caso ainda não tenha sido criada
        }
        return instance;
    }

    /**
     * Método para obter a lista de quartos carregada.
     *
     * @return A lista de quartos armazenada no repositório.
     */
    public ArrayList<Quarto> getQuartosArray() {
        return quartosArray;
    }
}

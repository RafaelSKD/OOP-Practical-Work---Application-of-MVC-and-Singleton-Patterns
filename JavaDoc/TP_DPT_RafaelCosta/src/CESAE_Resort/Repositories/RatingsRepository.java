package CESAE_Resort.Repositories;

import CESAE_Resort.Models.RatingExperiencia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de ratings (avaliações) de experiências.
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados de avaliações a partir de arquivos CSV.
 */
public class RatingsRepository {
    private static RatingsRepository instance; // Instância única da classe (Singleton)
    private ArrayList<RatingExperiencia> ratingsArray; // Lista de ratings carregada dos arquivos CSV

    /**
     * Construtor privado para inicializar o repositório de ratings.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das avaliações não seja encontrado.
     */
    private RatingsRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.ratingsArray = csvFR.ratingsFileReader("Files/ratings_experiencias.csv");
        // Carrega as avaliações a partir do arquivo CSV
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de ratings.
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das avaliações não seja encontrado.
     */
    public static synchronized RatingsRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new RatingsRepository(); // Cria a instância caso ainda não tenha sido criada
        }
        return instance;
    }

    /**
     * Método para obter a lista de ratings (avaliações) carregada.
     *
     * @return A lista de ratings armazenada no repositório.
     */
    public ArrayList<RatingExperiencia> getRatingsArray() {
        return ratingsArray;
    }

    /**
     * Método para adicionar uma nova avaliação ao repositório.
     *
     * @param rating A avaliação a ser adicionada ao repositório.
     */
    public void addRating(RatingExperiencia rating) {
        this.ratingsArray.add(rating); // Adiciona a avaliação à lista de ratings
    }
}

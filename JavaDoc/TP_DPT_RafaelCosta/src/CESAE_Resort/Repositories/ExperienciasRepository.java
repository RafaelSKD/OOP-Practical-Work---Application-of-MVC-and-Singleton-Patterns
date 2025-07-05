package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Experiencia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de experiências.
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados das experiências a partir de um arquivo CSV.
 */
public class ExperienciasRepository {
    private static ExperienciasRepository instance; // Instância única da classe (Singleton)
    private ArrayList<Experiencia> experienciasArray; // Lista de experiências carregada do arquivo CSV

    /**
     * Construtor privado para inicializar o repositório de experiências.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das experiências não seja encontrado.
     */
    private ExperienciasRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.experienciasArray = csvFR.experienciasFileReader("Files/experiencias.csv"); // Carrega as experiências do arquivo CSV
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de experiências.
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das experiências não seja encontrado.
     */
    public static synchronized ExperienciasRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ExperienciasRepository(); // Cria a instância caso ainda não tenha sido criada
        }
        return instance;
    }

    /**
     * Método para obter a lista de experiências carregada.
     *
     * @return A lista de experiências armazenada no repositório.
     */
    public ArrayList<Experiencia> getExperienciasArray() {
        return experienciasArray;
    }
}

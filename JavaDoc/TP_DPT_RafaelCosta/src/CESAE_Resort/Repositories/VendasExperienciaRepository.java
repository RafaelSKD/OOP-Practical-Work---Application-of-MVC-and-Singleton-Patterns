package CESAE_Resort.Repositories;

import CESAE_Resort.Models.VendaExperiencia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de vendas de experiências.
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados das vendas a partir de um arquivo CSV.
 */
public class VendasExperienciaRepository {
    private static VendasExperienciaRepository instance; // Instância única da classe (Singleton)
    private ArrayList<VendaExperiencia> vendasExperienciaArray; // Lista de vendas de experiência carregada dos arquivos CSV

    /**
     * Construtor privado para inicializar o repositório de vendas de experiências.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das vendas de experiências não seja encontrado.
     */
    private VendasExperienciaRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.vendasExperienciaArray = csvFR.vendasFileReader("Files/vendas_experiencias.csv");
        // Carrega as vendas de experiência a partir do arquivo CSV
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de vendas de experiências.
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das vendas de experiências não seja encontrado.
     */
    public static synchronized VendasExperienciaRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new VendasExperienciaRepository(); // Cria a instância caso ainda não tenha sido criada
        }
        return instance;
    }

    /**
     * Método para obter a lista de vendas de experiências carregada.
     *
     * @return A lista de vendas de experiências armazenada no repositório.
     */
    public ArrayList<VendaExperiencia> getVendasExperienciaArray() {
        return vendasExperienciaArray;
    }
}

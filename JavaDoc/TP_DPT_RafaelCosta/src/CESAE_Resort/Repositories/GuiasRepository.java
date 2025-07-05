package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Guia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de guias.
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados dos guias a partir de um arquivo CSV.
 */
public class GuiasRepository {
    private static GuiasRepository instance; // Instância única da classe (Singleton)
    private ArrayList<Guia> guiasArray; // Lista de guias carregada do arquivo CSV

    /**
     * Construtor privado para inicializar o repositório de guias.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados dos guias não seja encontrado.
     */
    private GuiasRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.guiasArray = csvFR.guiasFileReader("Files/guias_experiencias.csv"); // Carrega os guias do arquivo CSV
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de guias.
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados dos guias não seja encontrado.
     */
    public static synchronized GuiasRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new GuiasRepository(); // Cria a instância caso ainda não tenha sido criada
        }
        return instance;
    }

    /**
     * Método para obter a lista de guias carregada.
     *
     * @return A lista de guias armazenada no repositório.
     */
    public ArrayList<Guia> getGuiaArray() {
        return guiasArray;
    }
}

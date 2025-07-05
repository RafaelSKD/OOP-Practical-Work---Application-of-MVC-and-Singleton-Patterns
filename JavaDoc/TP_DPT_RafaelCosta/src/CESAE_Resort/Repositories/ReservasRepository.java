package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Reserva;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar o repositório de reservas de quartos.
 * Utiliza o padrão Singleton para garantir que exista apenas uma instância da classe.
 * A instância é responsável por carregar os dados de reservas a partir de arquivos CSV.
 */
public class ReservasRepository {
    private static ReservasRepository instance; // Instância única da classe (Singleton)
    private ArrayList<Reserva> reservasArray; // Lista de reservas carregada dos arquivos CSV

    /**
     * Construtor privado para inicializar o repositório de reservas.
     * O construtor é privado para garantir que a criação de instâncias da classe seja controlada pelo padrão Singleton.
     *
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das reservas não seja encontrado.
     */
    private ReservasRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader(); // Instância do leitor de arquivos CSV
        this.reservasArray = csvFR.reservasFileReader("Files/reservas_quartos.csv");
        // Carrega as reservas a partir do arquivo CSV
    }

    /**
     * Método público e sincronizado para obter a instância única do repositório.
     * Se a instância ainda não foi criada, ela será criada, caso contrário, retorna a instância existente.
     *
     * @return A instância única do repositório de reservas.
     * @throws FileNotFoundException Caso o arquivo CSV contendo os dados das reservas não seja encontrado.
     */
    public static synchronized ReservasRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ReservasRepository(); // Cria a instância caso ainda não tenha sido criada
        }
        return instance;
    }

    /**
     * Método para obter a lista de reservas carregada.
     *
     * @return A lista de reservas armazenada no repositório.
     */
    public ArrayList<Reserva> getReservasArray() {
        return reservasArray;
    }
}

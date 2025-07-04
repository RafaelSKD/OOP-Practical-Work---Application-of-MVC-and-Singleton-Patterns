package CESAE_Resort.Repositories;

import CESAE_Resort.Models.VendaExperiencia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class VendasExperienciaRepository {
    private static VendasExperienciaRepository instance; // instância única
    private ArrayList<VendaExperiencia> vendasExperienciaArray;

    // Construtor privado para impedir criação externa
    private VendasExperienciaRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.vendasExperienciaArray = csvFR.vendasFileReader("Files/vendas_experiencias.csv");
    }

    // Método público para acessar a instância única
    public static synchronized VendasExperienciaRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new VendasExperienciaRepository();
        }
        return instance;
    }

    public ArrayList<VendaExperiencia> getVendasExperienciaArray() {
        return vendasExperienciaArray;
    }
}

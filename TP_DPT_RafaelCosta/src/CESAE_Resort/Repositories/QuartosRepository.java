package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Quarto;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class QuartosRepository {
    private static QuartosRepository instance; // instância única
    private ArrayList<Quarto> quartosArray;

    // Construtor privado para impedir criação externa
    private QuartosRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.quartosArray = csvFR.quartosFileReader("Files/quartos.csv", "Files/tipologia.csv");
    }

    // Método público para acessar a instância única
    public static synchronized QuartosRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new QuartosRepository();
        }
        return instance;
    }

    public ArrayList<Quarto> getQuartosArray() {
        return quartosArray;
    }
}

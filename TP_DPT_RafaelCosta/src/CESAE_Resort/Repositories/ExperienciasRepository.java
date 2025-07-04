package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Experiencia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class ExperienciasRepository {
    private static ExperienciasRepository instance; // instância única
    private ArrayList<Experiencia> experienciasArray;

    // Construtor privado para impedir criação externa
    private ExperienciasRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.experienciasArray = csvFR.experienciasFileReader("Files/experiencias.csv");
    }

    // Método público para acessar a instância única
    public static synchronized ExperienciasRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ExperienciasRepository();
        }
        return instance;
    }

    public ArrayList<Experiencia> getExperienciasArray() {
        return experienciasArray;
    }
}

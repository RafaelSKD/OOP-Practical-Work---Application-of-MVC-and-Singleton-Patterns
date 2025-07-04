package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Guia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class GuiasRepository {
    private static GuiasRepository instance; // instância única
    private ArrayList<Guia> guiasArray;

    // Construtor privado para impedir criação externa
    private GuiasRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.guiasArray = csvFR.guiasFileReader("Files/guias_experiencias.csv");
    }

    // Método público para acessar a instância única
    public static synchronized GuiasRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new GuiasRepository();
        }
        return instance;
    }

    public ArrayList<Guia> getGuiaArray() {
        return guiasArray;
    }
}


package CESAE_Resort.Repositories;

import CESAE_Resort.Models.RatingExperiencia;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RatingsRepository {
    private static RatingsRepository instance; // instância única
    private ArrayList<RatingExperiencia> ratingsArray;

    // Construtor privado para impedir criação externa
    private RatingsRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.ratingsArray = csvFR.ratingsFileReader("Files/ratings_experiencias.csv");
    }

    // Método público para acessar a instância única
    public static synchronized RatingsRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new RatingsRepository();
        }
        return instance;
    }

    public ArrayList<RatingExperiencia> getRatingsArray() {
        return ratingsArray;
    }

    public void addRating(RatingExperiencia rating) {
        this.ratingsArray.add(rating);
    }
}

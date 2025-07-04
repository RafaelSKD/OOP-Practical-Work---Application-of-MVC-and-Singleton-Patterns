package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Reserva;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReservasRepository {
    private static ReservasRepository instance; // instância única
    private ArrayList<Reserva> reservasArray;

    // Construtor privado para impedir criação externa
    private ReservasRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.reservasArray = csvFR.reservasFileReader("Files/reservas_quartos.csv");
    }

    // Método público para acessar a instância única
    public static synchronized ReservasRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ReservasRepository();
        }
        return instance;
    }

    public ArrayList<Reserva> getReservasArray() {
        return reservasArray;
    }
}

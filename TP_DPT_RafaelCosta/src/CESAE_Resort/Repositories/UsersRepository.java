package CESAE_Resort.Repositories;


import CESAE_Resort.Models.User;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsersRepository {
    private static UsersRepository instance; // instância única
    private ArrayList<User> userArray;

    // Construtor privado para impedir criação externa
    private UsersRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.userArray = csvFR.usersFileReader("Files/logins.csv");
    }

    // Método público para acessar a instância única
    public static synchronized UsersRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new UsersRepository();
        }
        return instance;
    }

    public ArrayList<User> getUserArray() {
        return userArray;
    }
}

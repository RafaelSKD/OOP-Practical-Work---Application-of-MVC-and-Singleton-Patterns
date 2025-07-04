package CESAE_Resort.Repositories;

import CESAE_Resort.Models.Cliente;
import CESAE_Resort.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientesRepository {
    private static ClientesRepository instance; // instância única
    private ArrayList<Cliente> clienteArray;

    // Construtor privado para impedir criação externa
    private ClientesRepository() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.clienteArray = csvFR.clientesFileReader("Files/clientes.csv");
    }

    // Método público para acessar a instância única
    public static synchronized ClientesRepository getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ClientesRepository();
        }
        return instance;
    }

    public ArrayList<Cliente> getClienteArray() {
        return clienteArray;
    }
}

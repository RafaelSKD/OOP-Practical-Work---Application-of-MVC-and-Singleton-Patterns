package CESAE_Resort.Tools;

import CESAE_Resort.Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe utilitária para ler e carregar dados a partir de arquivos CSV.
 * Cada método é responsável por ler dados de diferentes tipos de objetos (Usuários, Clientes, Experiências, etc.)
 * e retornar essas informações em listas de objetos correspondentes.
 */
public class CSVFileReader {

    /**
     * Lê o arquivo CSV de usuários e retorna uma lista de objetos {@link User}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados dos usuários.
     * @return Uma lista de objetos {@link User} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<User> usersFileReader(String filePath) throws FileNotFoundException {
        File usersFile = new File(filePath);
        Scanner usersScanner = new Scanner(usersFile);
        ArrayList<User> usersArray = new ArrayList<>();

        // Avançar o cabeçalho
        usersScanner.nextLine();

        while (usersScanner.hasNextLine()) {
            String linha = usersScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String username = linhaSeparada[0];
            String password = linhaSeparada[1];
            String tipoAcesso = linhaSeparada[2];
            User newUser = new User(username, password, tipoAcesso);
            usersArray.add(newUser);
        }
        return usersArray;
    }

    /**
     * Lê o arquivo CSV de clientes e retorna uma lista de objetos {@link Cliente}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados dos clientes.
     * @return Uma lista de objetos {@link Cliente} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<Cliente> clientesFileReader(String filePath) throws FileNotFoundException {
        File clientesFile = new File(filePath);
        Scanner clienteScanner = new Scanner(clientesFile);
        ArrayList<Cliente> clienteArray = new ArrayList<>();

        clienteScanner.nextLine(); // Avançar o cabeçalho

        while (clienteScanner.hasNextLine()) {
            String linha = clienteScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String idCliente = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            String telemovel = linhaSeparada[4];
            String dataNascimento = linhaSeparada[5];
            boolean consentimentoMarketing = Boolean.parseBoolean(linhaSeparada[6]);
            Cliente newCliente = new Cliente(idCliente, nome, nacionalidade, email, telemovel, dataNascimento, consentimentoMarketing);
            clienteArray.add(newCliente);
        }
        return clienteArray;
    }

    /**
     * Lê o arquivo CSV de experiências e retorna uma lista de objetos {@link Experiencia}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados das experiências.
     * @return Uma lista de objetos {@link Experiencia} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<Experiencia> experienciasFileReader(String filePath) throws FileNotFoundException {
        File experienciasFile = new File(filePath);
        Scanner experienciaScanner = new Scanner(experienciasFile);
        ArrayList<Experiencia> experienciasArray = new ArrayList<>();

        experienciaScanner.nextLine(); // Avançar o cabeçalho

        while (experienciaScanner.hasNextLine()) {
            String linha = experienciaScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String id_guia_experiencia = linhaSeparada[2];
            double precoAdulto = Double.parseDouble(linhaSeparada[3]);
            double precoCrianca = Double.parseDouble(linhaSeparada[4]);
            Experiencia newExperiencia = new Experiencia(id, nome, id_guia_experiencia, precoAdulto, precoCrianca);
            experienciasArray.add(newExperiencia);
        }
        return experienciasArray;
    }

    /**
     * Lê o arquivo CSV de guias e retorna uma lista de objetos {@link Guia}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados dos guias.
     * @return Uma lista de objetos {@link Guia} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<Guia> guiasFileReader(String filePath) throws FileNotFoundException {
        File guiasFile = new File(filePath);
        Scanner guiaScanner = new Scanner(guiasFile);
        ArrayList<Guia> guiasArray = new ArrayList<>();

        guiaScanner.nextLine(); // Avançar o cabeçalho

        while (guiaScanner.hasNextLine()) {
            String linha = guiaScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            String telemovel = linhaSeparada[4];
            Guia newGuia = new Guia(id, nome, nacionalidade, email, telemovel);
            guiasArray.add(newGuia);
        }
        return guiasArray;
    }

    /**
     * Lê o arquivo CSV de ratings e retorna uma lista de objetos {@link RatingExperiencia}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados dos ratings das experiências.
     * @return Uma lista de objetos {@link RatingExperiencia} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<RatingExperiencia> ratingsFileReader(String filePath) throws FileNotFoundException {
        File ratingsFile = new File(filePath);
        Scanner ratingScanner = new Scanner(ratingsFile);
        ArrayList<RatingExperiencia> ratingsArray = new ArrayList<>();

        ratingScanner.nextLine(); // Avançar o cabeçalho

        while (ratingScanner.hasNextLine()) {
            String linha = ratingScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            String idExperiencia = linhaSeparada[1];
            int ratingExperiencia = Integer.parseInt(linhaSeparada[2]);
            int ratingGuia = Integer.parseInt(linhaSeparada[3]);
            RatingExperiencia newRating = new RatingExperiencia(id, idExperiencia, ratingExperiencia, ratingGuia);
            ratingsArray.add(newRating);
        }
        return ratingsArray;
    }

    /**
     * Lê o arquivo CSV de reservas e retorna uma lista de objetos {@link Reserva}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados das reservas.
     * @return Uma lista de objetos {@link Reserva} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<Reserva> reservasFileReader(String filePath) throws FileNotFoundException {
        File reservasFile = new File(filePath);
        Scanner reservaScanner = new Scanner(reservasFile);
        ArrayList<Reserva> reservasArray = new ArrayList<>();

        reservaScanner.nextLine(); // Avançar o cabeçalho

        while (reservaScanner.hasNextLine()) {
            String linha = reservaScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            int numQuarto = Integer.parseInt(linhaSeparada[1]);
            String idCliente = linhaSeparada[2];
            int ano = Integer.parseInt(linhaSeparada[3]);
            int mes = Integer.parseInt(linhaSeparada[4]);
            int semana = Integer.parseInt(linhaSeparada[5]);
            Reserva newReserva = new Reserva(id, numQuarto, idCliente, ano, mes, semana);
            reservasArray.add(newReserva);
        }
        return reservasArray;
    }

    /**
     * Lê o arquivo CSV de vendas de experiências e retorna uma lista de objetos {@link VendaExperiencia}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados das vendas de experiências.
     * @return Uma lista de objetos {@link VendaExperiencia} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<VendaExperiencia> vendasFileReader(String filePath) throws FileNotFoundException {
        File vendaExperienciaFile = new File(filePath);
        Scanner vendaExperienciaScanner = new Scanner(vendaExperienciaFile);
        ArrayList<VendaExperiencia> vendaExperienciaArray = new ArrayList<>();

        vendaExperienciaScanner.nextLine(); // Avançar o cabeçalho

        while (vendaExperienciaScanner.hasNextLine()) {
            String linha = vendaExperienciaScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            String idExperiencia = linhaSeparada[1];
            String tipoCliente = linhaSeparada[2];
            int ano = Integer.parseInt(linhaSeparada[3]);
            int mes = Integer.parseInt(linhaSeparada[4]);
            VendaExperiencia newVendaExperiencia = new VendaExperiencia(id, idExperiencia, tipoCliente, ano, mes);
            vendaExperienciaArray.add(newVendaExperiencia);
        }
        return vendaExperienciaArray;
    }

    /**
     * Lê o arquivo CSV de quartos e retorna uma lista de objetos {@link Quarto}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados dos quartos.
     * @param tipologiaPath O caminho para o arquivo CSV de tipologias para associar aos quartos.
     * @return Uma lista de objetos {@link Quarto} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso qualquer um dos arquivos não seja encontrado.
     */
    public ArrayList<Quarto> quartosFileReader(String filePath, String tipologiaPath) throws FileNotFoundException {
        File quartoFile = new File(filePath);
        Scanner quartoScanner = new Scanner(quartoFile);
        ArrayList<Quarto> quartoArray = new ArrayList<>();
        ArrayList<Tipologia> tipologiaArray = tipologiaFileReader(tipologiaPath);

        quartoScanner.nextLine(); // Avançar o cabeçalho

        while (quartoScanner.hasNextLine()) {
            String linha = quartoScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            int numQuarto = Integer.parseInt(linhaSeparada[0]);
            int idTipologia = Integer.parseInt(linhaSeparada[1]);
            String descricao = tipologiaArray.get(idTipologia - 1).getDescricao(); // -1 porque o id começa em 1
            double preco = tipologiaArray.get(idTipologia - 1).getPreco();
            Quarto newQuarto = new Quarto(idTipologia, descricao, preco, numQuarto);
            quartoArray.add(newQuarto);
        }
        return quartoArray;
    }

    /**
     * Lê o arquivo CSV de tipologias e retorna uma lista de objetos {@link Tipologia}.
     *
     * @param filePath O caminho para o arquivo CSV que contém os dados das tipologias.
     * @return Uma lista de objetos {@link Tipologia} com os dados lidos do arquivo.
     * @throws FileNotFoundException Caso o arquivo não seja encontrado.
     */
    public ArrayList<Tipologia> tipologiaFileReader(String filePath) throws FileNotFoundException {
        File tipologiaFile = new File(filePath);
        Scanner tipologiaScanner = new Scanner(tipologiaFile);
        ArrayList<Tipologia> tipologiaArray = new ArrayList<>();

        tipologiaScanner.nextLine(); // Avançar o cabeçalho

        while (tipologiaScanner.hasNextLine()) {
            String linha = tipologiaScanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            int id = Integer.parseInt(linhaSeparada[0]);
            String descricao = linhaSeparada[1];
            double preco = Double.parseDouble(linhaSeparada[2]);
            Tipologia newTipologia = new Tipologia(id, descricao, preco);
            tipologiaArray.add(newTipologia);
        }
        return tipologiaArray;
    }
}

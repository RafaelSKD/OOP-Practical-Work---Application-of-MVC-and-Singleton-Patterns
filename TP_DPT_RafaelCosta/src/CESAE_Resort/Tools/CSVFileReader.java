package CESAE_Resort.Tools;

import CESAE_Resort.Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader {

    public ArrayList<User> usersFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File usersFile = new File(filePath);
        Scanner usersScanner = new Scanner(usersFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<User> usersArray = new ArrayList<>();

        // Avançar o cabeçalho
        usersScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (usersScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = usersScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            String username = linhaSeparada[0];
            String password = linhaSeparada[1];
            String tipoAcesso = linhaSeparada[2];

            // Criar novo Utilizador
            User newUser = new User(username, password, tipoAcesso);

            // Adicionamos ao Array
            usersArray.add(newUser);

        }

        // Terminando o ciclo (não há mais linhas)
        return usersArray;
    }

    public ArrayList<Cliente> clientesFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File clientesFile = new File(filePath);
        Scanner clienteScanner = new Scanner(clientesFile);

        // Criamos o ArrayList de Clientes, vazio
        ArrayList<Cliente> clienteArray = new ArrayList<>();

        // Avançar o cabeçalho
        clienteScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (clienteScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = clienteScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            String idCliente = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            String telemovel = linhaSeparada[4];
            String dataNascimento = linhaSeparada[5];
            boolean consentimentoMarketing = Boolean.parseBoolean(linhaSeparada[6]);

            // Criar novo Cliente
            Cliente newCliente = new Cliente(idCliente, nome, nacionalidade, email, telemovel, dataNascimento, consentimentoMarketing);

            // Adicionamos ao Array
            clienteArray.add(newCliente);
        }

        // Terminando o ciclo (não há mais linhas)
        return clienteArray;
    }

    public ArrayList<Experiencia> experienciasFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File experienciasFile = new File(filePath);
        Scanner experienciaScanner = new Scanner(experienciasFile);

        // Criamos o ArrayList de Experiencias, vazio
        ArrayList<Experiencia> experienciasArray = new ArrayList<>();

        // Avançar o cabeçalho
        experienciaScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (experienciaScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = experienciaScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            String id = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String id_guia_experiencia = linhaSeparada[2];
            double precoAdulto = Double.parseDouble(linhaSeparada[3]);
            double precoCrianca = Double.parseDouble(linhaSeparada[4]);

            // Criar nova Experiencia
            Experiencia newExperiencia = new Experiencia(id,nome,id_guia_experiencia,precoAdulto,precoCrianca);

            // Adicionamos ao Array
            experienciasArray.add(newExperiencia);
        }

        // Terminando o ciclo (não há mais linhas)
        return experienciasArray;
    }

    public ArrayList<Guia> guiasFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File guiasFile = new File(filePath);
        Scanner guiaScanner = new Scanner(guiasFile);

        // Criamos o ArrayList de Guias, vazio
        ArrayList<Guia> guiasArray = new ArrayList<>();

        // Avançar o cabeçalho
        guiaScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (guiaScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = guiaScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            String id = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            String telemovel = linhaSeparada[4];

            // Criar novo Guia
            Guia newGuia = new Guia(id,nome,nacionalidade,email,telemovel);

            // Adicionamos ao Array
            guiasArray.add(newGuia);
        }

        // Terminando o ciclo (não há mais linhas)
        return guiasArray;
    }

    public ArrayList<RatingExperiencia> ratingsFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File ratingsFile = new File(filePath);
        Scanner ratingScanner = new Scanner(ratingsFile);

        // Criamos o ArrayList de Ratings, vazio
        ArrayList<RatingExperiencia> ratingsArray = new ArrayList<>();

        // Avançar o cabeçalho
        ratingScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (ratingScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = ratingScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            String id = linhaSeparada[0];
            String idExperiencia = linhaSeparada[1];
            int ratingExperiencia = Integer.parseInt(linhaSeparada[2]);
            int ratingGuia = Integer.parseInt(linhaSeparada[3]);

            // Criar novo Rating
            RatingExperiencia newRating = new RatingExperiencia(id,idExperiencia,ratingExperiencia,ratingGuia);

            // Adicionamos ao Array
            ratingsArray.add(newRating);
        }

        // Terminando o ciclo (não há mais linhas)
        return ratingsArray;
    }

    public ArrayList<Reserva> reservasFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File reservasFile = new File(filePath);
        Scanner reservaScanner = new Scanner(reservasFile);

        // Criamos o ArrayList de Reservas, vazio
        ArrayList<Reserva> reservasArray = new ArrayList<>();

        // Avançar o cabeçalho
        reservaScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (reservaScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = reservaScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            String id = linhaSeparada[0];
            int numQuarto = Integer.parseInt(linhaSeparada[1]);
            String idCliente = linhaSeparada[2];
            int ano = Integer.parseInt(linhaSeparada[3]);
            int mes = Integer.parseInt(linhaSeparada[4]);
            int semana = Integer.parseInt(linhaSeparada[5]);

            // Criar nova Reserva
            Reserva newReserva = new Reserva(id,numQuarto,idCliente,ano,mes,semana);

            // Adicionamos ao Array
            reservasArray.add(newReserva);
        }

        // Terminando o ciclo (não há mais linhas)
        return reservasArray;
    }

    public ArrayList<VendaExperiencia> vendasFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File VendaExperienciaFile = new File(filePath);
        Scanner VendaExperienciaScanner = new Scanner(VendaExperienciaFile);

        // Criamos o ArrayList de VendaExperiencia, vazio
        ArrayList<VendaExperiencia> VendaExperienciaArray = new ArrayList<>();

        // Avançar o cabeçalho
        VendaExperienciaScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (VendaExperienciaScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = VendaExperienciaScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            String id = linhaSeparada[0];
            String idExperiencia = linhaSeparada[1];
            String tipoCliente = linhaSeparada[2];
            int ano = Integer.parseInt(linhaSeparada[3]);
            int mes = Integer.parseInt(linhaSeparada[4]);

            // Criar nova VendaExperiencia
            VendaExperiencia newVendaExperiencia = new VendaExperiencia(id,idExperiencia,tipoCliente,ano,mes);

            // Adicionamos ao Array
            VendaExperienciaArray.add(newVendaExperiencia);
        }

        // Terminando o ciclo (não há mais linhas)
        return VendaExperienciaArray;
    }

    public ArrayList<Quarto> quartosFileReader(String filePath, String tipologiaPath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File QuartoFile = new File(filePath);
        Scanner QuartoScanner = new Scanner(QuartoFile);

        // Criamos o ArrayList de Quarto, vazio
        ArrayList<Quarto> QuartoArray = new ArrayList<>();

        // Criamos o ArrayList de Tipologia preenchido pelo filereader correspondente
        ArrayList<Tipologia> TipologiaArray = tipologiaFileReader(tipologiaPath);

        // Avançar o cabeçalho
        QuartoScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (QuartoScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = QuartoScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            int numQuarto = Integer.parseInt(linhaSeparada[0]);
            int idTipologia = Integer.parseInt(linhaSeparada[1]);
            String descricao = TipologiaArray.get(idTipologia - 1).getDescricao(); // -1 porque o id começa em 1
            double preco = TipologiaArray.get(idTipologia - 1).getPreco(); // -1 porque o id começa em 1

            // Criar novo Quarto
            Quarto newQuarto = new Quarto(idTipologia, descricao, preco, numQuarto);

            // Adicionamos ao Array
            QuartoArray.add(newQuarto);
        }

        // Terminando o ciclo (não há mais linhas)
        return QuartoArray;
}

    public ArrayList<Tipologia> tipologiaFileReader(String filePath) throws FileNotFoundException {
        // Abrimos o ficheiro e criamos um Scanner associado
        File TipologiaFile = new File(filePath);
        Scanner TipologiaScanner = new Scanner(TipologiaFile);

        // Criamos o ArrayList de Tipologia, vazio
        ArrayList<Tipologia> TipologiaArray = new ArrayList<>();

        // Avançar o cabeçalho
        TipologiaScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (TipologiaScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = TipologiaScanner.nextLine();

            // Separamos a linha, com base no seu separador
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações
            int id = Integer.parseInt(linhaSeparada[0]);
            String descricao = linhaSeparada[1];
            double preco = Double.parseDouble(linhaSeparada[2]);

            // Criar nova Tipologia
            Tipologia newTipologia = new Tipologia(id, descricao, preco);

            // Adicionamos ao Array
            TipologiaArray.add(newTipologia);
        }

        // Terminando o ciclo (não há mais linhas)
        return TipologiaArray;
    }
}

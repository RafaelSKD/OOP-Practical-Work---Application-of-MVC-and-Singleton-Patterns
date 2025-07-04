package CESAE_Resort.Tools;

import CESAE_Resort.Models.*;
import CESAE_Resort.Repositories.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUpdate {
    private static ExperienciasRepository experienciasRepository;
    private static RatingsRepository ratingsRepository;
    private static ClientesRepository clientesRepository;
    private static GuiasRepository guiasRepository;
    private static QuartosRepository quartosRepository;
    private static ReservasRepository reservasRepository;
    private static UsersRepository usersRepository;
    private static VendasExperienciaRepository vendasExperienciaRepository;


    static {
        try {
            experienciasRepository = ExperienciasRepository.getInstance();
            ratingsRepository = RatingsRepository.getInstance();
            clientesRepository = ClientesRepository.getInstance();
            guiasRepository = GuiasRepository.getInstance();
            quartosRepository = QuartosRepository.getInstance();
            reservasRepository = ReservasRepository.getInstance();
            usersRepository = UsersRepository.getInstance();
            vendasExperienciaRepository = VendasExperienciaRepository.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            experienciasRepository = null;
            ratingsRepository = null;
            clientesRepository = null;
            guiasRepository = null;
            quartosRepository = null;
            reservasRepository = null;
            usersRepository = null;
            vendasExperienciaRepository = null;
        }
    }

    public static void updateFiles() throws IOException {


        experienciasFileUpdate(experienciasRepository, "Files/experiencias.csv");
        ratingsFileUpdate(ratingsRepository, "Files/ratings_experiencias.csv");
        clientesFileUpdate(clientesRepository, "Files/clientes.csv");
        guiasFileUpdate(guiasRepository, "Files/guias_experiencias.csv");
        quartosFileUpdate(quartosRepository, "Files/quartos.csv", "Files/tipologia.csv");
        reservasFileUpdate(reservasRepository, "Files/reservas_quartos.csv");
        usersFileUpdate(usersRepository, "Files/logins.csv");
        vendasExperienciaFileUpdate(vendasExperienciaRepository, "Files/vendas_experiencias.csv");
    }

    private static void vendasExperienciaFileUpdate(VendasExperienciaRepository vendasExperienciaRepository, String src) throws IOException {
        String primeiraLinha = "id,id_experiencia,tipo_cliente,ano,mes";

        try (FileWriter writer = new FileWriter(src, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinha + "\n");

            // Busca os dados do repositório
            ArrayList<VendaExperiencia> registros = vendasExperienciaRepository.getVendasExperienciaArray();

            for (VendaExperiencia venda : registros) {
                String linha = (
                        venda.getIdVenda() + "," +
                        venda.getIdExperiencia() + "," +
                        venda.getTipoCliente() + "," +
                        venda.getAno() + "," +
                        venda.getMes());
                writer.write(linha + "\n");
            }
        }
    }

    private static void usersFileUpdate(UsersRepository usersRepository, String src) throws IOException {
        String primeiraLinha = "username,password,tipo_acesso";

        try (FileWriter writer = new FileWriter(src, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinha + "\n");

            // Busca os dados do repositório
            ArrayList<User> registros = usersRepository.getUserArray();

            for (User user : registros) {
                String linha = (
                        user.getUsername() + "," +
                        user.getPassword() + "," +
                        user.getTipoAcesso());
                writer.write(linha + "\n");
            }
        }
    }

    private static void reservasFileUpdate(ReservasRepository reservasRepository, String src) throws IOException {
        String primeiraLinha = "id,num_quarto,id_cliente,ano,mes,semana";

        try (FileWriter writer = new FileWriter(src, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinha + "\n");

            // Busca os dados do repositório
            ArrayList<Reserva> registros = reservasRepository.getReservasArray();

            for (Reserva reserva : registros) {
                String linha = (
                        reserva.getIdReserva() + "," +
                                reserva.getNumQuarto() + "," +
                                reserva.getIdCliente() + "," +
                                reserva.getAno() + "," +
                                reserva.getMes() + "," +
                                reserva.getSemana());
                writer.write(linha + "\n");
            }
        }
    }

    private static void quartosFileUpdate(QuartosRepository quartosRepository, String src1, String src2) throws IOException {
        String primeiraLinhaQuartos = "num_quarto,id_tipologia";
        String primeiraLinhaTipologia = "id,descricao,preco_por_semana";

        try (FileWriter writer = new FileWriter(src1, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinhaQuartos + "\n");

            // Busca os dados do repositório
            ArrayList<Quarto> registros = quartosRepository.getQuartosArray();

            for (Quarto quarto : registros) {
                String linha = (
                        quarto.getNumQuarto() + "," +
                                quarto.getIdTipologia()
                );
                writer.write(linha + "\n");
            }
        }
        try (FileWriter writer = new FileWriter(src2, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinhaTipologia + "\n");

            // Busca os dados do repositório
            ArrayList<Quarto> registros = quartosRepository.getQuartosArray();

            for (Quarto quarto : registros) {
                String linha = (
                        quarto.getIdTipologia() + "," +
                        quarto.getDescricao() + "," +
                                quarto.getPreco()
                );
                writer.write(linha + "\n");
            }
        }
    }

    private static void guiasFileUpdate(GuiasRepository guiasRepository, String src) throws IOException {
        String primeiraLinha = "id,nome,nacionalidade,email,telemovel";

        try (FileWriter writer = new FileWriter(src, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinha + "\n");

            // Busca os dados do repositório
            ArrayList<Guia> registros = guiasRepository.getGuiaArray();

            for (Guia guia : registros) {
                String linha = (
                        guia.getIdGuia() + "," +
                                guia.getNome() + "," +
                                guia.getNacionalidade() + "," +
                                guia.getEmail() + "," +
                                guia.getTelemovel());
                writer.write(linha + "\n");
            }
        }
    }

    private static void clientesFileUpdate(ClientesRepository clientesRepository, String src) throws IOException {
        String primeiraLinha = "id,nome,nacionalidade,email,telemovel,data_nascimento,consentimento_marketing";

        try (FileWriter writer = new FileWriter(src, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinha + "\n");

            // Busca os dados do repositório
            ArrayList<Cliente> registros = clientesRepository.getClienteArray();

            for (Cliente cliente : registros) {
                String linha = (
                        cliente.getIdCliente() + "," +
                        cliente.getNome() + "," +
                        cliente.getNacionalidade() + "," +
                        cliente.getEmail() + "," +
                        cliente.getTelemovel() + "," +
                        cliente.getDataNascimento() + "," +
                        cliente.isConsentimentoMarketing()
                        );
                writer.write(linha + "\n");
            }
        }
    }

    private static void ratingsFileUpdate(RatingsRepository ratingsRepository, String src) throws IOException {
        String primeiraLinha = "id,id_experiencia,rating_experiencia,rating_guia";

        try (FileWriter writer = new FileWriter(src, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinha + "\n");

            // Busca os dados do repositório
            ArrayList<RatingExperiencia> registros = ratingsRepository.getRatingsArray();

            for (RatingExperiencia rating : registros) {
                String linha = (
                        rating.getIdRating() + "," +
                                rating.getIdExperiencia() + "," +
                                rating.getRatingExperiencia() + "," +
                                rating.getRatingGuia()
                );
                writer.write(linha + "\n");
            }
        }
    }

    private static void experienciasFileUpdate(ExperienciasRepository repository, String src) throws IOException {
        String primeiraLinha = "id,nome,id_guia_experiencia,preco_adulto,preco_crianca";

        try (FileWriter writer = new FileWriter(src, false)) { // 'false' para sobrescrever
            // Escreve o cabeçalho
            writer.write(primeiraLinha + "\n");

            // Busca os dados do repositório
            ArrayList<Experiencia> registros = experienciasRepository.getExperienciasArray();

            for (Experiencia experiencia : registros) {
                String linha = (
                        experiencia.getIdExperiencia() + "," +
                                experiencia.getNome() + "," +
                                experiencia.getIdGuia() + "," +
                                experiencia.getPrecoAdulto() + "," +
                                experiencia.getPrecoCrianca()
                );
                writer.write(linha + "\n");
            }
        }
    }
}

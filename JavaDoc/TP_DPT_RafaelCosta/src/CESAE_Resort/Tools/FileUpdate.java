package CESAE_Resort.Tools;

import CESAE_Resort.Models.*;
import CESAE_Resort.Repositories.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe responsável por atualizar os ficheiros CSV com os dados
 * atuais de cada repositório.
 */
public class FileUpdate {
    // Repositórios usados para obter os dados a guardar nos ficheiros
    private static ExperienciasRepository experienciasRepository;
    private static RatingsRepository ratingsRepository;
    private static ClientesRepository clientesRepository;
    private static GuiasRepository guiasRepository;
    private static QuartosRepository quartosRepository;
    private static ReservasRepository reservasRepository;
    private static UsersRepository usersRepository;
    private static VendasExperienciaRepository vendasExperienciaRepository;

    // Bloco estático para instanciar os repositórios singleton
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
            // Se houver erro ao obter instâncias, definimos como null
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

    /**
     * Atualiza todos os ficheiros CSV com os dados atuais de cada repositório.
     */
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

    /**
     * Atualiza o ficheiro de vendas de experiências.
     */
    private static void vendasExperienciaFileUpdate(VendasExperienciaRepository vendasExperienciaRepository, String src) throws IOException {
        String primeiraLinha = "id,id_experiencia,tipo_cliente,ano,mes";

        try (FileWriter writer = new FileWriter(src, false)) {
            writer.write(primeiraLinha + "\n"); // Escreve o cabeçalho

            for (VendaExperiencia venda : vendasExperienciaRepository.getVendasExperienciaArray()) {
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

    /**
     * Atualiza o ficheiro de utilizadores (logins).
     */
    private static void usersFileUpdate(UsersRepository usersRepository, String src) throws IOException {
        String primeiraLinha = "username,password,tipo_acesso";

        try (FileWriter writer = new FileWriter(src, false)) {
            writer.write(primeiraLinha + "\n");

            for (User user : usersRepository.getUserArray()) {
                String linha = (
                        user.getUsername() + "," +
                                user.getPassword() + "," +
                                user.getTipoAcesso());
                writer.write(linha + "\n");
            }
        }
    }

    /**
     * Atualiza o ficheiro de reservas de quartos.
     */
    private static void reservasFileUpdate(ReservasRepository reservasRepository, String src) throws IOException {
        String primeiraLinha = "id,num_quarto,id_cliente,ano,mes,semana";

        try (FileWriter writer = new FileWriter(src, false)) {
            writer.write(primeiraLinha + "\n");

            for (Reserva reserva : reservasRepository.getReservasArray()) {
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

    /**
     * Atualiza dois ficheiros: um com os quartos e outro com a sua tipologia.
     */
    private static void quartosFileUpdate(QuartosRepository quartosRepository, String src1, String src2) throws IOException {
        String primeiraLinhaQuartos = "num_quarto,id_tipologia";
        String primeiraLinhaTipologia = "id,descricao,preco_por_semana";

        // Ficheiro com os quartos
        try (FileWriter writer = new FileWriter(src1, false)) {
            writer.write(primeiraLinhaQuartos + "\n");

            for (Quarto quarto : quartosRepository.getQuartosArray()) {
                String linha = (
                        quarto.getNumQuarto() + "," +
                                quarto.getIdTipologia());
                writer.write(linha + "\n");
            }
        }

        // Ficheiro com as tipologias (pode ter repetições se não controlares)
        try (FileWriter writer = new FileWriter(src2, false)) {
            writer.write(primeiraLinhaTipologia + "\n");

            for (Quarto quarto : quartosRepository.getQuartosArray()) {
                String linha = (
                        quarto.getIdTipologia() + "," +
                                quarto.getDescricao() + "," +
                                quarto.getPreco());
                writer.write(linha + "\n");
            }
        }
    }

    /**
     * Atualiza o ficheiro dos guias de experiências.
     */
    private static void guiasFileUpdate(GuiasRepository guiasRepository, String src) throws IOException {
        String primeiraLinha = "id,nome,nacionalidade,email,telemovel";

        try (FileWriter writer = new FileWriter(src, false)) {
            writer.write(primeiraLinha + "\n");

            for (Guia guia : guiasRepository.getGuiaArray()) {
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

    /**
     * Atualiza o ficheiro dos clientes.
     */
    private static void clientesFileUpdate(ClientesRepository clientesRepository, String src) throws IOException {
        String primeiraLinha = "id,nome,nacionalidade,email,telemovel,data_nascimento,consentimento_marketing";

        try (FileWriter writer = new FileWriter(src, false)) {
            writer.write(primeiraLinha + "\n");

            for (Cliente cliente : clientesRepository.getClienteArray()) {
                String linha = (
                        cliente.getIdCliente() + "," +
                                cliente.getNome() + "," +
                                cliente.getNacionalidade() + "," +
                                cliente.getEmail() + "," +
                                cliente.getTelemovel() + "," +
                                cliente.getDataNascimento() + "," +
                                cliente.isConsentimentoMarketing());
                writer.write(linha + "\n");
            }
        }
    }

    /**
     * Atualiza o ficheiro dos ratings das experiências.
     */
    private static void ratingsFileUpdate(RatingsRepository ratingsRepository, String src) throws IOException {
        String primeiraLinha = "id,id_experiencia,rating_experiencia,rating_guia";

        try (FileWriter writer = new FileWriter(src, false)) {
            writer.write(primeiraLinha + "\n");

            for (RatingExperiencia rating : ratingsRepository.getRatingsArray()) {
                String linha = (
                        rating.getIdRating() + "," +
                                rating.getIdExperiencia() + "," +
                                rating.getRatingExperiencia() + "," +
                                rating.getRatingGuia());
                writer.write(linha + "\n");
            }
        }
    }

    /**
     * Atualiza o ficheiro das experiências.
     */
    private static void experienciasFileUpdate(ExperienciasRepository repository, String src) throws IOException {
        String primeiraLinha = "id,nome,id_guia_experiencia,preco_adulto,preco_crianca";

        try (FileWriter writer = new FileWriter(src, false)) {
            writer.write(primeiraLinha + "\n");

            for (Experiencia experiencia : repository.getExperienciasArray()) {
                String linha = (
                        experiencia.getIdExperiencia() + "," +
                                experiencia.getNome() + "," +
                                experiencia.getIdGuia() + "," +
                                experiencia.getPrecoAdulto() + "," +
                                experiencia.getPrecoCrianca());
                writer.write(linha + "\n");
            }
        }
    }
}

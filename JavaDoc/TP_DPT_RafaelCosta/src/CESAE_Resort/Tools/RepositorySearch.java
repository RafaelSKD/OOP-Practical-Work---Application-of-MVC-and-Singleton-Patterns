package CESAE_Resort.Tools;

import CESAE_Resort.Models.*;
import CESAE_Resort.Repositories.*;

import java.io.FileNotFoundException;

/**
 * Classe utilitária para procurar e manipular dados nos repositórios da aplicação.
 */
public class RepositorySearch {

    private static ExperienciasRepository experienciasRepository;
    private static RatingsRepository ratingsRepository;
    private static ClientesRepository clientesRepository;
    private static GuiasRepository guiasRepository;
    private static QuartosRepository quartosRepository;
    private static ReservasRepository reservasRepository;
    private static UsersRepository usersRepository;
    private static VendasExperienciaRepository vendasExperienciaRepository;

    // Inicialização estática dos repositórios
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

    /**
     * Verifica se existe uma experiência com o nome fornecido.
     *
     * @param experiencia Nome da experiência a procurar.
     * @return true se a experiência existir, false caso contrário.
     */
    public static boolean verificarExperiencia(String experiencia) {
        if (experienciasRepository == null) {
            return false;
        }
        for (Experiencia exp : experienciasRepository.getExperienciasArray()) {
            if (exp.getNome().equalsIgnoreCase(experiencia)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cria e adiciona uma nova avaliação (rating) para uma experiência.
     *
     * @param experiencia       Nome da experiência avaliada.
     * @param ratingExperiencia Valor da avaliação da experiência.
     * @param ratingGuia        Valor da avaliação do guia.
     */
    public static void preencherRatingExperiencia(String experiencia, String ratingExperiencia, String ratingGuia) {
        // Obtém o último ID de rating, remove o prefixo "T" para pegar apenas o número
        String lastid = ratingsRepository.getRatingsArray().get(
                ratingsRepository.getRatingsArray().size() - 1).getIdRating().replace("T", "");

        // Incrementa o número para gerar um novo ID
        int newIdNumber = Integer.parseInt(lastid) + 1;

        // Começa a montar o novo ID com prefixo "T"
        String newId = "T";
        // Formata o ID com zeros à esquerda para manter padrão de 3 dígitos (ex: T001, T012, T123)
        if (newIdNumber < 100) {
            if (newIdNumber < 10)
                newId += "0";
            newId += "0";
        }
        newId += newIdNumber;

        // Encontra o ID da experiência a partir do nome fornecido
        String experienciaId = encontrarIdExperiencia(experiencia);

        // Cria um novo objeto RatingExperiencia com o novo ID e ratings convertidos para inteiro
        RatingExperiencia newRating = new RatingExperiencia(
                newId,
                experienciaId,
                Integer.parseInt(ratingExperiencia),
                Integer.parseInt(ratingGuia)
        );

        // Adiciona o novo rating no repositório
        ratingsRepository.addRating(newRating);

    }

    /**
     * Retorna o ID da experiência com o nome fornecido.
     *
     * @param experiencia Nome da experiência.
     * @return ID da experiência, ou "error" se não encontrada.
     */
    public static String encontrarIdExperiencia(String experiencia) {
        for (Experiencia exp : experienciasRepository.getExperienciasArray()) {
            if (exp.getNome().equalsIgnoreCase(experiencia)) {
                return exp.getIdExperiencia();
            }
        }
        return "error";
    }

    /**
     * Retorna uma informação específica de um cliente com base no seu ID.
     *
     * @param target    Campo desejado (ex: "nome", "email").
     * @param idCliente ID do cliente.
     * @return Valor do campo desejado, ou "error" se não encontrado.
     */
    public static String getInfoCliente(String target, String idCliente) {
        for (Cliente cliente : clientesRepository.getClienteArray()) {
            if (cliente.getIdCliente().equals(idCliente)) {
                switch (target) {
                    case "nome":
                        return cliente.getNome();
                    case "nacionalidade":
                        return cliente.getNacionalidade();
                    case "email":
                        return cliente.getEmail();
                    case "telemovel":
                        return cliente.getTelemovel();
                    case "dataNascimento":
                        return cliente.getDataNascimento();
                    case "consentimentoMarketing":
                        return String.valueOf(cliente.isConsentimentoMarketing());
                }
            }
        }
        return "error";
    }

    /**
     * Retorna uma informação específica de um quarto com base no número do quarto.
     *
     * @param target    Campo desejado (ex: "tipologia", "preco").
     * @param numQuarto Número do quarto.
     * @return Valor do campo desejado, ou "error" se não encontrado.
     */
    public static String getInfoQuarto(String target, int numQuarto) {
        for (Quarto quarto : quartosRepository.getQuartosArray()) {
            if (quarto.getNumQuarto() == numQuarto) {
                switch (target) {
                    case "idTipologia":
                        return String.valueOf(quarto.getIdTipologia());
                    case "tipologia":
                        return quarto.getDescricao();
                    case "preco":
                        return String.valueOf(quarto.getPreco());
                }
            }
        }
        return "error";
    }

    /**
     * Retorna uma informação específica de um guia com base no seu ID.
     *
     * @param target Campo desejado (ex: "nome", "email").
     * @param idGuia ID do guia.
     * @return Valor do campo desejado, ou "error" se não encontrado.
     */
    public static String getGuiaInfo(String target, String idGuia) {
        for (Guia guia : guiasRepository.getGuiaArray()) {
            if (guia.getIdGuia().equals(idGuia)) {
                switch (target) {
                    case "nome":
                        return guia.getNome();
                    case "nacionalidade":
                        return guia.getNacionalidade();
                    case "email":
                        return guia.getEmail();
                    case "telemovel":
                        return guia.getTelemovel();
                }
            }
        }
        return "error";
    }

    /**
     * Retorna uma informação específica de uma experiência com base no seu ID.
     *
     * @param target        Campo desejado (ex: "nome", "precoAdulto").
     * @param idExperiencia ID da experiência.
     * @return Valor do campo desejado, ou "error" se não encontrado.
     */
    public static String getInfoExperiencia(String target, String idExperiencia) {
        for (Experiencia experiencia : experienciasRepository.getExperienciasArray()) {
            if (experiencia.getIdExperiencia().equals(idExperiencia)) {
                switch (target) {
                    case "nome":
                        return experiencia.getNome();
                    case "idGuia":
                        return experiencia.getIdGuia();
                    case "precoAdulto":
                        return String.valueOf(experiencia.getPrecoAdulto());
                    case "precoCrianca":
                        return String.valueOf(experiencia.getPrecoCrianca());
                }
            }
        }
        return "error";
    }

    /**
     * Retorna um objeto Guia com base no ID fornecido.
     *
     * @param id ID do guia a procurar.
     * @return Objeto Guia correspondente, ou null se não encontrado.
     */
    public static Guia findGuia(String id) {
        for (Guia guia : guiasRepository.getGuiaArray()) {
            if (guia.getIdGuia().equals(id)) {
                return guia;
            }
        }
        return null;
    }
}

package CESAE_Resort.Controllers;

import CESAE_Resort.Models.Experiencia;
import CESAE_Resort.Models.RatingExperiencia;
import CESAE_Resort.Repositories.*;

import java.io.FileNotFoundException;


public class ClienteController {

    private static ExperienciasRepository experienciasRepository;
    private static RatingsRepository ratingsRepository;

    static {
        try {
            experienciasRepository = ExperienciasRepository.getInstance();
            ratingsRepository = RatingsRepository.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            experienciasRepository = null;
            ratingsRepository = null;
        }
    }

    // Consultar Quartos Disponíveis: Imprime em formato tabelar num_quarto, tipologia, preco_por_semana.
    public static void consultarQuartosDisponiveis(){}

    // Consultar Experiências Disponíveis: Imprime em formato tabelar, nome, rating_experiencia, nome do guia, rating_guia, preco_adulto, preco_crianca.
    public static void consultarExperienciasDisponiveis(){}

    // Consultar Experiência Favorita: Indica a experiência com melhor rating.
    public static void consultarExperienciaFavorita(){}

    // Consultar Experiência Top-Seller: Indica a experiência com mais bilhetes vendidos.
    public static void consultarTopSeller(){}

    // Verificar se existe a experiencia
    public static boolean verificarExperiencia(String experiencia) {
        if (experienciasRepository == null) {
            return false;
        }
        for (Experiencia exp  : experienciasRepository.getExperienciasArray()) {
            if (exp.getNome().equalsIgnoreCase(experiencia)) {
                return true;
            }
        }
        return false;
    }

    // preencher
    public static void preencherRatingExperiencia(String experiencia, String ratingExperiencia, String ratingGuia){
        String lastid = ratingsRepository.getRatingsArray().get(ratingsRepository.getRatingsArray().size() - 1).getIdRating().replace("T", "");; // Vai buscar o ultimo id de rating e tira o T ex: "T001" = "001"

        int newIdNumber = Integer.parseInt(lastid) + 1; // transforma em int e incrementa o id "001" = 1 += 1 = 2

        String newId = "T";
        if (newIdNumber < 100){ // Se for inferior a 100 precisa de pelo menos um zero a esquerda
            if (newIdNumber < 10) // Se for inferior a 10 precisa 2 zeros a esquerda
                newId += "0"; // acrescenta um primeiro 0
            newId += "0"; // acrescenta segundo ou um unico zero se for > 9
        }
        newId += newIdNumber; // acrescenta o numero incrementado

        String experienciaId = encontrarIdExperiencia(experiencia);

        RatingExperiencia newRating = new RatingExperiencia(newId, experienciaId, Integer.parseInt(ratingExperiencia), Integer.parseInt(ratingGuia));

        ratingsRepository.addRating(newRating);
    }

    // metodo para procurar id da experiencia, esta ja foi filtrada anteriormente
    public static String encontrarIdExperiencia(String experiencia) {
        for (Experiencia exp  : experienciasRepository.getExperienciasArray()) {
            if (exp.getNome().equalsIgnoreCase(experiencia)) {
                return exp.getIdExperiencia();
            }
        }
        return "ERROR";
    }
}

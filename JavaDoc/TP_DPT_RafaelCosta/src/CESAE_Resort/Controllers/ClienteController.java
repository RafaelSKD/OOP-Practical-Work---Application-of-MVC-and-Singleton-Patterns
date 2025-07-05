package CESAE_Resort.Controllers;

import CESAE_Resort.Models.Experiencia;
import CESAE_Resort.Models.Guia;
import CESAE_Resort.Models.RatingExperiencia;
import CESAE_Resort.Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static CESAE_Resort.Tools.RepositorySearch.findGuia;

/**
 * Classe responsável pelas funcionalidades disponíveis para o cliente,
 * incluindo consulta e avaliação de experiências.
 */
public class ClienteController {

    private static ExperienciasRepository experienciasRepository;
    private static RatingsRepository ratingsRepository;

    // Bloco estático para carregar os repositórios necessários
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

    /**
     * Consulta todas as experiências disponíveis com detalhes:
     * nome, rating médio da experiência, nome e rating do guia,
     * preço por adulto e por criança.
     *
     * @return Lista de strings formatadas com detalhes de cada experiência.
     */
    public static ArrayList<String> consultarExperienciasDisponiveis() {
        // Cria lista para guardar as experiências formatadas
        ArrayList<String> experiencias = new ArrayList<>();

        // Percorre todas as experiências do repositório
        for (Experiencia experiencia : experienciasRepository.getExperienciasArray()) {
            // Monta a string com dados da experiência e adiciona na lista
            experiencias.add(
                    "Nome: " + experiencia.getNome() + "\n" +
                            "Rating Experiencia: " + calcularRatingExperiencia(experiencia) + "\n" +  // calcula média rating da experiência
                            "Nome do Guia: " + findGuia(experiencia.getIdGuia()).getNome() + "\n" +    // busca nome do guia
                            "Rating Guia: " + calcularRatingGuia(findGuia(experiencia.getIdGuia())) + "\n" +  // calcula média rating do guia
                            "Preco Adulto: " + experiencia.getPrecoAdulto() + "$ \n" +
                            "Preco Crianca: " + experiencia.getPrecoCrianca() + "$"
            );
        }

        // Retorna lista pronta para exibir
        return experiencias;
    }

    /**
     * Calcula o rating médio de todas as experiências associadas a um guia.
     *
     * @param guia Guia para o qual será calculado o rating médio.
     * @return Média dos ratings das experiências do guia.
     */
    private static double calcularRatingGuia(Guia guia) {
        ArrayList<Experiencia> experienciasGuia = new ArrayList<>();

        // Obtem todas as experiências administradas pelo guia
        for (Experiencia experiencia : experienciasRepository.getExperienciasArray()) {
            if (experiencia.getIdGuia().equals(guia.getIdGuia())) {
                experienciasGuia.add(experiencia);
            }
        }

        double ratingTotal = 0;
        int qntRatings = 0;

        // Soma os ratings associados às experiências do guia
        for (RatingExperiencia rating : ratingsRepository.getRatingsArray()) {
            for (Experiencia experiencia : experienciasGuia) {
                if (rating.getIdExperiencia().equals(experiencia.getIdExperiencia())) {
                    qntRatings++;
                    ratingTotal += rating.getRatingGuia();
                }
            }
        }

        return qntRatings == 0 ? 0 : ratingTotal / qntRatings; // Evita divisão por zero
    }

    /**
     * Calcula o rating médio de uma experiência específica.
     *
     * @param experiencia Experiência cujo rating será calculado.
     * @return Média dos ratings da experiência.
     */
    private static double calcularRatingExperiencia(Experiencia experiencia) {
        double ratingTotal = 0; // soma dos ratings da experiência
        int qntRatings = 0;     // contador de ratings encontrados

        // percorre todos os ratings do repositório
        for (RatingExperiencia rating : ratingsRepository.getRatingsArray()) {
            // verifica se o rating corresponde à experiência atual
            if (rating.getIdExperiencia().equals(experiencia.getIdExperiencia())) {
                qntRatings++;                       // conta o rating
                ratingTotal += rating.getRatingExperiencia(); // soma o valor do rating
            }
        }

        // retorna a média dos ratings, evita divisão por zero retornando 0 se não houver ratings
        return qntRatings == 0 ? 0 : ratingTotal / qntRatings;

    }

    /**
     * Exibe a experiência com o melhor rating médio.
     * (Funcionalidade ainda não implementada)
     */
    public static void consultarExperienciaFavorita() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Exibe a experiência com mais bilhetes vendidos.
     * (Funcionalidade ainda não implementada)
     */
    public static void consultarTopSeller() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }
}

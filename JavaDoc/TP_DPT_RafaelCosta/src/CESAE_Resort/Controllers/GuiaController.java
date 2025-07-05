package CESAE_Resort.Controllers;

import CESAE_Resort.Models.Experiencia;
import CESAE_Resort.Models.VendaExperiencia;
import CESAE_Resort.Repositories.ExperienciasRepository;
import CESAE_Resort.Repositories.VendasExperienciaRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável pelas operações relacionadas a Guias.
 */
public class GuiaController {
    private static ExperienciasRepository experienciasRepository;
    private static VendasExperienciaRepository vendasExperienciaRepository;

    static {
        try {
            experienciasRepository = ExperienciasRepository.getInstance();
            vendasExperienciaRepository = VendasExperienciaRepository.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            experienciasRepository = null;
            vendasExperienciaRepository = null;
        }
    }

    /**
     * Obtém todas as experiências atribuídas a um guia pelo seu ID.
     *
     * @param id ID do guia.
     * @return Lista de strings com informações das experiências do guia.
     */
    public static ArrayList<String> findExperienciasGuia(String id) {
        ArrayList<String> experiencias = new ArrayList<>();

        // Percorre todas as experiências do repositório
        for (Experiencia experiencia : experienciasRepository.getExperienciasArray()) {
            // Filtra as experiências que pertencem ao guia com o id informado
            if (experiencia.getIdGuia().equals(id)) {
                // Formata a descrição da experiência com preços
                String str = "Experiencia: " + experiencia.getNome() + "\n" +
                        "Preco Adulto: " + experiencia.getPrecoAdulto() + "$\n" +
                        "Preco Crianca: " + experiencia.getPrecoCrianca() + "$\n";
                experiencias.add(str); // adiciona à lista de resultados
            }
        }

        return experiencias; // retorna lista de experiências do guia
    }

    /**
     * Calcula totais relacionados às vendas de experiências de um guia.
     *
     * @param target Tipo a devolver: "criancas" (número de crianças),
     *               "adultos" (número de adultos), ou "total" (valor arrecadado).
     * @param id     ID do guia.
     * @return Valor total correspondente ao target, ou -1 se target inválido.
     */
    public static double calcularTotalVendas(String target, String id) {
        double total = 0;
        int adulto = 0;
        int crianca = 0;

        // Percorre todas as experiências para o guia especificado
        for (Experiencia experiencia : experienciasRepository.getExperienciasArray()) {
            if (experiencia.getIdGuia().equals(id)) {
                // Para cada venda, verifica se é referente à experiência do guia
                for (VendaExperiencia venda : vendasExperienciaRepository.getVendasExperienciaArray()) {
                    if (venda.getIdExperiencia().equals(experiencia.getIdExperiencia())) {
                        // Conta e soma os valores para adultos
                        if (venda.getTipoCliente().equalsIgnoreCase("adulto")) {
                            adulto++;
                            total += experiencia.getPrecoAdulto();
                        }
                        // Conta e soma os valores para crianças
                        if (venda.getTipoCliente().equalsIgnoreCase("crianca")) {
                            crianca++;
                            total += experiencia.getPrecoCrianca(); // Corrigido para precoCrianca
                        }
                    }
                }
            }
        }

        // Retorna a quantidade ou total solicitado conforme o parâmetro 'target'
        return switch (target.toLowerCase()) {
            case "criancas" -> crianca;
            case "adultos" -> adulto;
            case "total" -> total;
            default -> -1; // Caso inválido
        };

    }
}

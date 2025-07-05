package CESAE_Resort.Controllers;

import CESAE_Resort.Models.Data;
import CESAE_Resort.Models.Quarto;
import CESAE_Resort.Models.Reserva;
import CESAE_Resort.Repositories.ClientesRepository;
import CESAE_Resort.Repositories.QuartosRepository;
import CESAE_Resort.Repositories.ReservasRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static CESAE_Resort.Tools.RepositorySearch.getInfoCliente;
import static CESAE_Resort.Tools.RepositorySearch.getInfoQuarto;

/**
 * Classe responsável pelas funcionalidades de gestão
 */
public class GestaoController {

    private static ReservasRepository reservasRepository;
    private static QuartosRepository quartosRepository;
    private static ClientesRepository clientesRepository;

    static {
        try {
            reservasRepository = ReservasRepository.getInstance();
            quartosRepository = QuartosRepository.getInstance();
            clientesRepository = ClientesRepository.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            reservasRepository = null;
            quartosRepository = null;
            clientesRepository = null;
        }
    }

    /**
     * Consulta os quartos disponíveis na semana atual.
     *
     * @return Lista de strings contendo número do quarto, tipologia e preço por semana.
     */
    public static ArrayList<String> consultarQuartosDisponiveis() {
        Data data = new Data(); // Obtém a data atual (ano, mês, semana)
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>(quartosRepository.getQuartosArray()); // Copia lista de quartos

        // Remove quartos já reservados na semana atual
        for (Quarto quarto : quartosRepository.getQuartosArray()) {
            for (Reserva reserva : reservasRepository.getReservasArray()) {
                if (
                        reserva.getAno() == data.getAno() &&
                                reserva.getMes() == data.getMes() &&
                                reserva.getSemana() == data.getSemana() &&
                                reserva.getNumQuarto() == quarto.getNumQuarto()
                ) {
                    quartosDisponiveis.remove(quarto); // Remove quarto reservado
                }
            }
        }

        ArrayList<String> quartos = new ArrayList<>();

        // Prepara lista para exibição ou mensagem caso vazio
        if (!quartosDisponiveis.isEmpty()) {
            for (Quarto quarto : quartosDisponiveis) {
                quartos.add(
                        "Numero de quarto: " + quarto.getNumQuarto() + "\n" +
                                "Tipologia: " + quarto.getDescricao() + "\n" +
                                "Preco por semana: " + quarto.getPreco()
                );
            }
        } else {
            quartos.add("Sem quartos Disponiveis!");
        }

        return quartos; // Retorna lista formatada ou mensagem de indisponibilidade

    }

    /**
     * Consulta os quartos reservados na semana atual.
     *
     * @return Lista de strings contendo dados do quarto e do cliente associado à reserva.
     */
    public static ArrayList<String> consultarQuartosReservados() {
        ArrayList<String> reservas = new ArrayList<>();
        Data data = new Data(); // Data atual (ano, mês, semana)

        // Percorre todas as reservas para a semana atual
        for (Reserva reserva : reservasRepository.getReservasArray()) {
            if (reserva.getSemana() == data.getSemana() &&
                    reserva.getAno() == data.getAno() &&
                    reserva.getMes() == data.getMes()) {

                // Monta uma linha com detalhes da reserva e do cliente
                String linha = ("\n\n" +
                        "\nNumero do quarto: " + reserva.getNumQuarto() +
                        "\nTipologia: " + getInfoQuarto("tipologia", reserva.getNumQuarto()) +
                        "\nID Cliente: " + reserva.getIdCliente() +
                        "\nNome: " + getInfoCliente("nome", reserva.getIdCliente()) +
                        "\nEmail: " + getInfoCliente("email", reserva.getIdCliente()) +
                        "\nNacionalidade: " + getInfoCliente("nacionalidade", reserva.getIdCliente()) +
                        "\nAno: " + data.getAno() +
                        "\nMes: " + data.getMes() +
                        "\nSemana: " + data.getSemana()
                );
                reservas.add(linha); // Adiciona à lista de reservas formatadas
            }
        }

        // Caso não haja reservas, adiciona mensagem
        if (reservas.isEmpty()) {
            reservas.add("Sem quartos Reservados!");
        }

        return reservas; // Retorna lista de reservas ou mensagem

    }

    /**
     * Consulta todas as reservas atuais (semana atual).
     *
     * @return Lista de strings contendo dados resumidos do quarto e cliente.
     */
    public static ArrayList<String> consultarReservasAtuais() {
        ArrayList<String> reservas = new ArrayList<>();
        Data data = new Data(); // Obtém a data atual (ano, mês, semana)

        // Filtra reservas para a semana, mês e ano atuais
        for (Reserva reserva : reservasRepository.getReservasArray()) {
            if (reserva.getSemana() == data.getSemana() &&
                    reserva.getAno() == data.getAno() &&
                    reserva.getMes() == data.getMes()) {

                // Monta string com detalhes da reserva e cliente
                String linha = ("\n\n" +
                        "\nNumero do quarto: " + reserva.getNumQuarto() +
                        "\nTipologia: " + getInfoQuarto("tipologia", reserva.getNumQuarto()) +
                        "\nID Cliente: " + reserva.getIdCliente() +
                        "\nNome: " + getInfoCliente("nome", reserva.getIdCliente()) +
                        "\nEmail: " + getInfoCliente("email", reserva.getIdCliente()) +
                        "\nNacionalidade: " + getInfoCliente("nacionalidade", reserva.getIdCliente())
                );
                reservas.add(linha);
            }
        }

        // Se não houver reservas, retorna mensagem padrão
        if (reservas.isEmpty()) {
            reservas.add("Sem quartos Reservados!");
        }

        return reservas; // Retorna lista com reservas formatadas ou mensagem

    }

    /**
     * Efetua uma nova reserva de quarto.
     * <p><b>Nota:</b> Método ainda não implementado.</p>
     */
    public static void efetuarNovaReserva() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }

    /**
     * Efetua uma reserva de experiência para um cliente.
     * <p><b>Nota:</b> Método ainda não implementado.</p>
     */
    public static void reservarExperiencia() {
        System.out.println("\n[ERRO]: Funcionalidade não implementada. Contate o administrador ou verifique futuras atualizações.");
    }
}

package CESAE_Resort.Controllers;


import CESAE_Resort.Models.Cliente;
import CESAE_Resort.Models.Quarto;
import CESAE_Resort.Models.Reserva;
import CESAE_Resort.Repositories.ClientesRepository;
import CESAE_Resort.Repositories.QuartosRepository;
import CESAE_Resort.Repositories.ReservasRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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


    // Consultar Quartos Disponíveis: Imprime em formato tabelar num_quarto, tipologia, preco_por_semana, que estão disponíveis na semana atual.
    public static void consultarQuartosDisponiveis(){}


    // Consultar Quartos Reservados: Imprime em formato tabelar num_quarto, tipologia, idCliente, nome, email, nacionalidade, ano, mês e semana.
    public static void consultarQuartosReservados(){
    }


    // Consultar Reservas Atuais: Imprime em formato tabelar num_quarto, tipologia, idCliente, nome, email, nacionalidade, as reservas da semana atual.
    public static ArrayList<String> consultarReservasAtuais(){
        ArrayList<String> reservas = new ArrayList<>();

        for (Reserva reserva  : reservasRepository.getReservasArray()) {
            if (reserva.getSemana() == 1 && reserva.getAno() == 2025 && reserva.getMes() == 7){
                String linha = ( "\n\n" +
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
        return reservas;
    }

    private static String getInfoCliente(String target, String idCliente) {
        for (Cliente cliente : clientesRepository.getClienteArray()) {
            if (cliente.getIdCliente().equals(idCliente)) {
                if (target.equals("nome"))
                    return cliente.getNome();
                if (target.equals("email"))
                    return cliente.getEmail();
                if (target.equals("nacionalidade"))
                    return cliente.getNacionalidade();
            }
        }
        return "error";
    }

    private static String getInfoQuarto(String target, int numQuarto) {
        for (Quarto quarto : quartosRepository.getQuartosArray()){
            if (quarto.getNumQuarto() == numQuarto){
                if (target.equals("tipologia"))
                    return quarto.getDescricao();
            }
        }
        return "error";
    }


    // Efetuar uma Reserva: Pergunta as informações como idCliente, numQuarto, ano, mês e semana. Seguidamente verifica se o quarto está disponível e, se possível, efetua a reserva.
    public static void efetuarNovaReserva(){}


    // Reservar uma Experiência: Pergunta as informações como idCliente e idReserva, número de adultos e número de crianças e efetua reserva de uma experiência.
    public static void reservarExperiencia(){}

}

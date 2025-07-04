package CESAE_Resort.Controllers;


import CESAE_Resort.Repositories.ExperienciasRepository;

import java.io.FileNotFoundException;

public class AdminController {
    private static ExperienciasRepository experienciasRepository;

    static {
        try {
            experienciasRepository = ExperienciasRepository.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            experienciasRepository = null;
        }
    }

    // Consultar Total de Reservas: Número total de reservas (passadas e futuras).
    public static int consultarReservas(){
        return experienciasRepository.getExperienciasArray().size();
    }


    // Consultar Total de Receitas: Soma de preco_por_semana (quartos) + preços de bilhetes (experiências).
    public static void consultarTotalReceitas(){}


    // Consultar Reservas/Receitas Mensais: Pergunta ano e mês, apresenta receitas desse mês.
    public static void consultarReservasReceitasMensais(){}


    // Consultar Tipologia de Quarto Mais Reservada.
    public static void consultarTipologiaTop(){}


    // Consultar Experiência Mais Procurada (Adultos): Número de bilhetes vendidos.
    public static void consultarExperienciaTopAdulto(){}


    // Consultar Experiência Mais Procurada (Crianças): Número de bilhetes vendidos.
    public static void consultarExperienciaTopCrianca(){}


    // Consultar Experiência Mais Lucrativa: Valor total arrecadado.
    public static void consultarExperienciaTop(){}


    // Consultar Experiência Menos Lucrativa: Valor total arrecadado.
    public static void consultarExperienciaLow(){}


    // Consultar Quarto com Melhor Preço/Semana.
    public static void consultarBestRoom(){}


    // Adicionar Novo Login.
    public static void addNewLogin(){}


}

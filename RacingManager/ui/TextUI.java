/*
 *  DISCLAIMER: Este código foi criado para discussão e edição durante as aulas práticas de DSS, representando
 *  uma solução em construção. Como tal, não deverá ser visto como uma solução canónica, ou mesmo acabada.
 *  É disponibilizado para auxiliar o processo de estudo. Os alunos são encorajados a testar adequadamente o
 *  código fornecido e a procurar soluções alternativas, à medida que forem adquirindo mais conhecimentos.
 */
package RacingManager.ui;

import RacingManager.business.*;

import java.util.Scanner;

/**
 * Exemplo de interface em modo texto.
 *
 * @author JFC
 * @version 20220919
 */
public class TextUI {
    // O model tem a 'lógica de negócio'.
    private ICampeonatoFacade model;
    private ICorridaFacade model1;
    private IJogadorFacade model2;

    // Menus da aplicação
    private Menu menu;

    // Scanner para leitura
    private Scanner scin;

    /**
     * Construtor.
     *
     * Cria os menus e a camada de negócio.
     */
    public TextUI() {
        // Criar o menu
        this.menu = new Menu(new String[]{
                "Começar um campeonato",
                "Listar Campeonatos"
        });
        this.menu.setHandler(1, this::startChamp);
        this.menu.setHandler(2, this::ListChamp);

        this.model = new CampeonatoFacade();
        this.model1 = new CorridaFacade();
        this.model2 = new JogadorFacade();
        scin = new Scanner(System.in);
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    public void run() {
        this.menu.run();
        System.out.println("Até breve!...");
    }

    // Métodos auxiliares
    private void startChamp() {
        //Scanner scin = new Scanner(System.in);
        try {
            System.out.println("Nome do campeonato: ");
            String nomeCamp = scin.nextLine();
            if (!this.model.existeCampeonato(nomeCamp)) {
                this.model.adicionaCampeonato(new Campeonato(nomeCamp));
                System.out.println("Campeonato adicionado");
            } else {
                System.out.println("Esse número de turma já existe!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void ListChamp() {
        try {
            System.out.println(this.model.getCampeonatos().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}

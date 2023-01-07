/*
 *  DISCLAIMER: Este código foi criado para discussão e edição durante as aulas práticas de DSS, representando
 *  uma solução em construção. Como tal, não deverá ser visto como uma solução canónica, ou mesmo acabada.
 *  É disponibilizado para auxiliar o processo de estudo. Os alunos são encorajados a testar adequadamente o
 *  código fornecido e a procurar soluções alternativas, à medida que forem adquirindo mais conhecimentos.
 */
package RacingManager.ui;

import RacingManager.business.Campeonato.Campeonato;
import RacingManager.business.Campeonato.CampeonatoFacade;
import RacingManager.business.Campeonato.ICampeonatoFacade;
import RacingManager.business.Circuito.Circuito;
import RacingManager.business.Corrida.Corrida;
import RacingManager.business.Corrida.CorridaFacade;
import RacingManager.business.Corrida.ICorridaFacade;
import RacingManager.business.Equipa.Piloto;
import RacingManager.business.Jogador.IJogadorFacade;
import RacingManager.business.Jogador.JogadorFacade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    public TextUI() throws SQLException {
        // Criar o menu
        this.menu = new Menu(new String[]{
                "Adicionar um campeonato",
                "Começar um campeonato",
                "Listar Campeonatos",
                "Mostrar Jogadores"
        });

        Menu ComeçarCampeonatoSubMenu = new Menu(new String[]{
                "Simular Corrida",
                "Listar Classificação Geral",
                "Simular todas as corridas"
        });

        ComeçarCampeonatoSubMenu.setHandler(1, () -> this.simulaUma(escolherChamp()));
        ComeçarCampeonatoSubMenu.setHandler(2, () -> this.listaGeral(escolherChamp()));
        ComeçarCampeonatoSubMenu.setHandler(3, () -> this.simulaTodas(escolherChamp()));

        this.menu.setHandler(1, this::addChamp);
        this.menu.setHandler(2, () -> ComeçarCampeonatoSubMenu.run());
        this.menu.setHandler(3, this::ListChamp);
        this.menu.setHandler(4, this::ListJogadores);


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
        this.model2.JogadorClear(); //TODO ver
        System.out.println("Até breve!...");
    }


    private String escolherChamp(){
        System.out.println("Nome do campeonato: ");
        String nomeCamp = scin.nextLine();
        return nomeCamp;
    }

    // Métodos auxiliares
    private void addChamp() {
        //Scanner scin = new Scanner(System.in);
        try {
            System.out.println("Nome do campeonato: ");
            String nomeCamp = scin.nextLine();
            if (this.model.getCampeonato(nomeCamp)==null) {
                this.model.adicionaCampeonato(new Campeonato(nomeCamp));
                System.out.println("Campeonato adicionado");
            } else {
                System.out.println("O nome do campeonato ja existe");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void simulaUma(String nomeCamp){

        Campeonato champ= this.model.getCampeonato(nomeCamp);
        ArrayList<Circuito> circuitos = this.model.getCircuitos(champ);
        ArrayList<Corrida> corridasFiltradas = new ArrayList<>();

        for(Circuito c : circuitos){
            if(this.model1.getCorrida(c)!=null) corridasFiltradas.add(this.model1.getCorrida(c));
        }

        for(Corrida c : corridasFiltradas){
            int i=0;
            System.out.println("Corrida vai ser simulada! ");
            if(c.listaClassificacao().isEmpty()) {
                c.simularCorrida();

                Map<Piloto,Integer> aux = new HashMap<>();
                aux = c.getLugares();

                for(Map.Entry<Piloto,Integer> entry : aux.entrySet()){
                    Piloto p = entry.getKey();
                    Integer value = entry.getValue();
                    System.out.println( value + "-" + p);
                }
                i++;
            }
            atualizaPontuacaoGeral(nomeCamp,c);
            if(i==1) break;
        }
    }

    private void atualizaPontuacaoGeral(String nomeCamp,Corrida c){

        Map<Piloto,Integer> auxC = new HashMap<>();
        auxC = c.getPontuacoes();

        Campeonato champ= this.model.getCampeonato(nomeCamp);

        Map<Piloto,Integer> auxChamp = new HashMap<>();
        auxChamp = champ.getPontuacaoGeral();


        for(Map.Entry<Piloto, Integer> setC : auxC.entrySet()){
            for(Map.Entry<Piloto, Integer> setChamp : auxChamp.entrySet()){
                if (setChamp.getKey() == null && setChamp.getValue() == null){
                    auxChamp.put(setC.getKey(), setC.getValue());
                }
                else if(setC.getKey()==setChamp.getKey()){
                    setChamp.setValue(setChamp.getValue() + setC.getValue());
                }
            }
        }
        champ.setPontuacaoGeral(auxChamp);
    }

    private void simulaTodas(String nomeCamp){

        Campeonato champ= this.model.getCampeonato(nomeCamp);
        ArrayList<Circuito> circuitos = this.model.getCircuitos(champ);
        ArrayList<Corrida> corridasFiltradas = new ArrayList<>();

        for(Circuito c : circuitos){
            if(this.model1.getCorrida(c)!=null) corridasFiltradas.add(this.model1.getCorrida(c));
        }

        for(Corrida c : corridasFiltradas){
            System.out.println("Corrida vai ser simulada! ");
            c.simularCorrida();

            Map<Piloto,Integer> aux = new HashMap<>();
            aux = c.getLugares();

            for(Map.Entry<Piloto,Integer> entry : aux.entrySet()){
                Piloto p = entry.getKey();
                Integer value = entry.getValue();
                System.out.println( value + "-" + p);
            }
            atualizaPontuacaoGeral(nomeCamp,c);
        }
        listaGeral(nomeCamp);
    }


    private void listaGeral(String nomeCamp){

        Campeonato champ= this.model.getCampeonato(nomeCamp);

        Map<Piloto,Integer> auxChamp = new HashMap<>();
        auxChamp = champ.getPontuacaoGeral();

        for(Map.Entry<Piloto,Integer> entry : auxChamp.entrySet()){
            Piloto p = entry.getKey();
            Integer points = entry.getValue();
            System.out.println(p + "-"+points);
        }
    }


    private void ListChamp() {
        try {
            //System.out.println("Nome do campeonato: ");
            //String nomeCamp = scin.nextLine();
            System.out.println(this.model.getCampeonatos().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    private void ListJogadores() {
        try {
            //System.out.println("Nome do campeonato: ");
            //String nomeCamp = scin.nextLine();
            System.out.println(this.model2.getJogadores().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

}

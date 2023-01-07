package RacingManager.business.Corrida;

import RacingManager.business.Carros.Carro;
import RacingManager.business.Carros.Hibrido;
import RacingManager.business.Circuito.Circuito;
import RacingManager.business.Metereologia.Meteorologia;
import RacingManager.business.Equipa.Piloto;
import RacingManager.business.Record;

import java.util.*;
import java.io.Serializable;

public class Corrida implements Serializable{


    private String idCorrida;
    private Circuito circuito;
    private List<Piloto> listaPilotos;
    private Map<Piloto, Boolean> dnf;
    private Meteorologia meteo;
    private Set<Piloto> resultados;

    public Corrida(){
        this.idCorrida = null;
    }

    public Corrida(String idCorrida,Circuito circuito,List<Piloto> listaPilotos,Map<Piloto, Boolean> dnf,Meteorologia meteo){
        this.idCorrida = idCorrida;
        this.circuito=circuito;
        this.listaPilotos=listaPilotos;
        this.dnf=dnf;
        this.meteo=meteo;
    }

    public Corrida(Corrida c){
        this.idCorrida = c.getIdCorrida();
        this.circuito=getCircuito();
        this.listaPilotos=getListaPilotos();
        this.dnf=getDnf();
        this.meteo=getMeteo();
    }

    public Meteorologia getMeteo() {
        return this.meteo;
    }

    public void setMeteo(Meteorologia meteo) {
        this.meteo = meteo;
    }

    public String getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(String idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public ArrayList<Piloto> getListaPilotos()
    {
        ArrayList<Piloto> aux = new ArrayList<Piloto>();
        for(Piloto p : this.listaPilotos)
        {
            aux.add(p.clone());
        }
        return aux;
    }

    public void setListaPilotos(List<Piloto> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public Map<Piloto,Boolean> getDnf() {

        Map<Piloto,Boolean> dnfs= new HashMap<>();
        for(Map.Entry<Piloto, Boolean> set : dnf.entrySet()){
            dnfs.put(set.getKey(),set.getValue());
        }
        return dnfs;
    }
/* Protótipo de funções que faltam
    public void verificarUltrapassagem(Segmento seg) {
        for(Piloto p : listaPilotos){
            if (!this.getDnf().containsKey(p))//se o participante ainda se mantiver em corrida
            {
                Carro carro = p.getCarrp();
                Piloto piloto = p.getpiloto();
                int posicao = p.getPosicao();
                int gdu = sec.getGDU();
                if(gdu != 3 && posicao>1){
                    Boolean tenta = tentaUltrapassagem(carro, piloto, clima, gdu);
                    if(tenta){
                        avancaUm(p);
                    }else{
                        verificaCrash(p);
                    }
                }else{
                    verificaCrash(p);
                }
            }
        }
        Collections.sort(this.getParticipante(), new StockComparator());
    }

    public boolean tentaUltrapassagem(Carro carro, Piloto piloto, int clima, int gdu) {
        float probInicial = 1;
        estadoMotor estado = carro.getEstado();
        float agressividade = piloto.getAgressividade();
        Random random = new Random();
        float limite = random.nextFloat();
        if (clima == 1)// caso esteja a chover prob de ultrapassar diminui
            probInicial -= 0.05;
        if(gdu == 5){//caso o GDU seja dificiil
            probInicial -=0.1;
        }
        probInicial += -0.05 + (0.1*agressividade);
        switch(estado){
            case CONSERVADOR:
                probInicial -= 0.05;
                break;
            case AGRESSIVO:
                probInicial += 0.05;
                break;
            default:
                break;
        }
        if(limite>probInicial)
            return true;
        else
            return false;
    }
public void verificaUltrapassagemPrem(Seccao sec) {
		int index = 0;
		for(Participante p : participantes){
			if (!this.getDNF().containsKey(p)){//se o participante ainda estiver na corrida
				Carro carro = p.getCarro();
				Piloto piloto = p.getpiloto();
				int posicao = p.getPosicao();
				int gdu = sec.getGDU(); //grau de dificuldade da seccao
				boolean inTime = inTime(p,index); //verifica se o utilizador está perto o suficiente para tentar a ultrapassagem
				if(gdu != 3 && posicao>1 && inTime){
					Boolean ultrapassou = tentaUltrapassagem(carro, piloto, clima, gdu);//verifica se o part foi capaz de ultrapassar o carrro a sua frente
					if(ultrapassou){
						avancaUm(p);//participante avança uma posiçao
					}else{
						verificaCrash(p);//verifica se o participante teve um crash nessa seccao
					}
				}else{//casso n seja possivel fazer a ultrapassagem verifica se o participante se despistou ou nao
					verificaCrash(p);
				}
				index++;//index para saber a posiçao da lista ordenada de participantes
			}
		}
	}


	public String printResultados() {
        String str = "";
        for (Piloto part : this.listaPilotos){
            str += part.getPosicao() + "º: " + part.getUtilizador().getUser() + "\n";
        }
        return str;
    }

*/
    public void setDnf(Map<Piloto, Boolean> dnf) {
        this.dnf = dnf;
    }

    public Map<Piloto,Long> listaClassificacao(){

        ArrayList<Piloto> aux = new ArrayList<>();
        for(Piloto p: this.resultados){
            aux.add(p.clone());
        }
        Map<Piloto,Long> res = new HashMap<>();
        for(Piloto p : aux){
            res.put(p,p.getTempo());
        }
        Comparator<Piloto> valueComparator = (k1, k2) -> res.get(k1).compareTo(res.get(k2));
        Map<Piloto, Long> sortedByValue = new TreeMap<>(valueComparator);
        sortedByValue.putAll(res);

        return res;
    }

    public Map<Piloto,Integer> getPontuacoes(){

        Map<Piloto,Long> aux = new HashMap<>();
        aux = listaClassificacao();

        ArrayList<Piloto> res = new ArrayList<>();
        for(Map.Entry<Piloto,Long> entry : aux.entrySet()){
            res.add(entry.getKey());
        }

        Map<Piloto,Integer> r = new HashMap<>();
        for(Piloto p : res){
            int i = 1;
            if (i==1) r.put(p,12);
            else if (i==2) r.put(p,10);
            else if(i==3) r.put(p,8);
            else if (i==4) r.put(p,7);
            else r.put(p,0);
            i++;
        }
        return r;
    }


    public Map<Piloto,Integer> getLugares(){

        Map<Piloto,Long> aux = new HashMap<>();
        aux = listaClassificacao();

        Map<Piloto,Integer> res = new HashMap<>();

        for(Map.Entry<Piloto,Long> entry : aux.entrySet()){
            int i =1;
            res.put(entry.getKey(),i);
            i++;
        }
        return res;
    }




    public void simularCorrida()
    {
        int voltas = this.circuito.getVoltas();
        long t_aux, t_volta;
        ArrayList<Piloto> aux = new ArrayList<Piloto>();
        Map<Piloto, Boolean> temp = new HashMap<>();
        ArrayList<Carro> aux1 = new ArrayList<Carro>();
        for(Piloto p : this.listaPilotos)
        {
            aux.add(p.clone());
        }
        for(int i=0; i<voltas; i++) {
            for(Piloto p : aux) {
                if(!p.getDnf()) //verifica se o carro esta acidentado
                {
                    if(p.DNF(i, voltas, this.meteo)) //verifica se o carro tem acidente na volta
                    {
                        p.setDnf(true);
                        temp.put(p.clone(),true);
                    }
                    else {
                        t_aux = p.getTempo(); //tempo feito ate ao momento
                        for (Carro c : aux1) {
                            if (c instanceof Hibrido) {
                                Hibrido h = (Hibrido) p;
                                int motor = h.getPotenciaMotorEletrico();
                                t_volta = p.tempoProximaVolta(this.circuito, this.meteo, i) - motor * 10L;
                            } else
                                t_volta = p.tempoProximaVolta(this.circuito, this.meteo, i);
                            p.setTempo(t_aux + t_volta);
                            //atualizar record
                            if (this.circuito.getRecord().getTempo() > t_volta) {
                                if (i < (this.circuito.getVoltas() / 2)) {
                                    Record r = new Record(t_volta, c.getEquipa().getPiloto1(), c.clone());
                                    this.circuito.setRecord(r);
                                } else {
                                    Record r = new Record(t_volta, c.getEquipa().getPiloto2(), c.clone());
                                    this.circuito.setRecord(r);
                                }
                            }
                        }
                    }
                }
            }
            //this.primeiroVolta(i,aux); //metodo auxiliar para determinar o 1º a cada volta
        }
        for(Piloto p : aux) {
            if(!p.getDnf()){ this.resultados.add(p); }
        }
        this.dnf = temp;
    }


}

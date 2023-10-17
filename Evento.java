/**
 * Escreva a descrição da classe Eventos aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.Serializable;
public class Evento implements Serializable {
    private Coord coordEvento;
    private GregorianCalendar dataFinalInscricoes;
    private Admin criador;
    private ArrayList<Cache> caches;
    private int maxParticipantes;
    private int duracao;
    private int condicoesEvento;

    /**
     * Construtor de argumentos da classe Evento.
     * @param x latitude do evento.
     * @param y longitude do evento.
     * @param ano ano da data final de inscrições.
     * @param mes mes da data final de inscrições.
     * @param dia dia da data final de inscrições.
     * @param criador é o admin.
     * @param listadecaches lista de caches que vai ter o evento.
     * @param maxParticipantes numero máximo de participantes no evento 
     * @param duracao duração do evento.
     * @param condicoesEvento condições que estão no dia do evento.
    */
    public Evento(int x,int y, int ano, int mes, int dia, Admin criador, ArrayList<Cache> listadecaches, int maxParticipantes, int duracao,int condicoesEvento) {
        this.coordEvento = new Coord(x,y);
        this.dataFinalInscricoes = new GregorianCalendar(ano,mes,dia);
        this.criador = criador.clone();
        this.caches = new ArrayList<Cache>();
        for( Cache e : listadecaches){
            this.caches.add(e.clone());
        }
        this.maxParticipantes = maxParticipantes;
        this.duracao = duracao;
        this.condicoesEvento = condicoesEvento;
    }
    /**
     * Construtor vazio da classe Evento.
    */
    public Evento() {
        this.coordEvento = new Coord();
        this.dataFinalInscricoes = new GregorianCalendar();
        this.criador = new Admin();
        this.caches = new ArrayList<Cache>();
        this.maxParticipantes = 0;
        this.duracao = 0;
        this.condicoesEvento = 0;
    }
    /**
     * Construtor de copia da classe Evento.
     * @param p objeto Evento.
    */
    public Evento(Evento p){
        this.coordEvento = p.getCoordEvento();
        this.dataFinalInscricoes = p.getdataFinalInscricoes();
        this.criador = p.getCriador();
        this.caches = p.getCaches();
        this.maxParticipantes = p.getMaxParticipantes();
        this.duracao = p.getDuracao();
        this.condicoesEvento = p.getCondicoesEvento();
    }
    /**
     * Retorna a data final de inscrições no evento.
    */
    public GregorianCalendar getdataFinalInscricoes() {
        return this.dataFinalInscricoes;
    }
    /** 
     * Retorna o numero maximo de participantes no evento.
    */
    public int getMaxParticipantes() {
        return this.maxParticipantes;
    }
    /**
     * Retorna a duração do evento.
    */
    public int getDuracao() {
        return this.duracao;
    }
    /**
     * Substitui o numero maximo de participantes do evento.
     * @param maxParticipantes numero de participantes.
    */
    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }
    /**
     * Substitui a duração para uma nova.
     * @param duracao tempo do evento.
    */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    /**
     * Retorna as coordenadas onde o evento vai começar.
    */
    public Coord getCoordEvento() {
        return coordEvento.clone();
    }
    /**
     * Substitui as Coordenadas do inicio do evento.
     * @param x latitude do evento.
     * @param y longitude do evento.
    */
    public void setCoordEvento(int x, int y) {
        this.coordEvento.setLatitude(x);
        this.coordEvento.setLongitude(y);
    }
    /**
     * Retorna as condições do evento.
    */
    public int getCondicoesEvento() {
        return condicoesEvento;
    }
    /**
     * Retorna o ano do evento.
    */
    public int getAno(){
        return dataFinalInscricoes.get(Calendar.YEAR);
    }
    /** 
     * Retorna o mes do evento.
    */
    public int getMes(){
        return dataFinalInscricoes.get(Calendar.MONTH);
    }
    /**
     * Retorna o dia do evento.
    */
    public int getDia(){
        return dataFinalInscricoes.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * Substitui as condições do evento.
     * @param condicoesEvento condições que tem o evento.
    */
    public void setCondicoesEvento(int condicoesEvento) {
        this.condicoesEvento = condicoesEvento;
    }
    /** 
     * Retorna o Admin do evento.
    */
    public Admin getCriador(){
        return this.criador.clone();
    }
    /**
     * Retorna o ArrayList que contem as caches do evento.
    */
    public ArrayList<Cache> getCaches(){
        ArrayList<Cache> novo = new ArrayList<Cache>();
        for( Cache e: caches){
            novo.add(e.clone());
        }
        return novo;
    }
    /**
     * Pega nas coordenadas, no evento, no maximo de participantes, 
     * nas condicoes do evento e na duracao e vai somar tudo dando assim
     * o hashcode que queremos.
     * @return int que geramos.
    */
    public int hashCode() {
        return this.coordEvento.getLatitude()+this.coordEvento.getLongitude()+this.maxParticipantes+this.condicoesEvento+this.duracao;
    }
    /**
     * Faz uma copia desta classe.
     *  @return classe Evento.
    */
    public Evento clone(){
        return new Evento(this);
    }
    /**
     * Faz a representacão que queremos da classe , colocando tudo numa String.
     * @return String que contem toda a informação necessaria.
    */
    public String toString2(){
        StringBuilder builder = new StringBuilder();
        builder.append(coordEvento);
      //  builder.append("\tNº de Caches: ");
      //  builder.append(caches.size());
        builder.append("\nData final de inscriçoes: ");
        builder.append(this.dataFinalInscricoes.get(Calendar.DAY_OF_MONTH)+"/");
        builder.append(this.dataFinalInscricoes.get(Calendar.MONTH)+"/");
        builder.append(this.dataFinalInscricoes.get(Calendar.YEAR));
        builder.append("\tNumero maximo de Participantes: ");
        builder.append("\tCondiçoes meteorogicas: ");
        switch (condicoesEvento) {
            case 1:
                builder.append("Sol");
                break;
            case 2:
                builder.append("Chuva");
                break;
            case 3:
                builder.append("Nevoeiro");
                break;
            case 4:
                builder.append("Neve");
                break;
        }
        return builder.toString();
    }
    /**
     * Faz a representacão de toda a classe, colocando tudo numa String 
     * @return String que contem toda a informação necessaria.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Evento\n"); 
        builder.append(coordEvento);
        builder.append("Caches:");
        for (Cache e : caches)
        {
            builder.append(e);
            builder.append("\n");
        }
        builder.append("\nData final de inscriçoes: ");
        builder.append(this.dataFinalInscricoes.get(Calendar.DAY_OF_MONTH)+"/");
        builder.append(this.dataFinalInscricoes.get(Calendar.MONTH)+"/");
        builder.append(this.dataFinalInscricoes.get(Calendar.YEAR));
        builder.append("\nCriador:");
        builder.append(criador);
        for(Cache e : caches){
            builder.append(e+"\n");
        }
        builder.append("\nNumero maximo de Participantes: ");
        builder.append("\nDuracao: ");
        builder.append(duracao);
        builder.append("\nCondiçoes meteorogicas: ");
        switch (condicoesEvento) {
            case 1:
                builder.append("Sol");
                break;
            case 2:
                builder.append("Chuva");
                break;
            case 3:
                builder.append("Nevoeiro");
                break;
            case 4:
                builder.append("Neve");
                break;
        }
        return builder.toString();
    }  
}
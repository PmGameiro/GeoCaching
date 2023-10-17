
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Calendar;
import java.io.Serializable;
public abstract class Cache implements Serializable{
    private String criador;
    private Coord coord;
    private GregorianCalendar dataCriacao;
    private GregorianCalendar dataDescoberta;
    private HashMap<Utilizador,String> reports; // a string representa o report do user
    private int duracao;
    private int condicoes;
    private int dificuldade;
    /**
     * Faz a representacão que queremos da classe , colocando tudo numa String.
     * @return String que contem toda a informação necessaria.
    */
    public String toString3(){
        StringBuilder builder = new StringBuilder();
        builder.append("Cache do tipo ");
        builder.append(this.getClass().getSimpleName());
        builder.append(" criada a ");
        builder.append(this.getDiaCriacao()+"/");
        builder.append(this.getMesCriacao()+"/");
        builder.append(this.getAnoCriacao());
        builder.append(" com dificuldade ");
        switch (dificuldade) {
            case 1:
                builder.append("Facil");
                break;
            case 2:
                builder.append("Medio");
                break;
            case 3:
                builder.append("Dificil");
                break;
            case 4:
                builder.append("Muito Dificil");
                break;
        }
        builder.append(" nas coordenadas: ");
        builder.append(this.coord);
        return builder.toString();
    }
    /**
     * Construtor vazio da classe Cache.
    */
    public Cache(){
        this.criador="";
        this.coord= new Coord();
        this.duracao=0;
        this.condicoes=0;
        this.dificuldade=0;
        this.reports= new HashMap<Utilizador,String> ();
        this.dataCriacao= new GregorianCalendar();
        this.dataDescoberta= new GregorianCalendar();
    }

    /**
     * Construtor de argumentos da classe Cache.
     * @param x latitude do evento.
     * @param criador criador da cache.
     * @param y longitude do evento.
     * @param condicoes clima provavel de encontrar a cache.
     * @param dificuldade dificuldade de encontrar a cache.
     * @param duracao tempo que demorou a encontra a cache.
     * @param ano ano em que criou a cache.
     * @param mes mes em que criou a cache.
     * @param dia dia em que criou a cache.
    */
    public Cache(int x, String criador, int y, int condicoes, int dificuldade, int duracao,int ano, int mes, int dia){
        this.coord= new Coord(x,y);
        this.duracao=duracao;
        this.criador=criador;
        this.condicoes=condicoes;
        this.dificuldade=dificuldade;
        this.reports= new HashMap<Utilizador,String> ();
        this.dataCriacao= new GregorianCalendar(ano,mes,dia);
        this.dataDescoberta= null;
    }
    /**
     * Construtor de copia da classe Cache.
     * @param p objeto Cache.
    */
    public Cache (Cache e){
        this.criador=e.getCriador();
        this.coord= e.getCoord();
        this.dataCriacao=e.getDataCriacao();
        this.dataDescoberta=e.getDataDescoberta();
        this.duracao= e.getDuracao();
        this.condicoes= e.getCondicoes();
        this.dificuldade= e.getDificuldade();
        this.reports= e.getreports();
    }
    /** 
     * Retorna a data da criação da cache.
    */
    public GregorianCalendar getDataCriacao() {
        return this.dataCriacao;
    }
    /**
     * Retorna a data da descoberta da cache.
    */
    public GregorianCalendar getDataDescoberta() {
        return this.dataDescoberta;
    }
    /**
     * Retorna o criador da cache.
    */
    public String getCriador() {
        return this.criador;
    }
    /** 
     * Retorna o mes da criação da cache.
    */
    public int getMesCriacao(){
        return this.dataCriacao.get(Calendar.MONTH);
    }
    /**
     * Retorna o dia da criação da cache.
    */
    public int getDiaCriacao(){
        return this.dataCriacao.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * Retorna o ano da criação da cache.
    */
    public int getAnoCriacao(){
        return this.dataCriacao.get(Calendar.YEAR);
    }
    /**
     * Retorna o mes da descoberta da cache.
    */
    public int getMesDescoberta(){
        return this.dataDescoberta.get(Calendar.MONTH);
    }
    /**
     * Retorna o dia da descoberta da cache.
    */
    public int getDiaDescoberta(){
        return this.dataDescoberta.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * Retorna o ano da descoberta da cache.
    */
    public int getAnoDescoberta(){
        return this.dataDescoberta.get(Calendar.YEAR);
    }
    /** 
     * Retorna as coordenadas da cache.
    */
    public Coord getCoord(){
        return this.coord.clone();
    } 
    /**
     * Retorna a duracacao da cache.
    */
    public int getDuracao() {
        return this.duracao;
    }
    /**
     * Retorna as condicoes da cache.
    */
    public int getCondicoes() {
        return this.condicoes;
    }
    /**
     * Retorna a dificuldade da cache.
    */
    public int getDificuldade() {
        return this.dificuldade;
    }
    /**
     * Retona o HashMap com os utilizadores e os reports da cache.
    */
    public HashMap<Utilizador, String> getreports(){
        Set<Map.Entry<Utilizador,String>> m= this.reports.entrySet();
        Iterator<Map.Entry<Utilizador,String>> i = m.iterator();
        HashMap<Utilizador,String> novo= new HashMap<Utilizador,String>();
        while(i.hasNext()) {
            Map.Entry<Utilizador,String> o=i.next();
            novo.put(o.getKey(),o.getValue());
        }
        return novo;
    }
    /** 
     * Calcula o numero de pontos multiplicando as condicoes pela dificuldade.
     * @retun numero de pontos.
    */
    public int pontos() {
        return this.condicoes*this.dificuldade;
    }
    /**
     * Função a ser implementada pelas subclasses.
    */
    public abstract Cache clone();
    /**
     * Substitui a duração da cache.
     * @param duracao tempo que demorou a encontrar a cache.
    */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    /**
     * Substitui as condicoes da cache.
     * @param condição clima provavel de encontrar a cache.
    */
    public void setCondicoes(int condicoes) {
        this.condicoes = condicoes;
    }
    /**
     * Substitui a dificuldade da cache.
     * @param dificuldade dificuldade de encontrar a cache..
     */
    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    /**
     * Substitui a data de criação da cache.
     * @param year year em que criou a cache.
     * @param month month em que criou a cache.
     * @param day day em que criou a cache.
     */
    public void setCalendarcria(int year, int month, int day ){
        this.dataCriacao= new GregorianCalendar(year,month,day);
    }
    /**
     * Substitui a data de descoberta da cache.
     * @param year year em que descoberta da cache.
     * @param month month em que descoberta da cache.
     * @param day day em que descoberta da cache.
     */
    public void setCalendardesc(int year, int month, int day ){
        this.dataDescoberta= new GregorianCalendar(year,month,day);
    }
    /**
     * Compara o objeto dado com este conjunto para a igualdade.
     * @param cache object cache.
     * @retun       true se o objeto for igual e false se não for.
     */
    public boolean equals(Object cache) {
        if (this == cache)
            return true;
        if (cache == null)
            return false;
        if (getClass() != cache.getClass())
            return false;
        Cache other = (Cache) cache;
        if (coord == null) {
            if (other.coord != null)
                return false;
        } else if (!coord.equals(other.coord))
            return false;
        return true;
    }
    /**
     * Faz representacão que queremos da classe , colocando tudo numa String.
     * @return String que contem toda a informação necessaria.
    */
    public String toStringCriada() {
        StringBuilder builder = new StringBuilder();
        builder.append("Criador: ");
        builder.append(criador);
        builder.append("\nCoordenadas: ");
        builder.append(coord);
        builder.append("\nData de criacão: ");
        builder.append(this.getDiaCriacao()+"/");
        builder.append(this.getMesCriacao()+"/");
        builder.append(this.getAnoCriacao());
        builder.append("\nDificuldade: ");
        switch (dificuldade) {
            case 1:
                builder.append("Facil");
                break;
            case 2:
                builder.append("Medio");
                break;
            case 3:
                builder.append("Dificil");
                break;
            case 4:
                builder.append("Muito Dificil");
                break;
        }
        return builder.toString();
    }
    /**Vai fazer a representacão de toda a classe, colocando tudo numa String 
     *    @return Da String que contem toda a informação necessaria.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Criador: ");
        builder.append(criador);
        builder.append("\nCoordenadas: ");
        builder.append(coord);
        builder.append("\nData de criacão: ");
        builder.append(this.getDiaCriacao()+"/");
        builder.append(this.getMesCriacao()+"/");
        builder.append(this.getAnoCriacao());
        builder.append("\nData de descoberta: ");
        builder.append(this.getDiaDescoberta()+"/");
        builder.append(this.getMesDescoberta()+"/");
        builder.append(this.getAnoDescoberta());
        Set<Map.Entry<Utilizador,String>> m= this.reports.entrySet();
        Iterator<Map.Entry<Utilizador,String>> i = m.iterator();
        HashMap<Utilizador,String> novo= new HashMap<Utilizador,String>();
        while(i.hasNext()) {
            Map.Entry<Utilizador,String> o=i.next();
            builder.append("\nO utilizador ");
            builder.append(o.getKey().getEmail());
            builder.append(" efetuou o seguinte report:\n\t");
            builder.append(o.getValue());
            builder.append("\n");
        }
        builder.append("\nDuracacão: ");
        builder.append(duracao);
        builder.append(" minutos");
        builder.append("\nCondicoes: ");
        switch (condicoes) {
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
        builder.append("\nDificuldade: ");
        switch (dificuldade) {
            case 1:
                builder.append("Facil");
                break;
            case 2:
                builder.append("Medio");
                break;
            case 3:
                builder.append("Dificil");
                break;
            case 4:
                builder.append("Muito Dificil");
                break;
        }
        return builder.toString();
    }
    /**
     * Faz a representacão que queremos da classe , colocando tudo numa String.
     * @return String que contem toda a informação necessaria.
     */
    public String toString2(){
        StringBuilder builder = new StringBuilder();
        builder.append("Na data ");
        builder.append(this.getDiaDescoberta()+"/");
        builder.append(this.getMesDescoberta()+"/");
        builder.append(this.getAnoDescoberta());
        builder.append(" descobriu-se uma cache ");
        builder.append(this.getClass().getSimpleName());
        builder.append(" nas coordenadas: ");
        builder.append(this.coord);
        return builder.toString();
    }
    /**
     * Adiciona uma queixa e o utilizador que a faz aos reports.
     * @param a um Utilizador
     * @param b a string que contem o report.
    */
    public void adicionaReport(Utilizador a, String b){
        this.reports.put(a,b);
    }
}






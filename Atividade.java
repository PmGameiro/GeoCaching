/**
 * Escreva a descrição da classe Atividade aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.Serializable;
public class Atividade implements Serializable {
    private Utilizador id;
    private Cache cache;
    private Evento evento;
    private int tipo; // 1 para cache encontrada; 2 para cache criada; 3 para participaçao em evento; 4 para remoçao de cache
    private GregorianCalendar data; // Data de realização
    
    /**
     * Construtor vazio da classe Evento.
     */
    public Atividade() {
        this.id=new Utilizador();
        this.cache=null;
        this.evento=new Evento();
        this.data=new GregorianCalendar();
        this.tipo=0;
    }
    /**
     * Construtor de argumentos da classe Evento.
     * @param id utilizador.
     * @param tipo (cache encontrada,cache criada, evento ou remoção da cache) tem um numero de 1 a 4.
     * @param e cache.
     * @param x tem a data do dia da atividade.
    */
    public Atividade(Utilizador id,int tipo, Cache e, GregorianCalendar x) {
        this.id=id.clone();
        this.tipo=tipo;
        this.cache=e.clone();
        this.evento=null;
        this.data=x;
    }
    /**
     * Construtor de argumentos da classe Evento.
     * @param id utilizador.
     * @param tipo (cache encontrada,cache criada, evento ou remoção da cache) tem um numero de 1 a 4.
     * @param e evento.
     * @param x tem a data do dia da atividade.
    */
    public Atividade(Utilizador id,int tipo,Evento e,GregorianCalendar x) {
        this.id=id.clone();
        this.tipo=tipo;
        this.evento=e.clone();
        this.cache=null;
        this.data=x;
    }
    /**
     * Construtor de copia da classe Atividade
     * @param p objeto atividade.
    */
    public Atividade(Atividade e) {
        this.id=e.getId();
        this.tipo=e.getTipo();
        this.data=e.getData();
        try {
            this.cache=e.getCache();
        }
        catch(NullPointerException p) {
            this.cache=null;
        }
        try {
            this.evento=e.getEvento();
        }
        catch(NullPointerException k) {
            this.evento=null;
        }
    }
    /**
     * Retorna o id da Atividade para distinguir o tipo de cache.
     */
    public Utilizador getId() {
        return this.id.clone();
    }
    /**
     * Retorna o tipo (cache encontrada,cache criada, evento ou remoção da cache) da Atividade.
     */
    public int getTipo() {
        return this.tipo;
    }
    /** 
     * Retorna a cache.
     */
    public Cache getCache() {
        return this.cache.clone();
    }
    /** 
     * Retorna o evento.
     */
    public Evento getEvento() {
            return this.evento.clone();
    }
    /** 
     * Retorna a data da realização da Atividade.
     */
    public GregorianCalendar getData(){
        return this.data;
    }
    /**
     * Substitui o tipo (cache encontrada,cache criada, evento ou remoção da cache) da atividade .
     * @param tipo tipo de Atividade.
     */
    public void setTipo(int tipo) {
        this.tipo=tipo;
    }
    /**
     * Faz uma copia desta classe.
     * @return classe Atividade.
     */
    public Atividade clone() {
        return new Atividade(this);
    }
    /**
     * Faz a representacão de toda a classe, colocando tudo numa String 
     * @return String que contem toda a informação necessaria.
    */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.id.getNome());
        builder.append("\t");
        switch (this.tipo) {
            case 1:
                builder.append("Encontrou uma cache");
                break;
            case 2:
                builder.append("Criou uma cache\t");
                break;
            case 3:
                builder.append("Inscreveu-se para um evento");
                break;
            case 4:
                builder.append("Removeu uma cache");
                break;
        }
        builder.append("\tData da atividade: ");
        builder.append(this.data.get(Calendar.DAY_OF_MONTH)+"/");
        builder.append(this.data.get(Calendar.MONTH)+"/");
        builder.append(this.data.get(Calendar.YEAR)+"  ");
        builder.append(this.data.get(Calendar.HOUR)+":");
        builder.append(this.data.get(Calendar.MINUTE));
        return builder.toString();
    }
}

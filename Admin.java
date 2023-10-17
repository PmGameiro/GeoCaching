import java.util.GregorianCalendar;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.TreeSet;
public class Admin extends Utilizador
{
    private TreeMap<Evento,ArrayList<Utilizador>> eventos;
    /**
     * Cria um administrador vazio
     */
    public Admin() {
        super();
        this.eventos=new TreeMap<Evento,ArrayList<Utilizador>>(new ComparatorCoord());
    }
    
    /**
     * Cria um administrador com os parametros fornecidos
     * @param email email do admnistrador
     * @param pass password da conta do administrador
     * @param nome nome do utilizador
     * @param genero genero do utilizador
     * @param morada morada do utilizador
     * @param dataNascimento data de nascimento do utilizador
     * @param pontos pontos do administrador
     */
    public Admin(String email, String pass, String nome, String genero, String morada, String dataNascimento, int pontos) {
        super(email, pass, nome, genero, morada, dataNascimento, pontos);
        this.eventos=new TreeMap<Evento,ArrayList<Utilizador>>(new ComparatorCoord());
    }
    
    /**
     * Cria um administrador que é uma copia do administrador recebido
     * @param e administrador que vai ser copiado
     */
    public Admin(Admin e) {
        super(e);
        this.eventos=e.getEventos();
    }
    /**
     * Verifica se um utilizador ja esta inscrito num dado evento
     * @param x evento em que vai procurar
     * @param e utilizador que vai procurar
     * return true caso o utilizador ja esteja inscrito, false caso contrario
     */
    public boolean jaInscrito(Evento x,Utilizador e){
        if (this.eventos.get(x).contains(e)==true) return true;
        return false;
    }
    /**
     * Adiciona um evento novo
     * @param e evento que vai adicionar
     */
    public void adicionaEvento (Evento e){
        ArrayList<Utilizador> novo = new ArrayList<Utilizador>();
        this.eventos.put(e,novo);
    }
    /**
     * Verifica se um evento ainda nao atingiu o maximo de participantes
     * @param b evento que vai verificar
     * @return true caso ainda haja vagas no evento, false caso cntrario
     */
    public boolean numeroPartici (Evento b){
        if(this.eventos.get(b).size()<b.getMaxParticipantes()) return true;
        return false;
    }
    
    /**
     * Devolve uma lista com os eventos
     * @return lista com os eventos
     */
    public ArrayList<Evento> daEventos(){
        ArrayList<Evento> novo = new ArrayList<Evento>();
        Set<Map.Entry<Evento,ArrayList<Utilizador>>> m = eventos.entrySet();
        Iterator<Map.Entry<Evento,ArrayList<Utilizador>>> i = m.iterator();
        while(i.hasNext()) {
           Map.Entry<Evento,ArrayList<Utilizador>> p=i.next();
           novo.add(p.getKey().clone());
        }
        return novo;
    }
    
    /**
     * Inscvreve um utilizador num evento
     * @param e evento aonde se vai inscrever o utilizador
     * @param a utilizador a ser inscrito
     */
    public void inscreveEvento(Evento e, Utilizador a){
        ArrayList<Utilizador> novo;
        if(this.eventos.get(e)==null)novo = new ArrayList<Utilizador>();
        else{
            novo = this.eventos.get(e);
        }
        novo.add(a.clone());
        this.eventos.put(e,novo);
    }
    /**
     * Verifica se o evento dado existe
     * @return true caso nao exista, false caso contrario
     */
    public boolean verEmpty(Evento x){
        return (this.eventos.get(x)==null);
    }
    /**
     * Verifica se uma data nao e posterior a data final de inscriçoes de um evento
     * @param b evento que vai ver
     * @param a data que vai verificar
     */
    public boolean dataEvento (Evento b,GregorianCalendar a){
        if (a.compareTo(b.getdataFinalInscricoes())>=0) return true;
        return false;
    }
    /**
     * Vai devolver um set com os utilizadores inscritos num evento ordenados pelo tempo medio que demoram a descobrir uma cache
     * @param x evento em que vai procurar
     * @return tree com os utilizadores ordenados por media de tempos de descoberta
     */
    public TreeSet<Utilizador> melhoresUtilizadores(Evento x){
        TreeSet<Utilizador> novo = new TreeSet<Utilizador>(new ComparatorMedia());
        for( Utilizador a : eventos.get(x)){
            novo.add(a.clone());
        }
        return novo;
    }
    /**
     * Retorna um map com os eventos e a lista de utilizadores inscritos em cada um
     * @return map com os eventos e a lista de utilizadores inscritos em cada um
     */
    public TreeMap<Evento,ArrayList<Utilizador>> getEventos() {
        TreeMap<Evento,ArrayList<Utilizador>> l= new TreeMap<Evento,ArrayList<Utilizador>>(new ComparatorCoord());
        ArrayList<Utilizador> novo;
        Set<Map.Entry<Evento,ArrayList<Utilizador>>> m = this.eventos.entrySet();
        Iterator<Map.Entry<Evento,ArrayList<Utilizador>>> i = m.iterator();
        while(i.hasNext()) {
                Map.Entry<Evento,ArrayList<Utilizador>> p=i.next();
                novo = new ArrayList<Utilizador>();
                for (Utilizador e: p.getValue()){
                    novo.add(e.clone());
                }
                l.put(p.getKey(),novo);
        }
        return l;
    }
    
    /**
     * Retorna uma copia deste administrador
     * @return copia deste administrador
     */
    public Admin clone() {
        return new Admin(this);
    }
}

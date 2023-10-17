
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.Iterator;
import java.io.Serializable;
public class Gestao implements Serializable {
    private Admin admin;
    private TreeMap<String,Utilizador> users;
    private ArrayList<Cache> caches;
    private TreeSet<Atividade> atividades;
    /**
     * Cria um gestao vazio
     */
    public Gestao(){
        this.admin = new Admin();
        this.atividades = new TreeSet<Atividade>(new ComparatorData());
        this.users = new TreeMap<String,Utilizador>();
        this.caches = new ArrayList<Cache>();
    }
    
    /**
     * Cria um gestao com um admin
     */
    public Gestao(Admin e){
        this.admin = e.clone();
        this.atividades = new TreeSet<Atividade>(new ComparatorData());
        this.users = new TreeMap<String,Utilizador>();
        this.caches = new ArrayList<Cache>();
    }
    /**
     * vria um gestao copiando o gestao dado
     */
    public Gestao (Gestao p){
        this.atividades=p.getAtividades();
        this.admin = p.getAdmin();
        this.users = p.getUsers();
        this.caches = p.getCaches();
    }
    /**
     * Retorna uma lista com caches que vao de um indice ate outro
     * @param i indice inicial
     * @param f indice final
     * @return lista com caches
     */
    public ArrayList<Cache> algumasCaches(int i, int j) {
        ArrayList<Cache> novo= new ArrayList<Cache>();
        while(i<j && i<this.caches.size()) {
            novo.add(this.caches.get(i));
            i++;
        }
        return novo;
    }
    /**
     * Retorna a lista de utilizadores correspondentes a uma lista de emails
     * @param amigos lista com emails
     * @return lista com utilizadores
     */
    public ArrayList<Utilizador> daUtilizadoresAmigos(ArrayList<String> amigos){
        ArrayList<Utilizador> novo= new ArrayList<Utilizador>();
        for(String a :amigos){
            Set<Map.Entry<String,Utilizador>> m= this.users.entrySet();
            Iterator<Map.Entry<String,Utilizador>> i = m.iterator();
            while(i.hasNext()) {
                Map.Entry<String,Utilizador> o=i.next();
                if(o.getValue().getEmail().equals(a)){
                    novo.add(o.getValue());
                    break;
                }
            }
            
        }
        return novo;
    }
    /**
     * Verifica se existe uma cache com umas coordenadas
     * @param coord coordenadas da cache que vai procurar
     * @return cache com as coordenadas ou null caso nao encontre
     */
    public Cache existeCache(Coord coord) {
        for (Cache k : this.caches) 
            if (k.getCoord().equals(coord)) return k.clone();
        return null;
    }
    /**
     * Retorna set com todas as atividades realizadas
     * @return set com todas as atividades realizadas
     */
    public TreeSet<Atividade> getAtividades() {
        TreeSet<Atividade> novo = new TreeSet<Atividade>();
        for( Atividade e : atividades){
            novo.add(e);
        }
        return novo;
    }
    /**
     * Retira um tesouro de uma cache
     * @param p cache de onde vai retirar
     * @para old tesouro que vai retirar
     */
    public void retiraTesouro(Cache p, String old){
        for(Cache e: caches)
            if(e.getCoord().equals(p.getCoord())){
                ((Tradicional) e).retiraTesouro(old);
                break;
            }
    }
    
    /**
     * Troca um tesouro de uma cache
     * @param p cache de onde vai efeturar a troca
     * @param old tesouro que vai ser retirado
     * @param novo tesouro que vai ser adicionado
     */
    public void trocaTesouro(Cache p, String old,String novo) {
        for(Cache e: caches)
            if(e.getCoord().equals(p.getCoord())){
                ((Tradicional) e).trocaTesouro(old,novo);
                break;
            }
    }
    /**
     * Adiciona um evento
     * @param e evento que vai ser adicionado
     */
    public void adicionaEvento (Evento e){
        this.admin.adicionaEvento(e.clone());
    }
    /**
     * Inscreve um utilizador num evento
     * @param e evento em que utilizador vai ser inscrito
     * @param x utilizador que vai ser inscrito
     */
    public void inscreveEvento(Evento e, Utilizador x) {
        this.admin.inscreveEvento(e.clone(),x);
    }
    /**
     * Retorna lista de atividades que pertencem a um utilizador e aos seus amigos
     * @param e utilizador a que pertencem as atividades
     * @return lista de atividades
     */
    public ArrayList<Atividade> visualizarAtividades(Utilizador e) {
        int i=0;
        ArrayList<Atividade> novo= new ArrayList<Atividade>();
        for(Atividade l : atividades){
            novo.add(l);
        }
        ArrayList<Atividade> res= new ArrayList<Atividade>();
        for (int x=novo.size();(x>0 && i<10);x--) {
            Atividade j=novo.get(x-1);
            if (e.pertence(j)) {
                res.add(j);
                i++;
            }
        }
        return res;
    }
    /**
     * Retorna o administrador deste gestao
     * @return administrador deste gestao
     */
    public Admin getAdmin(){
        return this.admin.clone();
    }
    /**
     * Retorna todos os utilizadores inscritos na aplicaçao
     * @return todos os utilizadores inscritos na aplicaçao
     */
    public TreeMap<String,Utilizador> getUsers() {
        Set<Map.Entry<String,Utilizador>> m= this.users.entrySet();
        Iterator<Map.Entry<String,Utilizador>> i = m.iterator();
        TreeMap<String,Utilizador> novo= new TreeMap<String,Utilizador>();
        while(i.hasNext()) {
            Map.Entry<String,Utilizador> o=i.next();
            novo.put(o.getKey(),o.getValue());
        }
        return novo;
    }
    /**
     * Remove uma atividade
     * @param e atividade que vai remover
     */
    public void removeDeAtividades(Atividade e){
        this.atividades.remove(e);
    }
    /**
     * Retorna lista de caches criadas
     * @return lista de caches criadas
     */
    public ArrayList<Cache> getCaches(){
        ArrayList<Cache> novo = new ArrayList<Cache>();
        for( Cache e : caches){
            novo.add(e);
        }
        return novo;
    }
    /**
     * Adiciona uma atividade
     * @param e atividade que vai adicionar
     */
    public void addAtividade(Atividade e) {
        this.atividades.add(e.clone());
    }
    /**
     * Adiciona uma cache
     * @param e cache que vai adicionar
     */
    public void add (Cache e){
        this.caches.add(e.clone());
    }
    /**
     * Procura uma atividade que tenha uma cache
     * @param e cache que vai procurar
     * @return atividade que corresponde a cache ou null caso nao encontre
     */
    public Atividade procuraAtividade(Cache e) {
        for (Atividade s: atividades) {
            if (s.getCache().equals(e)) return s;
        }
        return null;
    }
    /**
     * Remove uma cache
     * @param e utilizador que vai ser usado para verificar se foi ele que a criou
     * @param lat latitude da cache a ser removida
     * @param lon longitude da cache a ser removida
     * @param cache que foi removida
     */
    public Cache removeCache(Utilizador e, int lat, int lon) throws NoPermissionException,CacheDontExistException {
        Coord coord = new Coord(lat,lon);
        Cache novo= existeCache(coord);
        if (novo!=null) {
            if (novo.getCriador().equals(e.getEmail()) || novo.getCriador().equals(this.admin.getEmail())) {
                this.caches.remove(novo);
                return novo;
            }
            else throw (new NoPermissionException());
        }
        else throw new CacheDontExistException();
    }
    /**
     * Adiciona um amigo a um utilizador
     * @param e utilizador a que vai ser adicionado o amigo
     * @param email email do amigo a ser adicionado
     */
    public void addAmizade(Utilizador e, String email) throws AlreadyFriendException {
        this.users.get(email).addAmigo(e.getEmail());
    }
    /**
     * Remove a ultima cache que o utilizador adicionou, removendo tambem a atividade correspondente a criaçao da cache
     * @param e utilizador a que vai ser removida a cache
     * @return true caso tenha removido ou false caso negativo
     */
    public boolean invalida (Utilizador e){
        if (this.caches.get(this.caches.size()-1).getCriador().equals(e.getEmail())) {
            this.atividades.remove(this.procuraAtividade(this.caches.get(this.caches.size()-1)));
            this.caches.remove(this.caches.size()-1);            
            return true;
        }
        else return false;
    }
    /**
     * Retorna um set com os anos em que existe caches criadas
     * @return set com anos em que existe caches criadas
     */
    public TreeSet<Integer> anosCriacao(){
        TreeSet<Integer> novo = new TreeSet<Integer> ();
        for(Cache d: caches){
            novo.add(d.getAnoCriacao());
        }
        return novo;
    }
    /**
     * Retorna um set com os anos em que existe caches descobertas
     * @return set com anos em que existe caches descobertas
     */
    public TreeSet<Integer> anosDescoberta(){
        Set<Map.Entry<String,Utilizador>> m= this.users.entrySet();
        Iterator<Map.Entry<String,Utilizador>> ll = m.iterator();
        TreeSet<Integer> novo = new TreeSet<Integer> ();
        while(ll.hasNext()) {
            Map.Entry<String,Utilizador> o=ll.next();
            for (Cache j: o.getValue().getCachesDescobertas()) {
                novo.add(j.getAnoDescoberta());
            }
        }
        return novo;
    }
    /**
     * Guarda um utilizador na aplicacao
     * @param e utilizador a ser guardado
     */
    public void logout (Utilizador e) {
        this.users.put(e.getEmail(),e.clone());
    }
    /**
     * Verifica se existe um utilizador com certo email e password
     * @param email email do utilizador que vai verificar
     * @param pass possivel password do utilizador
     * @return utilizador caso este exista
     */
    public Utilizador login(String email, String pass) throws UserDontExistException{
        Utilizador o=this.users.get(email);
        if (o==null) throw new UserDontExistException();
        else 
            if(o.getPass().equals(pass)) return o.clone();
            else return null;            
    }
    /**
     * Verifica se existe uma case numas coordenadas e caso exista insere o nome no livro de registos
     * @param p coordenas que vai procurar
     * @param user nome do utilizador
     * return cache com o nome adicionado no log
     */
    public Cache search(Coord p, String user) throws CacheDontExistException{
        Iterator <Cache> i= caches.iterator();
        while(i.hasNext()){
            Cache novo= i.next(); 
            if(novo.getCoord().equals(p)==true){
                if(novo instanceof Tradicional || novo instanceof Misterio || novo instanceof Multi){
                    ((Tradicional) novo).adicionaLog(user);
                }
                return novo.clone();
            }   
        }
        throw new CacheDontExistException();
    }
    /**
     * Procura se existe um utilizador com um certo email
     * @param email email que vai procurar
     * @return true caso encontre, false caso contrario
     */
    public boolean procuraUser(String email) {
        return (this.users.containsKey(email));
    }
    /**
     * Retorna uma copia do gestao
     * @return copia do gestao
     */
    public Gestao clone(){
        return new Gestao(this);
    }
    /**
     * Retorna um array de 12 posicoes com o numero de caches descobertas por mes
     * @param logado utilizador que descobriu as caches
     * @param v3 ano em que descobriu as caches
     * @return array de 12 posicoes com o numero de caches descobertas por mes
     */
    public int[] daNDescobertas (Utilizador logado, int v3) {
        int[] mesDescobertas = new int[12];
        for (int i=0;i<12;i++) mesDescobertas[i]=0;
        for(Cache k : logado.getCachesDescobertas()){
            if(k.getAnoDescoberta()==v3) mesDescobertas[k.getMesDescoberta()-1]++;
        }
        return mesDescobertas;
    }
    /**
     * Retorna um array de 12 posicoes com o numero de caches criadas por mes
     * @param logado utilizador que criou as caches
     * @param v3 ano em que criou as caches
     * @return array de 12 posicoes com o numero de caches criadas por mes
     */
    public int[] daNCriadas (Utilizador logado, int v3) {
        int[] mesCriadas= new int[12];
        for(int i=0;i<12;i++) mesCriadas[i]=0;
        for (Cache q : this.caches)
            if(q.getCriador().equals(logado.getEmail()))
                if(q.getAnoCriacao()==v3) mesCriadas[q.getMesCriacao()-1]++;
        return mesCriadas;
    }
    
    /**
     * Retorna o numero de caches que um utilizador criou num ano
     * @param logado utilizador que criou as caches
     * @param v3 ano em que criou as caches
     * @return numero de caches que um utilizador criou num ano
     */
    public int totalCriadasMinhas(Utilizador logado, int v3) {
        int tc=0;
        for(int y=0;y<12;y++) tc += this.daNCriadas(logado,v3)[y];
        return tc;
    }
    /**
     * Retorna o numero de caches que um utilizador descobriu num ano
     * @param logado utilizador que descobriu as caches
     * @param v3 ano em que descobriu as caches
     * @return numero de caches que um utilizador descobriu num ano
     */
    public int totalDescobertasMinhas(Utilizador logado,int v3) {
        int td=0;
        for(int y=0;y<12;y++) td += this.daNDescobertas(logado,v3)[y];
        return td;
    }
    /**
     * Retorna um array com o numero total de caches criadas num ano
     * @param v3 ano de criaçao
     * @return array com o numero total de caches criadas num ano
     */
    public int[] daTCriadas (int v3) {
        int[] tCriadas = new int [12];
        for(int y=0;y<12;y++) tCriadas[y]=0;
        for (Cache h : this.caches){
            if(h.getAnoCriacao()==v3) tCriadas[h.getMesCriacao()-1]++;
        }
        return tCriadas;
    }
    /**
     * Retorna um array com o numero total de caches descobertas num ano
     * @param v3 ano de descoberta
     * @return array com o numero total de caches descobertas num ano
     */
    public int[] daTDescobertas (int v3) {
        int[] tDescobertas = new int [12];
        for(int y=0;y<12;y++) tDescobertas[y]=0;
        Set<Map.Entry<String,Utilizador>> m= this.users.entrySet();
        Iterator<Map.Entry<String,Utilizador>> ll = m.iterator();
        while(ll.hasNext()) {
            Map.Entry<String,Utilizador> o=ll.next();
            for(Cache e : o.getValue().getCachesDescobertas()) {
                if(e.getAnoDescoberta()==v3) tDescobertas[e.getMesDescoberta()-1]++;
            }
        }
        return tDescobertas;
    }
    /**
     * Retorna o numero de caches total que se criaram num ano
     * @param v3 ano de criacao
     * @return numero de caches total que se criaram num ano
     */
    public int totalCriadas(int v3) {
        int tc=0;
        for(int y=0;y<12;y++) tc += this.daTCriadas(v3)[y];
        return tc;
    }
    /**
     * Retorna o numero de caches total que se descobriram num ano
     * @param v3 ano de descoberta
     * @return numero de caches total que se descobriram num ano
     */
    public int totalDescobertas(int v3) {
        int td=0;
        for(int y=0;y<12;y++) td += this.daTDescobertas(v3)[y];
        return td;
    }
}

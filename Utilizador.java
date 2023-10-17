 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.Serializable;
public class Utilizador implements Serializable{
    private String email;
    private String pass;
    private String nome;
    private String genero;
    private String morada;
    private String dataNascimento;
    private int pontos;
    private TreeSet<Atividade> atividades;
    private ArrayList<String> amigos;
    private ArrayList<Cache> cachesDescobertas;
    /**
     * Cria um Utilizador vazio
     */
    public Utilizador(){
        this.email="";
        this.pass="";
        this.nome="";
        this.genero="";
        this.morada="";
        this.dataNascimento="";
        this.pontos=0;
        this.amigos=new ArrayList<String> ();
        this.cachesDescobertas=new ArrayList<Cache> ();
        this.atividades=new TreeSet<Atividade>(new ComparatorData());
    }
    
    /**
     * Cria um Utilizador com os parametros recebidos
     * @param email email do utilizador
     * @param pass password que o utilizador vai associar ao seu email
     * @param genero genero do utilizador (M ou F)
     * @param morada morada do utilizador
     * @param dataNascimento data de nascimento do utilizador
     * @param pontos pontos com que o utilizador vai comeÃ§ar
     */
    public Utilizador(String email, String pass, String nome, String genero, String morada, String dataNascimento, int pontos) 
    {
        this.email = email;
        this.pass = pass;
        this.nome = nome;
        this.genero = genero;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
        this.pontos = pontos;
        this.amigos=new ArrayList<String> ();
        this.cachesDescobertas=new ArrayList<Cache> ();
        this.atividades=new TreeSet<Atividade>(new ComparatorData());
    }
    
    /**
     * Cria um utilizador copiando um utilizador dado
     * @param e utilizador que vai ser copiado
     */
    public Utilizador(Utilizador e){
        this.email=e.getEmail();
        this.pass=e.getPass();
        this.nome=e.getNome();
        this.genero = e.getGenero();
        this.morada = e.getMorada();
        this.dataNascimento = e.getDataNascimento();
        this.pontos = e.getPontos();
        this.amigos = e.getAmigos();
        this.atividades=e.getAtividades();
        this.cachesDescobertas = e.getCachesDescobertas();
    }
    /**
     * Retorna email do utilizador
     * @return email do utilizador
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Retorna nome do utilizador
     * @return nome do utilizador
     */
    public String getNome(){
        return this.nome;
    }
    /**
     * Retorna password do utilizador
     * @return password do utilizador
     */
    public String getPass() {
        return this.pass;
    }
    /**
     * Retorna a media do tempo que o utilizador demora a descobrir uma cache
     * @return media de tempo que o utilizador demora a descobrir uma cache
     */
    public int media(){
        int i=0;
        int soma=0;
        Iterator<Cache> e= cachesDescobertas.iterator();
        while(e.hasNext()){
            soma+=e.next().getDuracao();
            i++;
        }
        return soma/i;
    }
    /**
     * Retorna coleçao com lista de atividades realizada pelo utilizador
     * @return coleçao com lista de atividades realizada pelo utilizador
     */
    public TreeSet<Atividade> getAtividades(){
        TreeSet<Atividade> novo= new TreeSet<Atividade>(new ComparatorData());
        for(Atividade e: this.atividades)
            novo.add(e.clone());
        return novo;
    }
    /**
     * Remove uma cache das caches que o utilizador descobriu
     * @param j cache que vai remover
     */
    public void removeCache(Cache j) {
        this.cachesDescobertas.remove(j);
    }
    /**
     * Adiciona uma cache descobertas pelo utilizador
     * @ param e Cache descoberta pelo utilizador
     */
    public void addCacheDescoberta(Cache e)throws TooEarlyException{
        if(e.getDataDescoberta().compareTo(e.getDataCriacao())<0) throw new TooEarlyException();
        else {
            this.cachesDescobertas.add(e.clone());
        }
    }
    /**
     * Adiciona uma atividade ao Utilizador
     * @param e Atividade realizada pelo utilizador
     */
    public void addAtividade(Atividade e) {
        this.atividades.add(e.clone());
    }
    /**
     * Retorna genero do utilizador
     * @return genero do utilizador
     */
    public String getGenero() {
        return this.genero;
    }
    /**
     * Retorna morada do utilizador
     * @return morada do utilizador
     */
    public String getMorada() {
        return this.morada;
    }
    /**
     * Retorna data de nascimento do utilizador
     * @return data de nascimento do utilizador
     */
    public String getDataNascimento() {
        return this.dataNascimento;
    }
    /**
     * Retorna pontos do utilizador
     * @return pontos do utilizador
     */
    public int getPontos() {
        return this.pontos;
    }
    
    /**
     * Filtra as atividades, retornando apenas as atividades de descoberta
     * @return lista com atividades de descoberta
     */
    public ArrayList<Atividade> getAtividadesDescoberta(){
        ArrayList<Atividade> provisorio = new ArrayList<Atividade>();
        for( Atividade e : atividades){
            if(e.getTipo() == 1){
               provisorio.add(e.clone());
            }
        }
        return provisorio;
    }
    
    /**
     * Remove uma atividades de descoberta
     * @param e atividade a ser removida
     * @param j cache descoberta que se vai remover
     */
    public void removeDescoberta(Atividade e, Cache j){
        this.atividades.remove(e);
        this.removeCache(j);
    }
   
    /**
     * Retorna uma lista com os emails dos amigos do utilizador
     * @return lista com emails dos amigos do utilizador
     */
    public ArrayList<String> getAmigos() {
        ArrayList<String> novo= new ArrayList<String>();
        for(String e: this.amigos)
            novo.add(e);
        return novo;
    }
    
    /**
     * Verifica se o utilizador descobriu uma cache com certas coordenadas
     * @param coord coordenadas da cache que vai procurar
     * @return true caso encontre, false caso contrario
     */
    public boolean existeCache(Coord coord) {
        for (Cache k : this.cachesDescobertas) 
            if (k.getCoord().equals(coord)) return true;
        return false;
    }
    
    /**
     * Verifica se uma atividade pertence ao utilizador ou a algum amigo dele
     * @param e atividade que vai verificar
     * @return true caso pertença, false caso contrario
     */
    public boolean pertence(Atividade e) {
        if (e.getId().getEmail().equals(this.email)) return true;
        return this.amigos.contains(e.getId().getEmail());
    }
    /**
     * Retorna uma lista com as caches descobertas pelo utilizador
     * @return lista com caches descobertas pelo utilizador
     */
    public ArrayList<Cache> getCachesDescobertas() {
         ArrayList<Cache> novo= new ArrayList<Cache>();
        for(Cache e: this.cachesDescobertas)
            novo.add(e.clone());
        return novo;
    }
    /**
     * Remove uma atividade do utilizador
     * @param e atividade que vai remover
     */
     public void removeAtividade(Atividade e){
        this.atividades.remove(e);
    }
    /**
     * Altera a pass do utilizador
     * @param pass password que o utilizador vai passar a ter
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * Altera o nome do utilizador
     * @param nome nome que o utilizador vai passar a ter
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Altera a morada do utilizador
     * @param morada morada que o utilizador vai passar a ter
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }
    /**
     * Altera a data de nascimento do utilizador
     * @param dataNascimento data de nascimento que o utilizador vai passar a ter
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /**
     * Adiciona pontos ao utilizador
     * @param pontos quantidade de pontos a adicionar
     */
    public void addPontos(int pontos) {
        this.pontos += pontos;
    }
    /**
     * Adiciona um amigo
     * @param email email do amigo que vai adicionar
     */
    public void addAmigo (String email) throws AlreadyFriendException{
        if (this.amigos.contains(email)) throw new AlreadyFriendException();
        else this.amigos.add(email);
    }
    /**
     * Cria um hashcode para a class
     * @return valor correspondente ao hashcode do email do utilizador
     */
    public int hashCode() {
        return this.email.hashCode();
    }
    /**
     * Compara o Object recebido com este utilizador
     * @param obj objecto com que vai comparar
     * @return true caso sejam iguais, false caso contrario
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utilizador other = (Utilizador) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (pass == null) {
            if (other.pass != null)
                return false;
        } else if (!pass.equals(other.pass))
            return false;
        return true;
    }
    /**
     * Cria e retorna uma copia deste utilizador
     * @return copia deste utilizador
     */
    public Utilizador clone() {
        return new Utilizador(this);
    }
    /**
     * Retorna uma string representativa deste utilizador
     * @return string representativa deste utilizador
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Email: ");
        builder.append(email);
        builder.append("\nNome: ");
        builder.append(nome);
        builder.append("\nGenero: ");
        builder.append(genero);
        builder.append("\nMorada: ");
        builder.append(morada);
        builder.append("\nData de Nascimento: ");
        builder.append(dataNascimento);
        builder.append("\nPontos: ");
        builder.append(pontos);
        builder.append("\nAmigos: \n");
        for(String e : amigos){
            builder.append(e+"\n");
        }
        for(Atividade e : atividades){
            builder.append(e+"\n");
        }
        return builder.toString();
    }
}
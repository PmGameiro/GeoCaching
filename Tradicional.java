
/**
 * Escreva a descrição da classe Tradicional aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;

public class Tradicional extends Cache
{
    private ArrayList<String> log;
    private ArrayList<String> tesouros;
    
    public Tradicional() {
        super();
        this.log = new ArrayList<String>();
        this.tesouros = new ArrayList<String>();
        
    }
 //vai ter parametros da cache;
    public Tradicional(int latitude,int longitude,String criador, int condicoes,int dificuldade,int duracao, ArrayList<String> tesouro,int ano, int mes, int dia) {
        super(latitude,criador,longitude,condicoes,dificuldade,duracao,ano,mes,dia);
        this.log = new ArrayList<String>();
        this.tesouros = tesouro;
    }
    
    public Tradicional(Tradicional p){
        super(p);
        this.log = p.getLog();
        this.tesouros= p.getTesouros();
    }
    
    public ArrayList<String> getLog() {
        ArrayList<String> novo = new ArrayList<String>();
        for(String e : log ){
            novo.add(e);
        }
        return novo;
    }
    public ArrayList<String> getTesouros(){
        ArrayList<String> novo = new ArrayList<String>();
        for( String e : tesouros){
            novo.add(e);
        }
        return novo;
    }
    
    public void retiraTesouro(String old){
        tesouros.remove(old);
    }
    
    public void trocaTesouro(String old,String novo) {
        tesouros.remove(old);
        tesouros.add(novo);
    }
    
    public Tradicional clone(){
        return new Tradicional(this);
    }
    public String toStringCriada() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toStringCriada());
        builder.append("\nTesouros:\n");
        for (String e : tesouros)
        {
            builder.append(e);
            builder.append("\n");
        }
        return builder.toString();
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("\nLog: \n");
        for (String s : log)
        {
            builder.append(s);
            builder.append("\n");
        }
        builder.append("Tesouros:\n");
        for (String e : tesouros)
        {
            builder.append(e);
            builder.append("\n");
        }
        return builder.toString();
    }
    public void adicionaTesouros(String a){
        this.tesouros.add(a);
    }
    public void adicionaLog(String a){
        this.log.add(a);
    }
}
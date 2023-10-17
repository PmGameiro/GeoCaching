
import java.util.ArrayList;
public class Multi extends Tradicional
{
    private ArrayList<Coord> pistas;
    
    public Multi() {
        super();
        this.pistas = new ArrayList<Coord>();
    }
    
    public Multi(int latitude,int longitude,String criador, int condicoes, int dificuldade,int duracao,ArrayList<String> tesouro,int ano, int mes, int dia,ArrayList<Coord> pistas ) {
        super(latitude,longitude,criador,condicoes,dificuldade,duracao,tesouro,ano,mes,dia);
        this.pistas = pistas;
    }
    
    public Multi(Multi p){
        super(p);    
        this.pistas = p.getPistas();
    }

    public ArrayList<Coord> getPistas() {
        ArrayList<Coord> novo = new ArrayList<Coord>();
        for( Coord e: pistas){
            novo.add(e);
        }
        return novo;
    }

    public Multi clone(){
        return new Multi(this);
    }
    public String toStringCriada() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Pistas:");
        for ( Coord s    : pistas)
        {
            builder.append(s);
            builder.append("\n");
        }
        return builder.toString();
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Log:");
        for ( Coord s    : pistas)
        {
            builder.append(s);
            builder.append("\n");
        }
        return builder.toString();
    }
    public void adiconaPistas(Coord a){
       this.pistas.add(a);
    }
}
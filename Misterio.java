
import java.util.ArrayList;
public class Misterio extends Tradicional
{
    private String puzzle;
    
    public Misterio(){
        super();
        this.puzzle = "";
    } 
    //recebe os parametros todos
    public Misterio(int latitude,String criador,int longitude, int condicoes,int dificuldade,int duracao, ArrayList<String> tesouros,int ano, int mes, int dia, String puzzle){
        super(latitude,longitude,criador,condicoes,dificuldade,duracao,tesouros,ano,mes,dia);
        this.puzzle = puzzle;
    }
    public Misterio(Misterio p){
        super(p);
        this.puzzle = p.getPuzzle();
    }
    public String getPuzzle() {
        return puzzle;
    }
    public void setPuzzle(String puzzle)    {
        this.puzzle = puzzle;
    }
    public String toStringCriada() {
            StringBuilder builder = new StringBuilder();
            builder.append(super.toStringCriada());
            builder.append("Puzzle:"); builder.append(puzzle);
            return builder.toString();
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Puzzle:"); builder.append(puzzle);
        return builder.toString();
    }
    public Misterio clone(){
        return new Misterio(this);
    }
}

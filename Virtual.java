

/**
 * Escreva a descrição da classe Virtual aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Virtual extends Cache
{
    private String prova;
    
    public void setProva(String prova) {
        this.prova = prova;
    }

    public Virtual(int x, int y, String criador,int condicoes, int dificuldade, int duracao,int ano, int mes, int dia, String prova) {
        super(x,criador,y,condicoes,dificuldade,duracao,ano,mes,dia);
        this.prova= prova;
    }

	public Virtual(Virtual p) {
		super(p);
    	this.prova = p.getProva();
	}
	
	public String getProva(){
			return prova;
    }
    
    public void setProva(){
        this.prova=prova;
    }
    
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\nProva:"); 
		builder.append(prova);
		return builder.toString();
	}
	
    public Virtual clone() {
        return new Virtual(this);
    }
}
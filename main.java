package main;


/**
 * Escreva a descrição da classe main aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class main
{
    public void cacheEncontrada(Utilizador logado){
        Scanner s= new Scanner(System.in);
        int x, y;
        String nome;
        System.out.println("Introduza as coordenadas da Cache:");
        System.out.println("Latitude:");
        x= s.nextInt();
        System.out.println("Longitude:");
        y= s.nextInt();
        Coord p;
        p.setLatitude(x);
        p.setLongitude(y);
        System.out.println("Intrduza o seu username:");
        nome= s.next();
        Cache novo;
        novo=search(p, nome);
        System.out.println("Introduza a data da descoberta:");
        int z;
        System.out.println("Dia:");
        x=s.nextInt();
        System.out.println("Mês:");
        y=s.nextInt();
        System.out.println("Ano:");
        z=s.nextInt();
        novo.setCalendardesc(z,y,x);
        System.out.println("Introduza as condições meteorologicas na altura da descoberta:");
        System.out.println("Sol(1)");
        System.out.println("Chuva(2)");
        System.out.println("Nevoeiro(3)");
        System.out.println("Neve(4)");
        x=s.nextInt();
        novo.setCondicoes(x);
        logado.cachesDescobertas.put(novo,y);
    }
}

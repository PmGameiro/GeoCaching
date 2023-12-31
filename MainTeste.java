package geoCaching;


/**
 * Escreva a descrição da classe MainTeste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.util.ArrayList;
public class MainTeste
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;

    /**
     * COnstrutor para objetos da classe MainTeste
     */
    public MainTeste()
    {
       Gestao gestor=new Gestao();
       ArrayList<String> tesouro;
       ArrayList<Coord> pistas;
       Coord pista;
       Utilizador a = new Utilizador("ertyujktyjfvghjf@hotmail.com", "ola", "eytjejejye", "M", "Travessa das maragatas", "23-08-1994", 0);
       Utilizador b = new Utilizador("erhtrejyetj@hotmail.com", "123", "jetyjetyjeyj", "F", "Rua morreira", "27-05-1994", 0);
       Utilizador c = new Utilizador("hrthr@hotmail.com", "567", "etyjetyjetyj", "M", "Travessa da lage", "15-04-1995", 0);
       Utilizador d = new Utilizador("rtyhjrteyj@hotmail.com", "673", "Cosjetyjetta", "M", "Rua joao II", "12-03-1995", 0);
       Utilizador e = new Utilizador("tyjetyjetyj@hotmail.com", "aaq", "eytje", "F", "Travessa da porta", "1-11-1996", 0);
       tesouro = new ArrayList<String>();
       tesouro.add("carro");
       tesouro.add("telemovel");
       pistas = new ArrayList<Coord>();
       pista = new Coord(3,4);
       pistas.add(pista);
       pista = new Coord(4,5);
       pistas.add(pista);
       Tradicional t1 = new Tradicional(1,31,a.getEmail(),0,2,0,tesouro,2014,2,2);
       Tradicional t2 = new Tradicional(2,32,b.getEmail(),0,3,0,tesouro,2014,5,11);
       Tradicional t3 = new Tradicional(3,33,c.getEmail(),0,1,0,tesouro,2014,8,23);
       Tradicional t4 = new Tradicional(4,34,d.getEmail(),0,4,0,tesouro,2014,9,25);
       Tradicional t5 = new Tradicional(5,35,e.getEmail(),0,2,0,tesouro,2014,11,15);
       Misterio m1 = new Misterio(6,a.getEmail(),36,0,2,0,tesouro,2014,1,3,"Quebra-cabecas");
       Misterio m2 = new Misterio(7,b.getEmail(),37,0,3,0,tesouro,2014,3,12,"Puzzle");
       Misterio m3 = new Misterio(8,c.getEmail(),38,0,4,0,tesouro,2014,4,24,"Sudoku");
       Misterio m4 = new Misterio(9,d.getEmail(),39,0,1,0,tesouro,2014,6,26,"Diferencas");
       Misterio m5 = new Misterio(10,e.getEmail(),40,0,1,0,tesouro,2014,7,16,"Quebra-cabeças");
       Multi mu1 = new Multi(11,41,a.getEmail(),0,1,0,tesouro,2014,10,4,pistas);
       Multi mu2 = new Multi(12,42,b.getEmail(),0,2,0,tesouro,2014,12,13,pistas);
       Multi mu3 = new Multi(13,43,c.getEmail(),0,3,0,tesouro,2014,1,18,pistas);
       Multi mu4 = new Multi(14,44,d.getEmail(),0,2,0,tesouro,2014,2,27,pistas);
       Multi mu5 = new Multi(15,45,e.getEmail(),0,1,0,tesouro,2014,3,17,pistas);
       Virtual vi1 = new Virtual(16,46,a.getEmail(),0,1,0,2014,4,5,"");
       Virtual vi2 = new Virtual(17,47,b.getEmail(),0,2,0,2014,5,14,"");
       Virtual vi3 = new Virtual(18,48,c.getEmail(),0,1,0,2014,6,30,"");
       Virtual vi4 = new Virtual(19,49,d.getEmail(),0,3,0,2014,7,20,"");
       Virtual vi5 = new Virtual(20,50,e.getEmail(),0,4,0,2014,8,30,"");
       gestor.add(t1);
       activity= new Atividade (logado,2,2014,2,2,t1);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(t1);
       gestor.add(t2);
       activity= new Atividade (logado,2,2014,5,11,t2);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(t2);
       gestor.add(t3);
       activity= new Atividade (logado,2,2014,8,23,t3);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(t3);
       gestor.add(t5);
       activity= new Atividade (logado,2,2014,11,15,t5);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(t5);
       gestor.add(t4);
       activity= new Atividade (logado,2,2014,9,25,t4);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(t4);
       gestor.add(m1);
       activity= new Atividade (logado,2,2014,1,3,m1);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(m1);
       gestor.add(m2);
       activity= new Atividade (logado,2,2014,3,12,m2);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(m2);
       gestor.add(m3);
       activity= new Atividade (logado,2,2014,4,24,m3);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(m3);
       gestor.add(m4);
       activity= new Atividade (logado,2,2014,6,26,m4);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(m4);
       gestor.add(m5);
       activity= new Atividade (logado,2,2014,7,16,m5);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(m5);
       gestor.add(vi1);
       activity= new Atividade (logado,2,2014,4,5,vi1);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(vi1);
       gestor.add(vi2);
       activity= new Atividade (logado,2,2014,5,14,vi2);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(vi2);
       gestor.add(vi3);
       activity= new Atividade (logado,2,2014,6,30,vi3);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(vi3);
       gestor.add(vi4);
       activity= new Atividade (logado,2,2014,7,20,vi4);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(vi4);
       gestor.add(vi5);
       activity= new Atividade (logado,2,2014,8,30,vi5);
       gestor.addAtividade(activity);
       logado.addAtividade(activity);
       logado.addCacheCriada(vi5);
       a.addAmigo(b.getEmail());
       a.addAmigo(c.getEmail());
       a.addAmigo(d.getEmail());
       gestor.add(t1);
       gestor.add(t2);
       gestor.add(t3);
       gestor.add(t4);
       gestor.add(t5);
       gestor.add(m1);
       gestor.add(m2);
       gestor.add(m3);
       gestor.add(m4);
       gestor.add(m5);
       gestor.add(mu1);
       gestor.add(mu2);
       gestor.add(mu3);
       gestor.add(mu4);
       gestor.add(mu5);
       gestor.add(vi1);
       gestor.add(vi2);
       gestor.add(vi3);
       gestor.add(vi4);
       gestor.add(vi5);
       a.addCacheCriada(t1);
       a.addCacheCriada(m1);
       a.addCacheCriada(mu1);
       a.addCacheCriada(vi1);
       b.addCacheCriada(t2);
       b.addCacheCriada(m2);
       b.addCacheCriada(mu2);
       b.addCacheCriada(vi2);
       c.addCacheCriada(t3);
       c.addCacheCriada(m3);
       c.addCacheCriada(mu3);
       c.addCacheCriada(vi3);
       d.addCacheCriada(t4);
       d.addCacheCriada(m4);
       d.addCacheCriada(mu4);
       d.addCacheCriada(vi4);
       e.addCacheCriada(t5);
       e.addCacheCriada(m5);
       e.addCacheCriada(mu5);
       e.addCacheCriada(vi5);
       t1.setCalendardesc(2014,2,05);
       t1.setCalendardesc(2014,7,10);
       t1.setCalendardesc(2014,8,3);
       t1.setCalendardesc(2014,10,20);
       m2.setCalendardesc(2014,10,13);
       m2.setCalendardesc(2014,11,20);
       m2.setCalendardesc(2014,8,27);
       m2.setCalendardesc(2014,4,3);
       mu3.setCalendardesc(2014,1,25);
       mu3.setCalendardesc(2014,5,3);
       mu3.setCalendardesc(2014,8,28);
       mu3.setCalendardesc(2014,12,5);
       vi4.setCalendardesc(2014,8,20);
       vi4.setCalendardesc(2014,9,23);
       vi4.setCalendardesc(2014,11,9);
       vi4.setCalendardesc(2014,12,5);
       b.cacheDescoberta(t1);
       c.cacheDescoberta(t1);
       d.cacheDescoberta(t1);
       e.cacheDescoberta(t1);
       a.cacheDescoberta(m2);
       c.cacheDescoberta(m2);
       d.cacheDescoberta(m2);
       e.cacheDescoberta(m2);
       a.cacheDescoberta(mu3);
       b.cacheDescoberta(mu3);
       d.cacheDescoberta(mu3);
       e.cacheDescoberta(mu3);
       a.cacheDescoberta(vi4);
       b.cacheDescoberta(vi4);
       c.cacheDescoberta(vi4);
       e.cacheDescoberta(vi4);
    }
}

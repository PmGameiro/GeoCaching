/**
 * Escreva a descrição da classe geoCachingPOO aqui.
 * 
 * @author Grupo 58
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
public class geoCachingPOO
{
    public static void main(String[] args) {
        Gestao gestor=null;
        Scanner s=new Scanner (System.in);
        try{
            FileInputStream fis=new FileInputStream("geoCaching.db");
            ObjectInputStream ois=new ObjectInputStream(fis);
            gestor=(Gestao) ois.readObject();
            ois.close();
            System.out.println("Deseja carregar os dados guardados? [s/n]");
            String kh=s.nextLine();
            if (!kh.equals("s")) throw new FileNotFoundException();
        }
        catch (FileNotFoundException e) {
            Admin admin = new Admin("teste123@gmail.com", "tuga","Teste123", "M", "testa", "08/11/1967", 0);
            gestor = new Gestao(admin);
            gestor.logout(admin);
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }
        catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        Utilizador logado;
        int ft=1;
        GregorianCalendar datas;
        Atividade activity;
        ArrayList<String> tesouro;
        ArrayList<String> amigos;
        int v,v1,v2,v3,v4,v5,v6,u1,u2,u3,hora, min, i;
        String a="";
        String b="";
        String l;
        while(true){
            logado=null;
            v=0;
            System.out.println("Caso deseje sair insira s;\nDeseja efetuar o login ou o registo [l/r]:");
            s=new Scanner (System.in);
            l=s.nextLine();
            if(l.equals("s"))  System.exit(0);
            if (l.equals("r")){
                System.out.println("Por favor preencha os seguintes campos:\n Email: ");
                String email=s.nextLine();
                while (gestor.getUsers().containsKey(email)) {
                    System.out.println("Email ja se encontra a ser utilizado, por favor introduza outro email: ");
                    email=s.nextLine();
                }
                System.out.println("Password: ");
                String pass=s.nextLine();
                System.out.println("Nome: ");
                String nome=s.nextLine();
                System.out.println("Genero [M/F]: ");
                String genero=s.nextLine();
                while(!genero.equals("M") && !genero.equals("F")) {
                    System.out.println("Por favor insira M ou F");
                    genero=s.nextLine();
                }
                System.out.println("Morada: ");
                String morada=s.nextLine();
                System.out.println("Data de Nascimento (ex: 25/05/1986): ");
                String data=s.nextLine();
                logado = new Utilizador(email, pass, nome, genero, morada, data, 0);
            }
            else {
                while(logado==null){
                    System.out.println("Email: ");
                    String email=s.nextLine();
                    System.out.println("Password: ");
                    String pass=s.nextLine();
                    try {
                        logado=gestor.login(email,pass);
                    }
                    catch (UserDontExistException e) {
                        System.out.println("email ou password incorretos;\nDeseja tentar novamente? [s/n]");
                        l=s.nextLine();
                        if (l.equals("n"))System.exit(0);
                    }
                }
            }
            while(v==0){
                System.out.println("Menu:\n\t1.Adicionar cache descoberta;\n\t2.Adicionar cache criada;\n\t3.Adicionar amigo;\n\t4.Vizualizar 10 ultimas atividades(suas e de seus amigos);\n\t5.Invalidar cache previamente inserida;\n\t6.Eventos;\n\t7.Consultar atividades de descoberta\n\t8.Aceder as estatisticas\n\t9.Visualizar lista de caches\n\t10.Visualizar perfil\n\t11.Visualizar perfil de amigo\n\t12.Remover Cache\n\t13.Logout\n\t14.Sair;");
                v=s.nextInt();
                while(v<0 || v>14) {
                    System.out.println("Por favor insira uma opçao de 1 a 14");
                    v=s.nextInt();
                }
                switch (v) {
                    case 3:
                        s=new Scanner (System.in);
                        System.out.println("Introduza o email do amigo:");
                        String email=s.nextLine();
                        if (!gestor.procuraUser(email))
                            System.out.println("Email nao encontrado");
                        else 
                            try {
                                logado.addAmigo(email);
                                gestor.addAmizade(logado,email);
                                System.out.println("Amigo adicionado com sucesso");
                            }
                            catch(AlreadyFriendException e) {
                                System.out.println("Ja tem o email "+email+" adicionado ao seus amigos");
                            }
                        v=0;
                        break;
                    case 2:
                        int u;
                        s = new Scanner(System.in);
                        System.out.println("Qual o tipo da Cache:\n\t1.Cache tradicional;\n\t2.Cache misterio;\n\t3.Cache multi\n\t4.Cache virtual\n\t5.Sair;");
                        u=s.nextInt();
                        while(u<0 || u>5) {
                            System.out.println("Por favor insira uma opçao de 1 a 5");
                            u=s.nextInt();
                        }
                        if(u!=5){
                            System.out.println("Introduza as coordenadas da Cache:");
                            System.out.println("Insira a Latitude:");
                            v1=s.nextInt();
                            System.out.println("Insira a Longitude:");
                            v2=s.nextInt();
                            Coord nn =new Coord(v1,v2);
                            if (gestor.existeCache(nn)!=null) System.out.println("Ja existe uma cache nessas coordenadas");
                            else {
                                ft=0;
                                System.out.println("Data de criação da cache (ex 25 03 2010):");
                                v3=s.nextInt();
                                v4=s.nextInt();
                                v5=s.nextInt();
                                System.out.println("Hora em que colocou a cache: (ex 18 30)");
                                hora=s.nextInt();
                                min=s.nextInt();
                                System.out.println("Difculdade da cache:\n\t1.Facil;\n\t2.Medio;\n\t3.Dificil;\n\t4.Muito Dificil;");
                                v6=s.nextInt();
                                while(v6<0 || v6>4) {
                                    System.out.println("Por favor insira apenas entre 1 e 4");
                                    v6=s.nextInt();
                                }
                                switch (u) {
                                    case 1:
                                        tesouro = new ArrayList<String>();
                                        b="s";
                                        for(i=1;b.equals("s");i++){
                                            s=new Scanner (System.in);
                                            System.out.println("Adicone o tesouro "+i+":");
                                            a=s.nextLine();
                                            tesouro.add(a);
                                            System.out.println("Quer continuar a inserir tesouros? [s/n]");
                                            b=s.nextLine();
                                        }
                                        Tradicional t = new Tradicional(v1,v2,logado.getEmail(),0,v6,0,tesouro,v5,v4,v3);
                                        gestor.add(t);
                                        datas=new GregorianCalendar(v5,v4,v3,hora,min);
                                        activity= new Atividade (logado,2,t,datas);
                                        gestor.addAtividade(activity);
                                        logado.addAtividade(activity);
                                        System.out.println("Cache criada com sucesso");
                                        break;
                                    case 2:
                                        tesouro = new ArrayList<String>();
                                        b="s";
                                        for(i=1;b.equals("s");i++){
                                            s=new Scanner (System.in);
                                            System.out.println("Adicone o tesouro "+i+":");
                                            a=s.nextLine();
                                            tesouro.add(a);
                                            System.out.println("Quer continuar a inserir tesouros? [s/n]");
                                            b=s.nextLine();
                                        }
                                        System.out.println("Adicione o puzzle:");
                                        b=s.nextLine(); 
                                        Misterio m = new Misterio(v1,logado.getEmail(),v2,0,v6,0,tesouro,v5,v4,v3,b);
                                        gestor.add(m);
                                        datas=new GregorianCalendar(v5,v4,v3,hora,min);
                                        activity= new Atividade (logado,2,m,datas);
                                        gestor.addAtividade(activity);
                                        logado.addAtividade(activity);
                                        System.out.println("Cache criada com sucesso");
                                        break;
                                    case 3:
                                        tesouro = new ArrayList<String>();
                                        b="s";
                                        for(i=1;b.equals("s");i++){
                                            s=new Scanner (System.in);
                                            System.out.println("Adicone o tesouro "+i+":");
                                            a=s.nextLine();
                                            tesouro.add(a);
                                            System.out.println("Quer continuar a inserir tesouros? [s/n]");
                                            b=s.nextLine();
                                        }
                                        int v7,v8;
                                        ArrayList<Coord> pistas = new ArrayList<Coord>();
                                        Coord pista;
                                        b="s";
                                        for(i=1;b.equals("s");i++){
                                            s=new Scanner (System.in);
                                            System.out.println("Adicone as coordenadas da pista "+i+":");
                                            System.out.println("Insira a Latitude:");
                                            v7=s.nextInt();                                                                                                                                                                                                                                                                            
                                            System.out.println("Insira a Longitude:");
                                            v8=s.nextInt();
                                            pista = new Coord(v7,v8);
                                            pistas.add(pista);
                                            s=new Scanner (System.in);
                                            System.out.println("Quer continuar a inserir mais pistas? [s/n]");
                                            b=s.nextLine();
                                        }
                                        Multi mu = new Multi(v1,v2,logado.getEmail(),0,v6,0,tesouro,v5,v4,v3,pistas);
                                        gestor.add(mu);
                                        datas=new GregorianCalendar(v5,v4,v3,hora,min);
                                        activity= new Atividade (logado,2,mu,datas);
                                        gestor.addAtividade(activity);
                                        logado.addAtividade(activity);
                                        System.out.println("Cache criada com sucesso");
                                        break;
                                    case 4:
                                        Virtual vi = new Virtual(v1,v2,logado.getEmail(),0,v6,0,v5,v4,v3,"");
                                        gestor.add(vi);
                                        datas=new GregorianCalendar(v5,v4,v3,hora,min);
                                        activity= new Atividade (logado,2,vi,datas);
                                        gestor.addAtividade(activity);
                                        logado.addAtividade(activity);
                                        System.out.println("Cache criada com sucesso");
                                        break;
                                }
                            }
                        }
                        v=0;
                        break;
                    case 1:
                        Cache novo;
                        s= new Scanner(System.in);
                        System.out.println("Introduza as coordenadas da Cache:");
                        System.out.println("Latitude:");
                        v1=s.nextInt();
                        System.out.println("Longitude:");
                        v2=s.nextInt();
                        Coord co=new Coord(v1,v2);
                        try {
                            novo=gestor.search(co, logado.getNome());
                        }
                        catch (CacheDontExistException e) {
                            System.out.println("Cache Inexistente");
                            novo=null;
                        }
                        if(novo!=null) {
                            System.out.println("Data de descoberta da cache (ex: 25 01 1999) :");
                            v3=s.nextInt();
                            v4=s.nextInt();
                            v5=s.nextInt();
                            System.out.println("Hora a que descobriu a cache: (ex: 17 55) ");
                            hora=s.nextInt();
                            min=s.nextInt();
                            novo.setCalendardesc(v5,v4,v3);
                            System.out.println("Introduza as condições meteorologicas na altura da descoberta:");
                            System.out.println("\t1.Sol\n\t2.Chuva\n\t3.Nevoeiro\n\t4.Neve");
                            i=s.nextInt();
                            while(i<0 || i>4) {
                                System.out.println("Por favor insira apenas entre 1 e 4");
                                i=s.nextInt();
                            }
                            novo.setCondicoes(i);
                            System.out.println("Quanto tempo demorou a encontrar a cache (em minutos):");
                            i=s.nextInt();
                            novo.setDuracao(i);
                            s= new Scanner(System.in);
                            if(novo instanceof Virtual) {
                                System.out.println("Introduza a prova para comprovar a descoberta da cache:");
                                b=s.nextLine();
                                ((Virtual) novo).setProva(b);
                            }
                            else {
                                System.out.println("Efetuou troca de tesouro, retirou ou deixou ficar [t/r/d]:");
                                b=s.nextLine();
                                if (!b.equals("d")){
                                    System.out.println("Que tesouro retirou:");
                                    String retirado=s.nextLine();
                                    if (b.equals("t")) {
                                        System.out.println("Que tesouro adicionou:");
                                        String adicionado=s.nextLine();
                                        gestor.trocaTesouro(novo,retirado,adicionado);
                                    }
                                    else gestor.retiraTesouro(novo,retirado);
                                }
                            }
                            System.out.println("Encontrou algum problema com a cache? Deseja efetuar um report? [s/n]");
                            b=s.nextLine();
                            if (b.equals("s")) {
                                System.out.println("Qual e o report: ");
                                b=s.nextLine();
                                novo.adicionaReport(logado,b);
                            }
                            try{
                                logado.addCacheDescoberta(novo);
                                datas = new GregorianCalendar(v5,v4,v3,hora,min);
                                activity = new Atividade (logado,1,novo,datas);
                                gestor.addAtividade(activity);
                                logado.addAtividade(activity);
                                logado.addPontos(novo.pontos());
                                gestor.logout(logado);
                                System.out.println("Cache descoberta com sucesso");
                            }
                            catch(TooEarlyException e) {
                                System.out.println("Data de descoberta anterior a data de criaçao");
                            }
                         }
                        v=0;
                        break;
                    case 5:
                        if(ft==1) System.out.println("Nao inseriu nenhuma cache recentemente");
                        else 
                            if(!gestor.invalida(logado)) System.out.println("Nao tem permissoes para invalidar a cache previamente inserida");
                            else {
                                ft=1;
                                System.out.println("A cache previamente inserida foi invalidada com sucesso");
                            }
                        v=0;
                        break;
                    case 4:
                        s= new Scanner(System.in);
                        int xx=1;
                        ArrayList<Atividade> act=gestor.visualizarAtividades(logado);
                        for(Atividade hh: act) {
                            System.out.println(xx+"."+hh.toString());
                            xx++;
                        }
                        if(act.size()!=0){
                         System.out.println("Deseja ver alguma atividade em detalhe? [s/n]");
                         b=s.nextLine();
                         while(b.equals("s")){
                            s=new Scanner(System.in);
                            System.out.println("Qual deseja ver?");
                            v3=s.nextInt();
                            if(act.get(v3-1).getTipo()==3) System.out.println(act.get(v3-1).getEvento().toString());
                            else 
                                if (act.get(v3-1).getTipo()==2 || act.get(v3-1).getTipo()==4) System.out.println(act.get(v3-1).getCache().toStringCriada());
                                else if (act.get(v3-1).getTipo()==1) System.out.println(act.get(v3-1).getCache().toString());
                            System.out.println("Deseja ver mais alguma atividade em detalhe? [s/n]");
                            s=new Scanner(System.in);
                            b=s.nextLine();
                         }
                        }
                        else System.out.println("Nao existe nenhuma atividade para visualizar");
                        v=0;
                        break;
                    case 6:
                        if(logado.getEmail().equals(gestor.getAdmin().getEmail())){
                            s = new Scanner(System.in);
                            int ai;
                            System.out.println("\t1.Criar Evento\n\t2.Simular Evento");
                            ai=s.nextInt();
                            while(ai<0 || ai>2) {
                                System.out.println("Por favor insira apenas entre 1 e 2");
                                ai=s.nextInt();
                            }
                            if(ai==2){
                                int ut=1;
                                if(gestor.getAdmin().getEventos().isEmpty()){
                                    System.out.println("Não existem eventos disponiveis");
                                }
                                else{
                                    TreeSet<Utilizador> melhores= new TreeSet<Utilizador>();
                                    ArrayList<Evento> eventostodos = gestor.getAdmin().daEventos();
                                    for(Evento re : eventostodos){
                                        System.out.println(ut+"-"+re.toString2());
                                        ut++;
                                    }
                                    System.out.println("Qual Evento quer simular?");
                                    v1=s.nextInt();
                                    melhores=gestor.getAdmin().melhoresUtilizadores(eventostodos.get(v1-1));
                                    ut=1;
                                    for(Utilizador pe : melhores){
                                        if(ut==4) break;
                                        System.out.println(ut+"º "+pe.getNome());
                                        ut++;
                                    }
                                }
                            }
                            else {
                                int ut=1;
                                ArrayList<Cache> cachesevento = new ArrayList<Cache>();
                                System.out.println("Coloque as coordenadas do inicio do evento:");
                                System.out.println("Latitude:");
                                v1=s.nextInt();
                                System.out.println("Longitude:");
                                v2=s.nextInt();
                                System.out.println("Data limite de inscrições:");
                                v3=s.nextInt();
                                v4=s.nextInt();
                                v5=s.nextInt();
                                b="s";
                                while (b.equals("s")) {
                                    System.out.println("Coloco as coordenadas da "+ut+" cache do evento:");
                                    System.out.println("Latitude:");
                                    v6=s.nextInt();
                                    System.out.println("Longitude:");
                                    u1=s.nextInt();
                                    Coord aa =new Coord(v6,u1);
                                    if((gestor.existeCache(aa))==null) System.out.println("Não existe cache nessas coordenadas; ");
                                    else {
                                        s = new Scanner(System.in);
                                        System.out.println("Quer inserir mais caches? [s/n]");
                                        b=s.nextLine();
                                        cachesevento.add(gestor.existeCache(aa));
                                        ut++;
                                    }
                                }
                                System.out.println("Numero maximo de participantes:");
                                u2=s.nextInt();
                                System.out.println("Duração do evento");
                                u3=s.nextInt();
                                System.out.println("Condições do evento:");
                                v6=s.nextInt();
                                Evento evento = new Evento(v1,v2, v5, v4, v3,gestor.getAdmin(), cachesevento, u2, u3, v6);
                                gestor.adicionaEvento(evento);
                                System.out.println("Evento criado com sucesso");
                            }
                        }
                        else {
                            if(gestor.getAdmin().getEventos().isEmpty()){
                                System.out.println("Não existem eventos disponiveis");
                            }
                            else{
                                int ui=1;
                                s= new Scanner(System.in);
                                ArrayList<Evento> eventostodos = gestor.getAdmin().daEventos();
                                for(Evento re : eventostodos){
                                    System.out.println(ui+"-"+re.toString2());
                                    ui++;
                                }
                                System.out.println("Quer-se inscrever em algum evento? [s/n]");
                                b=s.nextLine();
                                if(b.equals("s")){
                                    System.out.println("Escolha o Evento que quer inscrever:");
                                    v1=s.nextInt();
                                    Evento axe = eventostodos.get(v1-1).clone();
                                    GregorianCalendar x=new GregorianCalendar();
                                    if((gestor.getAdmin().dataEvento(axe,x))) System.out.println("Esse evento ja acabou");
                                    else{  
                                        if(gestor.getAdmin().verEmpty(axe)==true) {
                                            gestor.inscreveEvento(axe,logado);
                                            System.out.println("Inscriçao efetuada com sucesso");
                                        }
                                        else{  
                                            if((gestor.getAdmin().jaInscrito(axe,logado))==true) System.out.println("Ja esta inscrito nesse evento");
                                            else {
                                                if(gestor.getAdmin().numeroPartici(axe)==false) System.out.println("O evento esta cheio");
                                                else{
                                                    gestor.inscreveEvento(axe,logado);
                                                    activity= new Atividade (logado,3,axe,x);
                                                    gestor.addAtividade(activity);
                                                    logado.addAtividade(activity);
                                                    System.out.println("Inscricao efetuada com sucesso");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        v=0;
                        break;
                    case 7:
                        s= new Scanner(System.in);
                        ArrayList<Atividade> atividades = logado.getAtividadesDescoberta();
                        int pp=1;
                        for(Atividade e : atividades){
                            System.out.println(pp+"."+e.getCache().toString2()+"\n");
                            pp++;
                        }
                        if (atividades.size()!=0) {
                            System.out.println("Deseja remover alguma atividade? [s/n]");
                            b=s.nextLine();
                            while(b.equals("s")){
                              if(b.equals("s")) {
                                System.out.println("Qual deseja remover?");
                                v3=s.nextInt();
                                logado.removeCache(atividades.get(v3-1).getCache());
                                logado.removeAtividade(atividades.get(v3-1));
                                gestor.removeDeAtividades(atividades.get(v3-1));
                                pp--;
                                System.out.println("Atividade de descoberta removida com sucesso");
                              }
                              if(pp!=1){
                                System.out.println("Deseja remover mais alguma atividade? [s/n]");
                                b=s.nextLine();
                              }
                              else break;
                           }
                        }
                        else System.out.println("Nao existe nenhuma atividade de descoberta para visualizar");
                        v=0;
                        break;
                    case 8:
                        s= new Scanner(System.in);
                        System.out.println("Deseja ver as estatistiacs mensais ou anuais? [m/a]");
                        b=s.nextLine();
                        if(b.equals("m")){
                            System.out.println("Deseja ver para que ano?");
                            v3=s.nextInt();
                            int[] mesCriadas=gestor.daNCriadas(logado,v3);
                            int[] mesDescobertas=gestor.daNDescobertas(logado,v3);
                            int[] tCriadas=gestor.daTCriadas(v3);
                            int[] tDescobertas=gestor.daTDescobertas(v3);
                            int tc=gestor.totalCriadas(v3);
                            int td=gestor.totalDescobertas(v3);
                            int totalc=gestor.totalCriadasMinhas(logado,v3);
                            int totald=gestor.totalDescobertasMinhas(logado,v3);
                            if (tc==0 && td==0)
                                System.out.println("Nao existem caches nesse ano");
                            else {
                                System.out.println("Ano "+v3+" :");
                                for(i=0;i<12;i++){
                                    System.out.println("No mês "+(i+1)+" descobriu "+mesDescobertas[i]+" e criou "+mesCriadas[i]);
                                    System.out.println("Foram descobertas "+tDescobertas[i]+" e foram criadas "+tCriadas[i]);
                                }
                                System.out.println("No total descobriu "+totald+" e criou"+totalc+"caches");
                                System.out.println("Foram descobertas "+td+" e foram criadas "+tc);
                            }
                        }
                        else {
                            int td;
                            int tc;
                            Set<Map.Entry<String,Utilizador>> m= gestor.getUsers().entrySet();
                            TreeSet<Integer> tt=gestor.anosDescoberta();
                            for (int ww: tt) { 
                                Iterator<Map.Entry<String,Utilizador>> ll = m.iterator();
                                td=0;
                                while(ll.hasNext()) {
                                    Map.Entry<String,Utilizador> o=ll.next();
                                    for(Cache e : o.getValue().getCachesDescobertas()) {
                                        if(e.getAnoDescoberta()==ww) td++;
                                    }
                                }
                                System.out.println("Em "+ww+" foram descobertas "+td+" caches");
                            }
                            TreeSet<Integer> kk= gestor.anosCriacao();
                            for (int qq: kk){
                                tc=0;
                                for (Cache h : gestor.getCaches()){
                                    if(h.getAnoCriacao()==qq) tc++;
                                }
                                System.out.println("Em "+qq+" foram criadas "+tc+" caches");
                            }
                        }
                        v=0;
                        break;
                    case 9:
                        s= new Scanner(System.in);
                        int inicio=0;
                        int fim=10;
                        b="s";
                        ArrayList<Cache> asd = gestor.algumasCaches(inicio,fim);
                        if (asd.size()==0) System.out.println("Nao existe nenhuma cache");
                        else {
                            for (Cache hd : asd) System.out.println(hd.toString3());
                            if (!(asd.size()<10)) {
                                System.out.println("Deseja continuar a ver caches? [s/n]");
                                b=s.nextLine();
                                while(fim<gestor.getCaches().size() && b.equals("s")) {
                                    inicio=fim;
                                    fim+=10;
                                    asd = gestor.algumasCaches(inicio,fim);
                                    for (Cache ho : asd) System.out.println(ho.toString3());
                                    if (asd.size()>11) {
                                        System.out.println("Deseja passar a proxima pagina? [s/n]");
                                        b=s.nextLine();
                                    }
                                    else break;
                                }
                            }
                        }
                        v=0;
                        break;
                    case 10:
                        System.out.println(logado.toString());
                        s= new Scanner(System.in);
                        System.out.println("Deseja mudar algum campo? [s/n]");
                        b=s.nextLine();
                        String c="";
                        String d="";
                        if(b.equals("s")) c="s";
                        else c="n";
                        while(c.equals("s")){
                              s= new Scanner(System.in);
                              System.out.println("1.Nome\n2.Password\n3.Data de nascimento\n4.Morada\nQual deseja mudar?");
                              v2=s.nextInt();
                              while(v2<0 || v2>4) {
                                  System.out.println("Por favor insira apenas entre 1 e 4");
                                  v2=s.nextInt();
                              }
                              s= new Scanner(System.in);
                              switch (v2) {
                                  case 1:
                                    System.out.println("Nome: ");
                                    d=s.nextLine();
                                    logado.setNome(d);
                                    System.out.println("Alteraçao efetuada com sucesso");
                                    break;
                                  case 2:
                                    System.out.println("Password nova: ");
                                    d=s.nextLine();
                                    logado.setPass(d);
                                    System.out.println("Alteraçao efetuada com sucesso");
                                    break;
                                  case 3:
                                    System.out.println("Data de nascimento (ex. 25/5/2015): ");
                                    d=s.nextLine();
                                    logado.setDataNascimento(d);
                                    System.out.println("Alteraçao efetuada com sucesso");
                                    break;
                                  case 4:
                                    System.out.println("Morada: ");
                                    d=s.nextLine();
                                    logado.setMorada(d);
                                    System.out.println("Alteraçao efetuada com sucesso");
                                    break;
                              }
                              System.out.println("Deseja mudar mais algum campo? [s/n]");
                              c=s.nextLine(); 
                        }
                        v=0;
                        break;
                    case 11:
                        amigos = logado.getAmigos();
                        ArrayList<Utilizador> amigos1 = new ArrayList<Utilizador>();
                        amigos1 = gestor.daUtilizadoresAmigos(amigos);
                        pp=1;
                        s= new Scanner(System.in);
                        for(Utilizador e : amigos1){
                            System.out.println(pp+"."+e.getNome()+"\n");
                            pp++;
                        }
                        if (amigos.size()!=0) {
                            System.out.println("Deseja ver o perfil de algum amigo? [s/n]");
                            b=s.nextLine();
                            while(b.equals("s")){
                              if(b.equals("s")) {
                                System.out.println("Qual deseja ver?");
                                v3=s.nextInt();
                                try {
                                    System.out.println(amigos1.get(v3-1).toString());
                                }
                                catch(IndexOutOfBoundsException e) {
                                    System.out.println("Nao existe essa opção");
                                }
                              }
                              s= new Scanner(System.in);
                              System.out.println("Deseja ver mais algum perfil? [s/n]");
                              b=s.nextLine();
                           }
                        }
                        else System.out.println("Nao tem amigos adicionados");
                        v=0;
                        break;
                    case 12:
                        if(logado.getEmail().equals(gestor.getAdmin().getEmail())){
                            System.out.println("Qual as coordenadas da cache que deseja remover:");
                            System.out.println("Latitude:");
                            v1=s.nextInt();
                            System.out.println("Longitude:");
                            v2=s.nextInt();
                            try {
                                GregorianCalendar vnn=new GregorianCalendar();
                                Cache kl=gestor.removeCache(logado,v1,v2);
                                activity =new Atividade(logado,4,kl,vnn);
                                gestor.addAtividade(activity);
                                logado.addAtividade(activity);
                                System.out.println("Cache removida com sucesso");
                            }
                            catch(NoPermissionException e) {
                                System.out.println("Nao tem permissao para remover essa cache");
                            }
                            catch(CacheDontExistException e) {
                                System.out.println("Cache inexistente");
                            }
                        }
                        v=0;
                        break;
                    case 13:
                        gestor.logout(logado);
                        try{
                            ObjectOutputStream oout= new ObjectOutputStream(new FileOutputStream("geoCaching.db"));
                            oout.writeObject(gestor);
                            oout.flush();
                            oout.close();
                        }
                        catch (IOException e) {
                            System.out.println(e);
                            System.exit(1);
                        }
                        break;
                    case 14:
                        gestor.logout(logado);
                        try{
                            ObjectOutputStream oout= new ObjectOutputStream(new FileOutputStream("geoCaching.db"));
                            oout.writeObject(gestor);
                            oout.flush();
                            oout.close();
                        }
                        catch (IOException e) {
                            System.out.println(e);
                            System.exit(1);
                        }
                        System.exit(0);
                }
            }
        }
    }
}
           
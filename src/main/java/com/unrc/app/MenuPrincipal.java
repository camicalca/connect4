/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.javalite.activejdbc.Base;
import static org.javalite.activejdbc.Model.attributes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.before;
import static spark.Spark.after;
/**
 *
 * @author santiago
 */
public class MenuPrincipal {
       
    public static void mostrarMenuPrincipal(){
            //Declaro variables de la base de datos
                String driver = "com.mysql.jdbc.Driver";
                String jdbs = "jdbc:mysql://localhost/connect4_development";
                String usubd = "root";
                String contrbd = "Control123";
                Board tablero =new Board();
               // int  jugador = 1;
                
                before((request,response) -> {
                    if(!Base.hasConnection()){
                        Base.open(driver,jdbs,usubd,contrbd);
                    }});
                after((request,response) -> {
                    if(!Base.hasConnection()){
                        Base.close();
                    }});
                    
                
                
                
                
                
    //--------------------------------------------------------------------------
        post("/Cargar", (request, response) -> {
                //Base.open(driver,jdbs,usubd,contrbd);
                Map<String, Object> attributes = new HashMap<>();
              
                int idGame = Integer.parseInt(request.queryParams("juegoguardado"));
                List<Game> gamejug = Game.where("id=?",idGame);
                
                tablero.loadBoard(idGame);
                String test = tablero.toStringB();
                tablero.setIdp1(gamejug.get(0).getInteger("player1_id"));
                tablero.setIdp2(gamejug.get(0).getInteger("player1_id"));
               
                attributes.put("tablero",test);
                Game.delete("id=?", idGame);
                //Base.close();
                return new ModelAndView(attributes, "webApp/game.mustache");
            }, new MustacheTemplateEngine());
                
                
    //--------------------------------------------------------------------------
        post("/jugar", (request, response) -> {
                //Base.open(driver,jdbs,usubd,contrbd);
                Map<String, Object> attributes = new HashMap<>();
                List <User> users = User.findAll();
                attributes.put("users",users);
                List <Game> idgame = Game.where("win_id is null");
                attributes.put("idgame",idgame);
                
                //Base.close();
                return new ModelAndView(attributes, "webApp/play.mustache");
            }, new MustacheTemplateEngine());
        
     //------------------------------------------------------------------------
       get("/hello", (request, response) -> {
                //Base.open(driver,jdbs,usubd,contrbd);
                
           
                Map<String, Object> attributes = new HashMap<>();
                List <User> users = User.findAll();
                System.out.println("findall**********  "+users);
                attributes.put("users",users);
                
                //Base.close();
                return new ModelAndView(attributes, "webApp/play.mustache");
            }, new MustacheTemplateEngine());
        
        
    //--------------------------------------------------------------------------
        //Metodo post que carga usuarios ya registrados
            post("/play", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                System.out.println("*-*-"+request.queryParams("Usuario1R"));
                System.out.println("*-*-"+request.queryParams("Usuario2R"));
            
                
                String player1 = request.queryParams("combobox_usuario1");
                String player2 = request.queryParams("combobox_usuario2");
                System.out.println(("****"+player1));
                System.out.println(("****"+player2));
                tablero.setIdp1(Integer.parseInt(player1));
                tablero.setIdp2(Integer.parseInt(player2));
                
                
                
              
                
             
               tablero.toStringShell();
                String test = tablero.toStringB();
                attributes.put("tablero",test);
                if (!(player1.equals( player2))){
                 
                    attributes.put("usuario1",player1);
                    attributes.put("usuario2",player2);
                    attributes.put("jugador",1);
                    return new ModelAndView(attributes, "webApp/game.mustache");
                    
                   //return new ModelAndView(null, "game.mustache"); 
                }else{
                    return new ModelAndView(null, "webApp/nogame.mustache"); 
                }
               
            }, new MustacheTemplateEngine());
    //--------------------------------------------------------------------------
            //Metodo que registra usuario nuevo
            post("/registrar", (request, response) -> {
                String usuario = request.queryParams("Usuario1");
                String nombre = request.queryParams("nombre1");
                String apellido = request.queryParams("apellido1");
                String mail = request.queryParams("mail1");
                //Base.open(driver,jdbs,usubd,contrbd);
                boolean a = registrar(usuario,nombre,apellido,mail);
                
                if (a){
                    Map<String, Object> attributes = new HashMap<>();
                    List <User> users = User.findAll();
                    System.out.println("findall**********  "+users);
                    attributes.put("users",users);
                    //Base.close();
                   return new ModelAndView(attributes, "webApp/play.mustache"); 
                }else{
                    //Base.close();
                    return new ModelAndView(null, "webApp/nogame.mustache"); 
                }
               
            }, new MustacheTemplateEngine());
            
    //--------------------------------------------------------------------------
            post("/game", (request,response) -> {
                int player1 = tablero.getIdp1();
                int player2 = tablero.getIdp2();
                int jugador;
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("usuario1",player1);
                attributes.put("usuario2",player2);
                int i=0;
                while((request.queryParams("tirar"+i))==null){
                    i++;
                }
                int turno=tablero.getTurno();
                if(turno%2==0){
                    jugador=2;
                
                }else{
                    jugador=1;
                
                }
                BoardTools.move(tablero,i,jugador);
                if(BoardTools.checkBoard(tablero)){
                   //tablero.clear();
                   //Base.open(driver,jdbs,usubd,contrbd);
                   int perdedor;
                   int perdedorId;
                   int ganador = jugador;
                   int ganadorId;
                   if (ganador==1){
                       perdedor=2;
                       ganadorId=tablero.getIdp1();
                   }else{
                       perdedor=1;
                       ganadorId=tablero.getIdp2();
                   }
                   if (perdedor==1){
                       perdedorId=tablero.getIdp1();
                   }else{
                       perdedorId=tablero.getIdp2();
                   }
                       
                  
                    //Cargo datos del rank ganador
                  List<User> ganadorList = User.where("id=?",ganadorId);
                  User uGanador = ganadorList.get(0);
                  List<Rank> ganadorRank = Rank.where("user_id =?",uGanador.getId());
                  
                  //DATOS DEL PERDEDOR
                  List<User> perdedorList = User.where("id=?",perdedorId);
                  User uPerdedor = perdedorList.get(0);
                  List<Rank> perdedorRank = Rank.where("user_id =?",uPerdedor.getId());
                  
                  System.out.println("id perdedor: "+perdedorId+" id ganador "+ganadorId);
                  //CARGO DATOS GANADOR
                  if (ganadorRank.isEmpty()){
                      System.out.println("CREO NEW RANK");
                        Rank r0 = new Rank();
                        r0.set("games_won",1);
                        r0.set("games_played",1);
                        r0.save();
                        uGanador.add(r0);
                        
                        uGanador.save();
                  }else{
                     //el usuario ganador si estaba en el ranking
                      System.out.println("estaba creado");
                        Rank r1 = ganadorRank.get(0);
                        r1.set("games_won",r1.getInteger("games_won")+1);
                        r1.set("games_played",r1.getInteger("games_played")+1);
                         r1.save();
                        uGanador.add(r1);
                       
                        uGanador.save();
                   }
                  if (perdedorRank.isEmpty()){
                         System.out.println("CREO NEW RANK perdedor");
                        Rank r2 = new Rank();
                        r2.set("games_won",0);
                        r2.set("games_played",1);
                        r2.save();
                        uPerdedor.add(r2);
                        
                        uPerdedor.save();
                  }else{
                     //el usuario perdedor si estaba en el ranking
                      System.out.println("estaba creado perdedor");
                        Rank r3 = perdedorRank.get(0);
                        r3.set("games_played",r3.getInteger("games_played")+1);
                        r3.save();
                        uPerdedor.add(r3);
                       
                        uPerdedor.save();
                   } 
               
                   
                   
                 
                  
                //registro el juego con su ganador
                Game game = new Game();
     
       
                 game.set("player1_id",tablero.getIdp1());
                 game.set("player2_id",tablero.getIdp2());
                 game.set("win_id",uGanador.getId());
                 game.save();
                 tablero.clear(); 
                
                return new ModelAndView(null,"webApp/ganador.html");
                
                }else{
               
               
               attributes.put("jugador",jugador);
               String test = tablero.toStringB();
               attributes.put("tablero",test);
               attributes.put("usuario1",player1);
               attributes.put("usuario2",player2);
              System.out.println("siguiente"+jugador);
               //Base.close();
               return new ModelAndView(attributes,"webApp/game.mustache");}
            }, new MustacheTemplateEngine());
     
    //--------------------------------------------------------------------------    
            
            get("/", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("message", "Hello FreeMarker World");

               return new ModelAndView(attributes, "webApp/hello.mustache");
            }, new MustacheTemplateEngine());
    //--------------------------------------------------------------------------
           
            post("/rank", (request,response) -> {
               Map<String, Object> attributes = new HashMap<>();
                //Base.open(driver,jdbs,usubd,contrbd);
                List <Rank> ranking = Rank.findAll();
                List<User> usuario = User.findAll();
                int i=0;
                int j=0;
                String rankeado="";
                while(i<ranking.size()){
                    while (j<usuario.size()){
                        if ((ranking.get(i).getInteger("user_id"))==(usuario.get(j).getInteger("id"))){
                            rankeado="Juegos Ganados "+ranking.get(i).getInteger("games_won")+" Usuario "+usuario.get(j).getString("username");
                            attributes.put("rankings",rankeado);
                        }
                        j++;
                    }
                    i++;
                }
                //attributes.put("rankings",rankeado);
               //Base.close();
               return new ModelAndView(attributes,"webApp/rank.mustache");
            }, new MustacheTemplateEngine());
            
        
        /*--------------------------------------------------------------------*/    
           post("/guardar", (request,response) -> {
               Map<String, Object> attributes = new HashMap<>();
                //Base.open(driver,jdbs,usubd,contrbd);
                int player1 = tablero.getIdp1();
                int player2 = tablero.getIdp2();
                Game game = new Game();
                List<User> ulist1 = User.where("id=?",player1);
                List<User> ulist2 = User.where("id=?",player2);
                game.set("player1_id",ulist1.get(0).getId());
                game.set("player2_id",ulist2.get(0).getId());
                game.set("win_id",null);
                game.save();
                List <Game> gamlist = Game.where("(player1_id=? and player2_id=?) or (player1_id=? and player2_id=?)",ulist1.get(0).getId(),ulist2.get(0).getId(),ulist2.get(0).getId(),ulist1.get(0).getId());
                if (!gamlist.isEmpty()){
                    int idgame=0;
                    int i=0;
                    while(i<gamlist.size()){
                           idgame= (int) gamlist.get(i).getId();
                           i++;
                       }
                    saveGame(tablero,idgame);
                 }else{
                    
                
                   }
                 
                
                
                //Base.close(); 
                tablero.clear();
               return new ModelAndView(null,"webApp/hello.mustache");
            }, new MustacheTemplateEngine());
            
                
	
    
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
}
    public static void saveGame(Board tablero,Integer idgame){
        int columnas=tablero.getColumns();
        int filas=tablero.getRows();
      
          int index=0;
            Cell[] arreglo= new Cell[tablero.getNumberOfCells()];
            for(int i = 0; i<filas;i++){
                for(int j = 0; j<columnas;j++){
                    arreglo[index]=new Cell();
                    arreglo[index].set("fila",i,"columna",j,"valor",tablero.getCell(i,j),"game_id",idgame);
                    arreglo[index].save();
                    index++;
                }
            }
      }
    
    
    
    private static boolean jugar(String player1, String player2){
       boolean res;
       if (!(player1.equals(player2))){  
        List<User> usuario1 = User.where("id=?",player1);
        List<User> usuario2 = User.where("id=?",player2);
        if ((usuario1.isEmpty())&&(usuario2.isEmpty())){
                 //INFORMAR QUE DEBE REGISTRARSE
                 res= false;
         }else{
            res= true;
         }
       }else{
           res=false;
       } 
       return res;
    }
   
        
        
    
    
  
     
        public static boolean registrar(String usuario,String nombre,String apellido,String mail){
            List<User> usuarioL = User.where("username=?",usuario);
             if (usuarioL.isEmpty()){
                  UserChecks.newUser(apellido,nombre,mail,usuario);
                  return true;
             }else{
                 return false;
             }
    }
        
        
        
 
        
        
        
    }
       
    

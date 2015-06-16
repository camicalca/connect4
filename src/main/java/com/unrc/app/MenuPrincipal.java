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
                return new ModelAndView(attributes, "game.mustache");
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
                return new ModelAndView(attributes, "play.mustache");
            }, new MustacheTemplateEngine());
        
     //------------------------------------------------------------------------
       get("/hello", (request, response) -> {
                //Base.open(driver,jdbs,usubd,contrbd);
                
           
                Map<String, Object> attributes = new HashMap<>();
                List <User> users = User.findAll();
                System.out.println("findall**********  "+users);
                attributes.put("users",users);
                
                //Base.close();
                return new ModelAndView(attributes, "play.mustache");
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
                    return new ModelAndView(attributes, "game.mustache");
                    
                   //return new ModelAndView(null, "game.mustache"); 
                }else{
                    return new ModelAndView(null, "nogame.mustache"); 
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
                   return new ModelAndView(attributes, "play.mustache"); 
                }else{
                    //Base.close();
                    return new ModelAndView(null, "nogame.mustache"); 
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
                   int perdedor =0;
                   int ganador = jugador;
                   if(jugador==1){
                       perdedor=tablero.getIdp2();
                   }else{
                       perdedor=tablero.getIdp1();
                   }
                   //Cargo datos del rank ganador
                   List<User> list = User.where("id=?",ganador);
                   List<Rank> list1;
                   User u = list.get(0);
                   list1 = Rank.where("user_id =?",u.getId());
                   //Cargo datos del rank perdedor
                   List<User> list2 = User.where("id=?",perdedor);
                   List<Rank> list3;
                   User p = list2.get(0);
                   list3 = Rank.where("user_id =?",p.getId());
                   
                   if (list3.isEmpty()){
                    //el usuario perdedor no estaba en el ranking
                    Rank r = new Rank();

                    //r.set("user_id",list.get(1));
                    r.set("games_won",0);
                    r.set("games_played",1);
                    u.add(r);
                    r.save();
                    u.save();

                }else{
                    //el usuario perdedor si estaba en el ranking
                    Rank r = list1.get(0);
                    r.set("games_won",r.getInteger("games_won"));
                    r.set("games_played",r.getInteger("games_played")+1);
                    u.add(r);
                    r.save();
                    u.save();
                    
                } 
                   
                //Cargo rank del jugador ganador
                
                 if (list1.isEmpty()){
                    //el usuario ganador no estaba en el ranking
                    Rank r = new Rank();

                    //r.set("user_id",list.get(1));
                    r.set("games_won",1);
                    r.set("games_played",1);
                    u.add(r);
                    r.save();
                    u.save();

                }else{
                    //el usuario ganador si estaba en el ranking
                    Rank r = list1.get(0);
                    r.set("games_won",r.getInteger("games_won")+1);
                    r.set("games_played",r.getInteger("games_played")+1);
                    u.add(r);
                    r.save();
                    u.save();
                    
                }
                  
                //registro el juego con su ganador
                Game game = new Game();
     
                 List<User> ulist1 = User.where("id=?",player1);
                 List<User> ulist2 = User.where("id=?",player2);
                 List<User> ulistWin = User.where("id=?",ganador);
                 game.set("player1_id",ulist1.get(0).getId());
                 game.set("player2_id",ulist2.get(0).getId());
                 game.set("win_id",ulistWin.get(0).getId());
                 game.save();
                 tablero.clear(); 
                
                return new ModelAndView(null,"ganador.html");
                
                }else{
               
               
               attributes.put("jugador",jugador);
               String test = tablero.toStringB();
               attributes.put("tablero",test);
               attributes.put("usuario1",player1);
               attributes.put("usuario2",player2);
              System.out.println("siguiente"+jugador);
               //Base.close();
               return new ModelAndView(attributes,"game.mustache");}
            }, new MustacheTemplateEngine());
     
    //--------------------------------------------------------------------------    
            
            get("/", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("message", "Hello FreeMarker World");

               return new ModelAndView(attributes, "hello.mustache");
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
               return new ModelAndView(attributes,"rank.mustache");
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
               return new ModelAndView(null,"hello.mustache");
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
    private static void reanudarPartida(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el id del juego guardado");
        Integer idJuego = reader.nextInt();
        List<Game> lJuego = Game.where("id=?",idJuego);
        List<Cell> lCell = Cell.where("game_id=?",idJuego);
        if (lJuego.isEmpty() || lCell.isEmpty()){
            
             System.out.println("ID NO VALIDO");
            
        }else{
            Integer idUser1 = lJuego.get(0).getInteger("player1_id");
            List<User> user1 = User.where("id=?",idUser1);
            
            
            Integer idUser2 = lJuego.get(0).getInteger("player2_id");
            List<User> user2 = User.where("id=?",idUser2);
            
            String player1 = user1.get(0).getString("username");
            String player2 = user2.get(0).getString("username");
           // Board tableroGuardado = NewGame.loadBoard(idJuego);
           // NewGame.play(tableroGuardado, player1, player2);
            
        }
        
        
    
    }
    private static void verRanking(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el username del usuario");
        String username = reader.next();
        List<User> userL = User.where("username=?",username);
        if(userL.isEmpty()){
            System.out.println("Usuario no encontrado");
        }else{
            List<Rank> rankl = Rank.where("user_id=?",userL.get(0).getInteger("id"));
            System.out.println("Juegos ganados del usuario "+username+": "+rankl.get(0).getInteger("games_won"));
        }
        
        
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
        
        
        
    
    private static void eliminarUsuario(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el username del usuario a eliminar (Borra en cascada)");
        String username = reader.next();
        User usuario = User.findFirst("username=?",username);
        usuario.deleteCascade();
    
    }
   
        
        
        
    }
       
    

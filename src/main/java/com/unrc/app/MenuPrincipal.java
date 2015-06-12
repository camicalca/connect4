/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;
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
        
    //--------------------------------------------------------------------------
        post("/jugar", (request, response) -> {
                Base.open(driver,jdbs,usubd,contrbd);
                Map<String, Object> attributes = new HashMap<>();
                List <User> users = User.findAll();
                System.out.println("findall**********  "+users);
                attributes.put("users",users);
                Base.close();
                return new ModelAndView(attributes, "play.mustache");
            }, new MustacheTemplateEngine());
        
     //------------------------------------------------------------------------
       get("/hello", (request, response) -> {
                Base.open(driver,jdbs,usubd,contrbd);
                
           
                Map<String, Object> attributes = new HashMap<>();
                List <User> users = User.findAll();
                System.out.println("findall**********  "+users);
                attributes.put("users",users);
                Base.close();
                return new ModelAndView(attributes, "play.mustache");
            }, new MustacheTemplateEngine());
        
        
    //--------------------------------------------------------------------------
        //Metodo post que carga usuarios ya registrados
            post("/play", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                System.out.println(request.queryParams("Usuario1R"));
                System.out.println(request.queryParams("Usuario2R"));

                
                System.out.println(request.queryMap());
                System.out.println(request.attributes());
                String player1 = request.queryParams("combobox_usuario1");
                String player2 = request.queryParams("combobox_usuario2");
                System.out.println(("****"+player1));
                System.out.println(("****"+player2));
                
                Base.open(driver,jdbs,usubd,contrbd);
                boolean a = jugar(player1,player2);
                Base.close();
                
                Base.open(driver,jdbs,usubd,contrbd);
                Board tablero = new Board();
                System.out.println("tablero"+tablero.toStringB());
                String test = " <table> <tr>\n" +		
                "<td>"+tablero.getCell(0,0)+"</td>\n" +
 "<td>"+tablero.getCell(0,1)+"</td>\n"+
"<td>"+tablero.getCell(0,2)+"</td>\n" +
"<td>"+tablero.getCell(0,3)+"</td>\n" +
"<td>"+tablero.getCell(0,4)+"</td>\n" +
"<td>"+tablero.getCell(0,5)+"</td>\n" +
"		</tr> <tr>\n" +		
                "<td>"+tablero.getCell(1,0)+"</td>\n" +
 "<td>"+tablero.getCell(1,1)+"</td>\n"+
"<td>"+tablero.getCell(1,2)+"</td>\n" +
"<td>"+tablero.getCell(1,3)+"</td>\n" +
"<td>"+tablero.getCell(1,4)+"</td>\n" +
"<td>"+tablero.getCell(1,5)+"</td>\n" +
"		</tr> <tr>\n" +		
                "<td>"+tablero.getCell(2,0)+"</td>\n" +
 "<td>"+tablero.getCell(2,1)+"</td>\n"+
"<td>"+tablero.getCell(2,2)+"</td>\n" +
"<td>"+tablero.getCell(2,3)+"</td>\n" +
"<td>"+tablero.getCell(2,4)+"</td>\n" +
"<td>"+tablero.getCell(2,5)+"</td>\n" +
"		</tr> <tr>\n" +		
                "<td>"+tablero.getCell(3,0)+"</td>\n" +
 "<td>"+tablero.getCell(3,1)+"</td>\n"+
"<td>"+tablero.getCell(3,2)+"</td>\n" +
"<td>"+tablero.getCell(3,3)+"</td>\n" +
"<td>"+tablero.getCell(3,4)+"</td>\n" +
"<td>"+tablero.getCell(3,5)+"</td>\n" +
"		</tr> <tr>\n" +		
                "<td>"+tablero.getCell(4,0)+"</td>\n" +
 "<td>"+tablero.getCell(4,1)+"</td>\n"+
"<td>"+tablero.getCell(4,2)+"</td>\n" +
"<td>"+tablero.getCell(4,3)+"</td>\n" +
"<td>"+tablero.getCell(4,4)+"</td>\n" +
"<td>"+tablero.getCell(4,5)+"</td>\n" +
"		</tr> <tr>\n" +		
                "<td>"+tablero.getCell(5,0)+"</td>\n" +
 "<td>"+tablero.getCell(5,1)+"</td>\n"+
"<td>"+tablero.getCell(5,2)+"</td>\n" +
"<td>"+tablero.getCell(5,3)+"</td>\n" +
"<td>"+tablero.getCell(5,4)+"</td>\n" +
"<td>"+tablero.getCell(5,5)+"</td>\n" +
"		</tr> <tr>\n" +		
                "<td>"+tablero.getCell(6,0)+"</td>\n" +
 "<td>"+tablero.getCell(6,1)+"</td>\n"+
"<td>"+tablero.getCell(6,2)+"</td>\n" +
"<td>"+tablero.getCell(6,3)+"</td>\n" +
"<td>"+tablero.getCell(6,4)+"</td>\n" +
"<td>"+tablero.getCell(6,5)+"</td>\n" +
"		</tr> </table>";
                attributes.put("tablero",test);
                if (a){
                    
                    attributes.put("usuario1",player1);
                    attributes.put("usuario2",player2);
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
                Base.open(driver,jdbs,usubd,contrbd);
                boolean a = registrar(usuario,nombre,apellido,mail);
                Base.close();
                if (a){
                   return new ModelAndView(null, "play.mustache"); 
                }else{
                    return new ModelAndView(null, "nogame.mustache"); 
                }
               
            }, new MustacheTemplateEngine());
            
    //--------------------------------------------------------------------------
            get("/game", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
                Base.open(driver,jdbs,usubd,contrbd);
                Board tablero = new Board();
                System.out.println("tablero"+tablero.toStringB());
                String test = "<table> <tr>\n" +		
                "<td>0</td>\n" +
 "<td>0</td>\n"+
"<td>1</td>\n" +
"<td>2</td>\n" +
"<td>3</td>\n" +
"<td>4</td>\n" +
"		</tr> </table>";
                attributes.put("tablero",test);
                Base.close();
               return new ModelAndView(attributes, "game.mustache");
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
                Base.open(driver,jdbs,usubd,contrbd);
                List <Rank> ranking = Rank.findAll();
                attributes.put("rankings",ranking);
                //Base.close();
               return new ModelAndView(attributes,"rank.mustache");
            }, new MustacheTemplateEngine());
            
           /* post("/gameload", (request,response) -> {
               Map<String, Object> attributes = new HashMap<>();
                Base.open(driver,jdbs,usubd,contrbd);
                List <Game> partida = Game.findAll();
                attributes.put("partida",partida);
                //Base.close(); 
               return new ModelAndView(attributes,"????.mustache");
            }, new MustacheTemplateEngine());
        */
            
            
	}
    
    //--------------------------------------------------------------------------
        
    
    //--------------------------------------------------------------------------
    
    private static boolean jugar(String player1, String player2){
        
        List<User> usuario1 = User.where("id=?",player1);
        List<User> usuario2 = User.where("id=?",player2);
        
         if ((usuario1.isEmpty())&&(usuario2.isEmpty())){
                 //INFORMAR QUE DEBE REGISTRARSE
                 return false;
             }else{
                 /*
                 Board tablero = new Board();
                 NewGame.play(tablero,player1,player2);
                 */
                 return true;
             }
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
       
    

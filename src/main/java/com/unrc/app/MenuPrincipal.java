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
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.Spark.post;
/**
 *
 * @author santiago
 */
public class MenuPrincipal {
       
    public static void mostrarMenuPrincipal(){
    //--------------------------------------------------------------------------
        get("/play", (request, response) -> {
                
                // The hello.ftl file is located in directory:
                // src/test/resources/spark/examples/templateview/freemarker
               return new ModelAndView(null, "play.mustache");
            }, new MustacheTemplateEngine());
    //--------------------------------------------------------------------------
        //Metodo post que carga usuarios ya registrados
            post("/play", (request, response) -> {
                
                System.out.println(request.queryParams("Usuario1R"));
                System.out.println(request.queryParams("Usuario2R"));

                
                System.out.println(request.queryMap());
                System.out.println(request.attributes());
                String player1 = request.queryParams("Usuario1R");
                String player2 = request.queryParams("Usuario2R");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "Control123");
                boolean a = jugar(player1,player2);
                Base.close();
                if (a){
                   return new ModelAndView(null, "game.mustache"); 
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
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "Control123");
                boolean a = registrar(usuario,nombre,apellido,mail);
                Base.close();
                if (a){
                   return new ModelAndView(null, "play.mustache"); 
                }else{
                    return new ModelAndView(null, "nogame.mustache"); 
                }
               
            }, new MustacheTemplateEngine());
            
     
    //--------------------------------------------------------------------------    
            
            get("/", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("message", "Hello FreeMarker World");

                // The hello.ftl file is located in directory:
                // src/test/resources/spark/examples/templateview/freemarker
               return new ModelAndView(attributes, "hello.mustache");
            }, new MustacheTemplateEngine());
        
        
        
	}
    private static boolean jugar(String player1, String player2){
        
        List<User> usuario1 = User.where("username=?",player1);
        List<User> usuario2 = User.where("username=?",player2);
        
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
            Board tableroGuardado = NewGame.loadBoard(idJuego);
            NewGame.play(tableroGuardado, player1, player2);
            
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
       
    

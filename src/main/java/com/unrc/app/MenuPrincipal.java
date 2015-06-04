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
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.Spark.post;
/**
 *
 * @author santiago
 */
public class MenuPrincipal {
       
    public static void mostrarMenuPrincipal(){
        get("/play", (request, response) -> {
                
                // The hello.ftl file is located in directory:
                // src/test/resources/spark/examples/templateview/freemarker
               return new ModelAndView(null, "play.mustache");
            }, new MustacheTemplateEngine());
            post("/play", (request, response) -> {
                
                System.out.println(request.queryParams("jugador1"));
                
                System.out.println(request.queryMap());
                System.out.println(request.attributes());
               return new ModelAndView(null, "game.mustache");
            }, new MustacheTemplateEngine());
            
            
            get("/", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("message", "Hello FreeMarker World");

                // The hello.ftl file is located in directory:
                // src/test/resources/spark/examples/templateview/freemarker
               return new ModelAndView(attributes, "hello.mustache");
            }, new MustacheTemplateEngine());
        
        
        Integer opcion=-1;
        /*Scanner entrada;
            System.out.println("================================");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1---->Jugar");
            System.out.println("2---->Ver stats de un usuario");
            System.out.println("3---->Eliminar usuario");
            System.out.println("4---->Reanudar partida guardada");
            System.out.println("5---->Para salir");
            System.out.println("================================");
        while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6  ){
           entrada = new Scanner(System.in);
           opcion = entrada.nextInt();
           
        }*/
        switch (opcion) {
			case 1: jugar();
				break;
			case 2: verRanking();
				break;
                        case 3: eliminarUsuario();
				break;
                        case 4: reanudarPartida();
				break;
			case 5: System.out.println("SALIENDO...");
				break;
		}
	}
    private static void jugar(){
        String player1 = null;
        String player2 = null;
        for (int i=1;i<3;i++){
             Scanner reader = new Scanner(System.in);
             System.out.println("Ingrese el username del jugador "+i);
             String username = reader.next();
             List<User> usuarioL = User.where("username=?",username);
             if (usuarioL.isEmpty()){
             //no existe
                System.out.println("USUARIO NO ENCONTRADO, CREE UNO"); 
                System.out.println("Ingrese el apellido del jugador "+i);
                String last_name = reader.next();
                System.out.println("Ingrese el nombre del jugador "+i);
                String first_name = reader.next();
                System.out.println("Ingrese el el mail del jugador "+i);
                String email = reader.next();
                UserChecks.newUser(last_name,first_name,email,username);
                if (i==1){player1=username;}else{player2=username;}
             }else{
                 System.out.println("USUARIO ENCONTRADO"); 
                  if (i==1){player1=usuarioL.get(0).getString("username");}else{player2=usuarioL.get(0).getString("username");}
             
             
             }
        
       
        }
        
        Board tablero = new Board();
        NewGame.play(tablero,player1,player2);
       
    
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
    private static void eliminarUsuario(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el username del usuario a eliminar (Borra en cascada)");
        String username = reader.next();
        User usuario = User.findFirst("username=?",username);
        usuario.deleteCascade();
    
    }
        
        
        
    }
       
    

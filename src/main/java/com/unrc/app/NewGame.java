/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author santiago
 */
public class NewGame {
   
    
    //
    //FALTA AGREGAR LAS PARTIDAS JUGADAS AL JUGADOR QUE NO GANO
    public static void play(Board tablero,String player1, String player2){
        boolean guardar=false;
        int counter = 0;
        tablero.toStringB();
        int player=1;
        String juega = null;
        int countfich=0;
       
        
        while ((!BoardTools.checkBoard(tablero))&&(countfich<tablero.getNumberOfCells())&&(guardar==false)){
            if (counter%2==0){
                player=1;
                juega=player1;
            }
            else{
                player = 2;
                juega=player2;
            }
            System.out.println("==================");
             System.out.println("  Precione 100----->Guardar Partida");
            System.out.println( "  Ingrese columna del TURNO DE: "+juega);
            Scanner scan = new Scanner (System.in);
            int c = scan.nextInt();
            if (c==100){
                guardar= true;
                
            }else{
                countfich++;
                BoardTools.move(tablero,c,player);
                counter++;
                System.out.println("==================");
                tablero.toStringB();
            }
        }
        
        if(guardar==true){
            Game game = new Game();
           
                 List<User> ulist1 = User.where("username=?",player1);
                 List<User> ulist2 = User.where("username=?",player2);
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
                 }
                 
                 
                
                
        }else{
        
        
        
        //Termino juego ----> se guardan datos en la base de datos
            if(countfich==tablero.getNumberOfCells()){
                //hubo un empate
                System.out.println("Juego Empatado");
                Game game = new Game();
     
                 List<User> ulist1 = User.where("username=?",player1);
                 List<User> ulist2 = User.where("username=?",player2);
                 game.set("player1_id",ulist1.get(0).getId());
                 game.set("player2_id",ulist2.get(0).getId());
                 game.set("win_id",null);
                 game.save();
           
            }else{
                //consulto jugadro no ganador
                String perdedor = null;
                if (juega==player1){
                    perdedor = player2;
                }else{
                       perdedor=player1;
                     }
                
                //Hubo un ganador
                //Cargo datos del rank ganador
                System.out.println("El jugador "+juega+" gano el juego");
                String ganador = juega;
                List<User> list = User.where("username =?",ganador);
                List<Rank> list1;
                User u = list.get(0);
                list1 = Rank.where("user_id =?",u.getId());
                System.out.println(u.getId());
                System.out.println("list"+u.getIdName());
                //Cargo datos del rank perdedor
                List<User> list2 = User.where("username =?",perdedor);
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
     
                 List<User> ulist1 = User.where("username=?",player1);
                 List<User> ulist2 = User.where("username=?",player2);
                 List<User> ulistWin = User.where("username=?",ganador);
                 game.set("player1_id",ulist1.get(0).getId());
                 game.set("player2_id",ulist2.get(0).getId());
                 game.set("win_id",ulistWin.get(0).getId());
                 game.save();
            
            }
        }     
            
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
    public static Board loadBoard(Integer gameid){
          List<Cell> cellList = Cell.where("game_id=?",gameid);
          Board tableroCargado = new Board();
          int index = 0;
          while(index<cellList.size()){
              tableroCargado.setCell(cellList.get(index).getInteger("fila"),cellList.get(index).getInteger("columna"), cellList.get(index).getInteger("valor"));
              index++;
          }
          return tableroCargado;
      
      
      
      }
        

}

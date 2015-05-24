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
        int counter = 0;
        tablero.toStringB();
        int player=1;
        String juega = null;
        int countfich=0;
       
        
        while ((!BoardTools.checkBoard(tablero))&&(countfich<tablero.getNumberOfCells())){
            if (counter%2==0){
                player=1;
                juega=player1;
            }
            else{
                player = 2;
                juega=player2;
            }
            System.out.println("TURNO DE: "+juega);
            Scanner scan = new Scanner (System.in);
            int c = scan.nextInt();
            countfich++;
            BoardTools.move(tablero,c,player);
            counter++;
            System.out.println("==================");
            tablero.toStringB();
        }
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
                //Hubo un ganador
                System.out.println("El jugador "+juega+" gano el juego");
                String ganador = juega;
                List<User> list = User.where("username =?",ganador);
                List<Rank> list1;
                User u = list.get(0);
                list1 = Rank.where("user_id =?",u.getId());
                System.out.println(u.getId());
                System.out.println("list"+u.getIdName());
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

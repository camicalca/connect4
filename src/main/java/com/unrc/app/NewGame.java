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
   
    
    
    public static void jugar(Board tablero,String player1, String player2){
        int counter = 0;
        tablero.toStringB();
        int player=1;
        String juega = null;
        int countfich=0;
        int columnas=tablero.getMatrix()[0].length;
        int filas=tablero.getMatrix().length;
        
        while ((!CheckBoard.checkBoard(tablero))&&(countfich<filas*columnas)){
            if (counter%2==0){
                player=1;
                juega=player1;
            }
            else{
                player = 2;
                juega=player2;
            }
            System.out.println("Ingrese la columna el usuario "+juega);
            Scanner scan = new Scanner (System.in);
            int c = scan.nextInt();
            countfich++;
            CheckBoard.move(tablero,c,player);
            counter++;
            System.out.println("==================");
            tablero.toStringB();
        }
            if(countfich==filas*columnas){
                System.out.println("Juego Empatado");
           
            }else{
                //Consulatar Rank------>
                System.out.println("El jugador "+juega+" gano el juego");
                List<User> list = User.where("username =?",juega);
                List<Rank> list1;
                User u = list.get(0);
                list1 = Rank.where("user_id =?",u.getId());
                System.out.println(u.getId());
                System.out.println("list"+u.getIdName());
                if (list1.isEmpty()){
                    Rank r = new Rank();
                    System.out.println("Creando nuevo Rak");
                    //r.set("user_id",list.get(1));
                    r.set("games_won",1);
                    u.add(r);
                    r.save();
                    u.save();

                }else{
                    System.out.println("Modificando Rank");
                    Rank r = list1.get(0);
                    r.set("games_won",r.getInteger("games_won")+1);
                    u.add(r);
                    r.save();
                    u.save();
                } 
            
        }
         
            Game game = new Game();
     
            List<User> ulist1 = User.where("username=?",player1);
            List<User> ulist2 = User.where("username=?",player2);
            game.set("player1_id",ulist1.get(0).getId());
            game.set("player2_id",ulist2.get(0).getId());
            game.save();
            
      }
      public static void saveGame(Board tablero,Integer idgame){
        int columnas=tablero.getMatrix()[0].length;
        int filas=tablero.getMatrix().length;
      
          int index=0;
            Cell[] arreglo= new Cell[tablero.getNumberOfCells()];
            for(int i = 0; i<filas;i++){
                for(int j = 0; j<columnas;j++){
                    System.out.println("entre for");
                    arreglo[index]=new Cell();
                    arreglo[index].set("fila",i,"columna",j,"valor",tablero.getCell(i,j),"game_id",1);
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

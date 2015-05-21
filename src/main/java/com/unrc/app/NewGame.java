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
        System.out.println(tablero==null);
        tablero.toStringB();
        int player=1;
        String juega = null;
        int countfich=0;
        int columnas=tablero.getMatrix()[0].length;
        int filas=tablero.getMatrix().length;
        System.out.println(filas*columnas);
        
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
                list1 = Rank.where("user_id =?",list.get(0));
                User u = list.get(0);
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
                    Rank r = new Rank();
                    r.set("games_won",list1.get(3));
                    u.add(r);
                    r.save();
                    u.save();
                } 
            
        }

    
    
    }
}

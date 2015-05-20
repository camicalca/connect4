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
        while (!CheckBoard.checkBoard(tablero)){
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
            
            CheckBoard.move(tablero,c,player);
            counter++;
            System.out.println("==================");
            tablero.toStringB();


        }
        //Consulatar Rank------>
        System.out.println("El jugador "+juega+" gano el juego");
        List<User> list = User.where("username =?",juega);
        User u = list.get(0);
        System.out.println("list"+u.getIdName());
        if (list.isEmpty()){
            System.out.println("Usuario ganador no registrado");
        }else{
            Rank r = new Rank();
            System.out.println("Rank");
            /* CONSULTAR */
            r.set("user_id",list.get(1));
            r.set("position",0);
            r.set("games_won",0);
            u.add(r);
            System.out.println("2");
            if (!u.exists()){
                System.out.println("3");
                u.save();
            }
        }   
    
    
    
    }
}

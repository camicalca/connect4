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
        //Consulatar Rank----->
        System.out.println("El jugador "+juega+" gano el juego");
        List<User> list = User.where("username =?",juega);
        User p = list.get(0);
        System.out.println("list"+p.getIdName());
        if (list.isEmpty()){
            System.out.println("Usuario ganador no registrado");
        }else{
            Rank u = new Rank();
            System.out.println("Rank");
            /* CONSULTAR */
            u.set("user_id",list.get(1));
            u.set("position",0);
            u.set("games_won",0);
            System.out.println("2");
            if (!u.exists()){
                System.out.println("3");
                u.save();
            }
        }   
    
    
    
    }
}

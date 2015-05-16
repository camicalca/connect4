/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;
import java.util.Scanner;
/**
 *
 * @author santiago
 */
public class NewGame {
    private Board tablero ;
    
    public NewGame(){
        Board tablero = new Board();
    }
    
    
    public void jugar(){
        int counter = 0;
        tablero.toStringB();
        int player=1;
        while (!CheckBoard.checkBoard(tablero)){
            System.out.println("Ingrese la columna 0-5");
            Scanner scan = new Scanner (System.in);
            int c = scan.nextInt();
            if (counter%2==0){
                player=1;
            }
            else{
                player = 2;
            }
            CheckBoard.move(tablero,c,player);
            counter++;
            System.out.println("==================");
            tablero.toStringB();


        }
        System.out.println("El jugador "+player+" gano el juego");

    
    
    
    
    }
}

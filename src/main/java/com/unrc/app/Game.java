/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;

/**
 *
 * @author santiago
 */
public class Game {
   private  User player1;
   private  User player2;
   private Tablero tabla;
    
    
    public Game(User player1,User player2,Tablero tabla){
    this.player1 = player1;
    this.player2 = player2;
    this.tabla = tabla;
    
    
    }
}

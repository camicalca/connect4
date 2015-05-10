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
   private Board board;
    
    
    public Game(User player1,User player2,Board board){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }
}

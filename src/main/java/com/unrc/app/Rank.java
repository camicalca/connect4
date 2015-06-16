package com.unrc.app;

import org.javalite.activejdbc.Model;

public class Rank extends Model{

    static Rank findById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public String toStringu (){
    return this.getString("user_id");
}   
   
   public String toStringgw (){
    return this.getString("games_won");
}   
  
   public String toStringgp (){
    return this.getString("games_played");
}   

}
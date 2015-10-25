package com.unrc.app.Models;

import org.javalite.activejdbc.Model;

public class Rank extends Model{

    static Rank findById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public String toStringu (){
    int u_id=this.getInteger("user_id");
    User u = User.findFirst("id=?",u_id);
    return u.getString("username");
}   
   
   public String toStringgw (){
    return this.getString("games_won");
}   
  
   public String toStringgp (){
    return this.getString("games_played");
   }
   public String toStringEff (){
       float jugados= this.getInteger("games_played");
       float ganados =this.getInteger("games_won");
 
     float eff = (ganados/jugados)*100;
    return String.valueOf(eff)+"%";
   }  

}
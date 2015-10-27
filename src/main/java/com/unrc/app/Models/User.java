package com.unrc.app.Models;

import org.javalite.activejdbc.Model;

public class User extends Model {
   static {
    validatePresenceOf("first_name");
  }
   @Override
   public String toString (){
    return this.getString("username");
}   

}

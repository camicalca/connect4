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
public class UserChecks {
    

    public static User newUser(String last_name,String first_name,String username,String password,String email){
        User u = new User();
        u.set("username",username,"last_name",last_name,"pass",password,"email",email,"first_name",first_name);
        if (!u.exists()){
            u.save();
            return u;
        }else{
            return null;
            
        }
        
    
    
    
    }
}

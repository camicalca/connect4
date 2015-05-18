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
    

    public static User newUser(String last_name,String first_name,String email){
        User u = new User();
        System.out.println("1");
        System.out.println("1"+first_name+last_name+email);
        u.set("first_name",first_name);
        u.set("last_name",last_name);
        u.set("email",email);
        System.out.println("2");
        if (!u.exists()){
            System.out.println("3");
            u.saveIt();
            return u;
        }else{
            return null;
            
        }
        
    
    
    
    }
}

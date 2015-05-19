/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;

import java.util.List;
import org.javalite.activejdbc.Base;

/**
 *
 * @author santiago
 */
public class UserChecks {
    

    public static void newUser(String last_name,String first_name,String email,String username){
        List<User> list = User.where("username =?",username);
        if (list.isEmpty()){
            User u = new User();
            System.out.println("1");
            System.out.println("1"+first_name+last_name+email);
            u.set("first_name",first_name);
            u.set("last_name",last_name);
            u.set("username",username);
            u.set("email",email);
            System.out.println("2");
            if (!u.exists()){
                System.out.println("3");
                u.save();

            }
        }   
            
        }
    
}

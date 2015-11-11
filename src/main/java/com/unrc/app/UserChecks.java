
package com.unrc.app;

import com.unrc.app.Models.User;
import java.util.List;
import org.javalite.activejdbc.Base;

/**
 *
 * @author santiago
 */
public class UserChecks {
    

    public static void newUser(String last_name,String first_name,String email,String username, String contrasenia){
        List<User> list = User.where("username =?",username);
        if (list.isEmpty()){
            User u = new User();
        
            System.out.println("1"+first_name+last_name+email);
            u.set("first_name",first_name);
            u.set("last_name",last_name);
            u.set("username",username);
            u.set("email",email);
            u.set("contrasenia",contrasenia);
            if (!u.exists()){
      
                u.save();

            }
        }   
            
        }
    
}

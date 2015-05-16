package com.unrc.app;

import com.unrc.app.*;
import org.javalite.activejdbc.Base;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
      

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "Control123");

        User u1 = new User();
        u1.set("first_name", "Santi");
        u1.save();
        User u2 = new User();
        u2.set("first_name", "Agustin");
        u2.save();
        System.out.println(UserChecks.exists(u2));
        //u1.add(r);
      
       


        Base.close();
    }
}

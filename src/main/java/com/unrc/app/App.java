package com.unrc.app;

import com.unrc.app.User;
import org.javalite.activejdbc.Base;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_test", "root", "Control123");

        User u = new User();
        u.set("first_name", "Santi");
        u.save();
        Rank r = new Rank();
        u.add(r);
      
       


        Base.close();
    }
}

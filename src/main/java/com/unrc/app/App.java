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
      /*

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "Control123");
       
        User u1 = new User();
        u1.set("first_name", "santipassa","username","santipa332");
        u1.save();
        User u2 = new User();
        u2.set("first_name","agustin");
        u2.save();
        System.out.println(u2.exists());
        Rank r = new Rank();
        r.set("position",1,"games_won",10);
        u1.add(r);
        u1.save();
      
       


        Base.close();
        */
        MenuPrincipal.mostrarMenuPrincipal();
    }
}

package com.unrc.app;

import com.unrc.app.Models.User;
import com.unrc.app.Models.Rank;
import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.*;

import static org.junit.Assert.assertEquals;
import static org.javalite.test.jspec.JSpec.the;
import static org.junit.Assert.assertTrue;


public class RankTest {
    @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_test", "root", "Control123");
        System.out.println("RankTest setup");
        Base.openTransaction();
    }

    @After
    public void after(){
        System.out.println("RankTest tearDown");
       	Base.rollbackTransaction();
        Base.close();
    }


    @Test
    public void shouldValidateRanks(){
      System.out.println("No negative rank :)");
      
      User usuario = new User();
      usuario.set("username","santipassa");
      usuario.set("nombre","santiago");
   
      usuario.save();
     
      Rank rank = new Rank();
      usuario.set(rank);
      
      assertTrue("Ranking no negativo",(rank.getInteger("games_won")>=0));
    }
}

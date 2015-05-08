package com.unrc.app;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.*;

import static org.junit.Assert.assertEquals;
import static org.javalite.test.jspec.JSpec.the;


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
    public void shouldValidateMandatoryFields(){
      Rank rank = new Rank();
      //assertTrue("Ranking no negativo",(rank.getInteger("position")>0));
    }
}

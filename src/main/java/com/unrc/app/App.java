package com.unrc.app;

import com.unrc.app.*;
import java.util.HashMap;
import java.util.Map;
import org.javalite.activejdbc.Base;
import spark.ModelAndView;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
      
        staticFileLocation("/connect4");
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "Control123");
       
       /* User u1 = new User();
        u1.set("first_name", "santipassa","username","santipa332");
        u1.save();
        User u2 = new User();
        u2.set("first_name","agustin");
        u2.save();
        System.out.println(u2.exists());
        Rank r = new Rank();
        r.set("position",1,"games_won",10);
        u1.add(r);
        u1.save();*/
      
       


        
       
       MenuPrincipal.mostrarMenuPrincipal();
       //Base.close();
           /* get("/play", (request, response) -> {
                
                // The hello.ftl file is located in directory:
                // src/test/resources/spark/examples/templateview/freemarker
               return new ModelAndView(null, "play.mustache");
            }, new MustacheTemplateEngine());
            post("/play", (request, response) -> {
                
                System.out.println(request.queryParams("jugador1"));
                
                System.out.println(request.queryMap());
                System.out.println(request.attributes());
               return new ModelAndView(null, "game.mustache");
            }, new MustacheTemplateEngine());
            
            
            get("/", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("message", "Hello FreeMarker World");

                // The hello.ftl file is located in directory:
                // src/test/resources/spark/examples/templateview/freemarker
               return new ModelAndView(attributes, "hello.mustache");
            }, new MustacheTemplateEngine());
            */
            
            
            
        
            
        
    
}
}

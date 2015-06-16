package com.unrc.app;

import com.unrc.app.*;
import java.util.HashMap;
import java.util.Map;
import org.javalite.activejdbc.Base;
import spark.ModelAndView;
import static spark.Spark.*;


public class App
{
    public static void main( String[] args )
    {
        externalStaticFileLocation("./webApp/imagenes");
        MenuPrincipal.mostrarMenuPrincipal();
    }
}

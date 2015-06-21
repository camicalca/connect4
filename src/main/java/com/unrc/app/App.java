package com.unrc.app;


import static spark.Spark.*;


public class App
{
    public static void main( String[] args )
    {
        externalStaticFileLocation("./webApp/imagenes");
        CapaWeb a = new CapaWeb();
    }
}

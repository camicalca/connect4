/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;
import java.util.Scanner;
/**
 *
 * @author santiago
 */
public class MenuPrincipal {
       
    public static void mostrarMenuPrincipal(){
        Integer opcion=-1;
        Scanner entrada;
            System.out.println("================================");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1---->Jugar");
            System.out.println("2---->Ver ranking de usuarios");
            System.out.println("3---->Registrar usuario");
            System.out.println("4---->Eliminar usuario");
            System.out.println("5---->Reanudar partida guardada");
            System.out.println("6---->Para salir");
            System.out.println("================================");
        while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5  ){
           entrada = new Scanner(System.in);
           opcion = entrada.nextInt();
           
        }
        switch (opcion) {
			case 1: jugar();
				break;
			case 2: verRanking();
				break;
			case 3: registrarUsuario();
				break;
                        case 4: eliminarUsuario();
				break;
                        case 5: reanudarPartida();
				break;
			case 6: System.out.println("SALIENDO...");
				break;
		}
	}
    private static void jugar(){
        Board tablero = new Board();
        NewGame.jugar(tablero);
    
    }
    private static void reanudarPartida(){}
    private static void verRanking(){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el id del usuario a buscar su rank");
        int usuario=in.nextInt();
        Rank p = Rank.findById(usuario);
        /*
        Find by id
        This is self-explanatory. If you know the ID, it is easy to get the model 
        that represents this record.
        Person p = Person.findById(1);
        */
        
    }
    private static void registrarUsuario(){}
    private static void eliminarUsuario(){}
        
        
        
    }
       
    

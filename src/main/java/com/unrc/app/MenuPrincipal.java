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
            System.out.println("5---->Para salir");
            System.out.println("================================");
        while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5  ){
           entrada = new Scanner(System.in);
           opcion = entrada.nextInt();
           
        }
        switch (opcion) {
			case 1: Jugar();
				break;
			case 2: verRanking();
				break;
			case 3: registrarUsuario();
				break;
                        case 4: eliminarUsuario();
				break;
			case 5: System.out.println("SALIENDO");
				break;
		}
	}
    private static void Jugar(){}
    private static void verRanking(){}
    private static void registrarUsuario(){}
    private static void eliminarUsuario(){}
        
        
        
    }
       
    

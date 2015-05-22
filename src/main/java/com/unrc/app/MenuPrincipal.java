/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;
import java.util.List;
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
        while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6  ){
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
        String player1 = null;
        String player2 = null;
        for (int i=1;i<3;i++){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el apelido del usuario "+i);
        String last_name = reader.next();
        System.out.println("Ingrese el nombre del usuario "+i);
        String first_name = reader.next();
        System.out.println("Ingrese el e mail del usuario "+i);
        String email = reader.next();
        System.out.println("Ingrese el username del usuario "+i);
        String username = reader.next();
        UserChecks.newUser(last_name,first_name,email,username);
        if (i==1){
            player1=username;
        }else{
            player2=username;
            }
        }
        //User newUser = UserChecks.newUser(last_name,first_name, username, password, email);
        
        Board tablero = new Board();
        NewGame.jugar(tablero,player1,player2);
    
    }
    private static void reanudarPartida(){}
    private static void verRanking(){
        
        
    }
    private static void registrarUsuario(){}
    private static void eliminarUsuario(){}
        
        
        
    }
       
    

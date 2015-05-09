
package com.unrc.app;

/**
 *
 * @author santiago
 */
public class Tablero {
    private final int [][]matriz;
    
    public Tablero(int filas,int columnas){
        matriz=new int[filas][columnas];
    }
    //constructor por defecto
    public Tablero(){
        matriz=new int[7][7];
    }

    public int[][] getMatriz() {
        return matriz;
    }  
    public void setCasilla(int fila,int columna,int valor){
        matriz[fila][columna]=valor;
    }
    
}


package com.unrc.app;

/**
 *
 * @author santiago
 */
public class Tablero {
    private  int [][]matriz;
    //tablero personalizado
    public Tablero(int filas,int columnas){
        matriz=new int[filas][columnas];
        for(int i=0;i<filas;i++){
             for(int j=0;j<columnas;j++){
                 matriz[i][j]=0;
            }
        }
    }
    //constructor por defecto
    public Tablero(){
        matriz=new int[7][6];
        for(int i=0;i<7;i++){
             for(int j=0;j<6;j++){
                 matriz[i][j]=0;
            }
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }  
    public void setCasilla(int fila,int columna,int valor){
        matriz[fila][columna]=valor;
    }
    public int getCasilla(int fila,int columna){
        return matriz[fila][columna];
    }
    
}

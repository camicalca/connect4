/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;

/**
 *
 * @author santiago
 */
public class ComprobarTablero {
    /*  METODOS PARA COMPROBAR SI UN PUNTO DE LA MATRIZ FORMA CUATRO EN LINEA EN TODOS LOS SENTIDOS
    TESTS:
        recorridoHorizontalIzquierdo: OK
        recorridoHorizontalDerecho: OK
        recorridoVerticalSuperior: OK
        recorridoVerticalInferior: OK
    FALTA:
        recorridoDiagonalSuperiorDerecho
        recorridoDiagonalInferiorDerecho
        recorridoDiagonalSuperiorIzquierdo
        recorridoDiagonalInferiorIzquierdo
   */ 

/**recorridoHorizontalIzquierdo
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si a la izquierda del puto existen otros tres puntos iguales
 */    
private static Boolean recorridoHorizontalIzquierdo(int [][] matriz, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
        if ((columna-3)>=0){
         for (int i = 1; i<=3; i++){   
               coincidencia = (matriz[fila][columna]==matriz[fila][columna-i]) && coincidencia ;
            }
         return coincidencia;
        }
        else{
            return false;
        }
}
/**recorridoHorizontalDerecho
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si a la derecha del puto existen otros tres puntos iguales
 */    
private static Boolean recorridoHorizontalDerecho(int [][] matriz, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
         int filas;
        int columnas;
        filas = matriz.length;
        columnas = matriz[0].length;
        if ((columna+3)<columnas){
         for (int i = 1; i<=3; i++){   
               coincidencia = (matriz[fila][columna]==matriz[fila][columna+i]) && coincidencia ;
            }
         return coincidencia;
        }
        else{
            return false;
        }
}
/**recorridoVerticalSuperior
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si arriba del puto existen otros tres puntos iguales
 */    
private static Boolean recorridoVerticalSuperior(int [][] matriz, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
        if ((fila-3)>=0){
         for (int i = 1; i<=3; i++){   
               coincidencia = (matriz[fila][columna]==matriz[fila-i][columna]) && coincidencia ;
            }
         return coincidencia;
        }
        else{
            return false;
        }
}
/**recorridoVerticalSuperior
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si abajo del puto existen otros tres puntos iguales
 */  
private static Boolean recorridoVerticalInferior(int [][] matriz, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
          int filas;
        int columnas;
        filas = matriz.length;
        columnas = matriz[0].length;
        if ((fila+3)>=filas){
            return false;
        }
        else{
            for (int i = 1; i<=3; i++){
                coincidencia = (matriz[fila][columna]==matriz[fila+i][columna]) && coincidencia ;
            }
            return coincidencia;
        }
}

 //NO FUNCIONA
private static Boolean recorridoDiagonalIzquierdo(int [][] matriz, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
        int filas;
        int columnas;
        filas = matriz.length;
        columnas = matriz[0].length;
        if ((fila+3)>=filas){
            return false;
        }
        else{
            for (int i = 1; i<=3; i++){
                coincidencia = (matriz[fila][columna]==matriz[fila-i][columna-i]) && coincidencia ;
            }
            return coincidencia;
        }
}  
//NO FUNCIONA
private static Boolean recorridoDiagonalDerecho(int [][] matriz, int fila, int columna){
    Boolean coincidencia;
    coincidencia = true;
    int filas;
    int columnas;
    filas = matriz.length;
    columnas = matriz[0].length;
    if ((columna+3)<columna){
    for (int i=1;i<=3;i++){
        coincidencia = coincidencia && (matriz[fila][columna]==matriz[fila+i][columna+i]);
    }
    }
    else{
        coincidencia= false;
    } 
    return coincidencia;
}

    
    
    
    public static Boolean ComprobarMatriz(int [][] matriz){
        //Guardo el tamaño de la matriz
        Boolean coincidencia;
        int filas;
        int columnas;
        filas = matriz.length;
        columnas = matriz[0].length;
        coincidencia = false;
        //recorro la matriz
        for( int i =0; i<filas && !coincidencia;i++){
            for(int j=0; j<columnas && !coincidencia ;j++){
                //me fijo si en la matriz hay una ficha
                if (matriz[i][j]!=0){
                    coincidencia=( recorridoVerticalInferior(matriz,i,j) || recorridoVerticalSuperior(matriz,i,j) || recorridoHorizontalDerecho(matriz,i,j) || recorridoHorizontalIzquierdo(matriz,i,j));
                    
                }
            }
        }
        return coincidencia;
    }
 
 /** método main para testeo
  * @param args 
  */
/*
    public static void main(String[] args){
        Object[][] matriz;
        matriz = new Object[7][7];
        matriz[4][3]="AZUL";//punto referencia
        matriz[2][3]="AZUL";
        matriz[1][3]="AZUL";
        matriz[0][3]="AZUL";
       
    }
  */  
}




package com.unrc.app;

/**
 *
 * @author santiago
 */
public class ComprobarTablero {
  /*
    Esta clase provee métodos para realizar todas las comprobaciones respecto al tablero de juego
    */

    
    /**isEmpty
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true la posicion es 0
 */      
    
    
    
public static Boolean isEmpty(int[][] matriz,int fila,int columna){
    return matriz[fila][columna]==0;
}

public static Boolean mover(int[][] matriz,int columna,int jugador){
    Boolean control=false;
    for(int i=matriz.length-1;i>=0 && !control;i--){
        if(matriz[i][columna]==0){
               matriz[i][columna]=jugador;
               control=true;
        }
    
    }
    return control;
 }
    
    
    
    
    
    
    
    
    
    /**recorridoHorizontalIzquierdo
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si a la izquierda del punto existen otros tres puntos iguales
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
 * @return devuelve true si a la derecha del punto existen otros tres puntos iguales
 */    
private static Boolean recorridoHorizontalDerecho(int [][] matriz, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
        int columnas= matriz[0].length;
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
 * @return devuelve true si arriba del punto existen otros tres puntos iguales
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
 * @return devuelve true si abajo del punto existen otros tres puntos iguales
 */  
private static Boolean recorridoVerticalInferior(int [][] matriz, int fila, int columna){
        Boolean coincidencia = true; 
        int filas = matriz.length;
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
  /**recorridoDiagonalSuperiorDerecho
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si en diagonal del punto existen otros tres puntos iguales
 */  
 private static Boolean recorridoDiagonalSuperiorDerecho(int [][] matriz, int fila, int columna){
     Boolean coincidencia = true;
     int columnas = matriz[0].length;
     if((columna+3<columnas) && (fila-3>=0)){
         for(int i = 1;i<=3;i++){
               coincidencia = (matriz[fila][columna]==matriz[fila-i][columna+i]) && coincidencia;
         }
         return coincidencia;
     
     }else{
     
         return false;
     }
       
    }
   /**recorridoDiagonalSuperiorIzquierdo
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si en diagonal del punto existen otros tres puntos iguales
 */  
 private static Boolean recorridoDiagonalSuperiorIzquierdo(int [][] matriz, int fila, int columna){
     Boolean coincidencia = true;
     if((columna-3>=0) && (fila-3>=0)){
         for(int i = 1;i<=3;i++){
               coincidencia = (matriz[fila][columna]==matriz[fila-i][columna-i]) && coincidencia;
         }
         return coincidencia;
     
     }else{
     
         return false;
     }
       
    }
    /**recorridoDiagonalInferiorIzquierdo
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si en diagonal del punto existen otros tres puntos iguales
 */  
 private static Boolean recorridoDiagonalInferiorIzquierdo(int [][] matriz, int fila, int columna){
     Boolean coincidencia = true;
     int filas = matriz.length;
     if((columna-3>=0) && (fila+3<filas)){
         for(int i = 1;i<=3;i++){
               coincidencia = (matriz[fila][columna]==matriz[fila+i][columna-i]) && coincidencia;
         }
         return coincidencia;
     
     }else{
     
         return false;
     }
       
    }
     /**recorridoDiagonalInferiorDerecho
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si en diagonal del punto existen otros tres puntos iguales
 */  
 private static Boolean recorridoDiagonalInferiorDerecho(int [][] matriz, int fila, int columna){
     Boolean coincidencia = true;
     int filas = matriz.length;
     int columnas = matriz[0].length;
     if((columna+3<columnas) && (fila+3<filas)){
         for(int i = 1;i<=3;i++){
               coincidencia = (matriz[fila][columna]==matriz[fila+i][columna+i]) && coincidencia;
         }
         return coincidencia;
     
     }else{
     
         return false;
     }
       
    }


    
    public static Boolean ComprobarMatriz(int [][] matriz){
        //Guardo el tamaño de la matriz
        Boolean coincidencia;
        int filas= matriz.length;
        int columnas = matriz[0].length;
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
  //   public static void toString(int[][] matriz){
  //     for (int x=0; x < matriz.length; x++) {
  //       System.out.print("F["+x+"]"+" |");
  //     for (int y=0; y < matriz[x].length; y++) {
  //       System.out.print (matriz[x][y]);
  //     if (y!=matriz[x].length-1) System.out.print("\t");
  //     }
  //   System.out.println("|");
  //   }
  // }
 
 /** método main para testeo
  * @param args 
  */
    // public static void main(String[] args){
    //     int[][] matriz;
    //     matriz = new int[7][7];
    //    // matriz[0][0]=1;
    //     matriz[1][0]=1;
    //     matriz[2][0]=1;
    //     matriz[3][0]=1;
    //     matriz[4][0]=1;
    //     matriz[5][0]=1;
    //     matriz[6][0]=1;
    //     System.out.println(mover(matriz,0,1));

            
    // }
  
}



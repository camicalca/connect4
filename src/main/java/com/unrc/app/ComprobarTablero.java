
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
    
    
    
public static Boolean isEmpty(Tablero tablero,int fila,int columna){
    return tablero.getCasilla(fila, columna)==0;
}

public static Boolean mover(Tablero tablero,int columna,int jugador){
    Boolean control=false;
    for(int i=tablero.getMatriz().length-1;i>=0 && !control;i--){
        if(tablero.getCasilla(i, columna)==0){
               tablero.setCasilla(i, columna, jugador);
               control=true;
        }
    
    }
    return control;
 }
    
    
    
    
    
    
    
    
    
    /**recorridoHorizontalIzquierdo
 * 
 * @param tablero tablero sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si a la izquierda del punto existen otros tres puntos iguales
 */    
private static Boolean recorridoHorizontalIzquierdo(Tablero tablero, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
        if ((columna-3)>=0){
         for (int i = 1; i<=3; i++){   
               coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila,columna-i)) && coincidencia ;
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
private static Boolean recorridoHorizontalDerecho(Tablero tablero, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
        int columnas=tablero.getMatriz()[0].length;
        if ((columna+3)<columnas){
         for (int i = 1; i<=3; i++){   
               coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila, columna+i)) && coincidencia ;
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
private static Boolean recorridoVerticalSuperior(Tablero tablero, int fila, int columna){
        Boolean coincidencia;
        coincidencia = true;
        if ((fila-3)>=0){
         for (int i = 1; i<=3; i++){   
               coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila-i, columna)) && coincidencia ;
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
private static Boolean recorridoVerticalInferior(Tablero tablero, int fila, int columna){
        Boolean coincidencia = true; 
        int filas = tablero.getMatriz().length;
        if ((fila+3)>=filas){
            return false;
        }
        else{
            for (int i = 1; i<=3; i++){
                coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila+i, columna)) && coincidencia ;
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
 private static Boolean recorridoDiagonalSuperiorDerecho(Tablero tablero, int fila, int columna){
     Boolean coincidencia = true;
     int columnas = tablero.getMatriz()[0].length;
     if((columna+3<columnas) && (fila-3>=0)){
         for(int i = 1;i<=3;i++){
               coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila-i, columna+i)) && coincidencia;
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
 private static Boolean recorridoDiagonalSuperiorIzquierdo(Tablero tablero, int fila, int columna){
     Boolean coincidencia = true;
     if((columna-3>=0) && (fila-3>=0)){
         for(int i = 1;i<=3;i++){
               coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila-i, columna-i)) && coincidencia;
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
 private static Boolean recorridoDiagonalInferiorIzquierdo(Tablero tablero, int fila, int columna){
     Boolean coincidencia = true;
     int filas = tablero.getMatriz().length;
     if((columna-3>=0) && (fila+3<filas)){
         for(int i = 1;i<=3;i++){
               coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila+i, columna-i)) && coincidencia;
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
 private static Boolean recorridoDiagonalInferiorDerecho(Tablero tablero, int fila, int columna){
     Boolean coincidencia = true;
     int filas = tablero.getMatriz().length;
     int columnas = tablero.getMatriz()[0].length;
     if((columna+3<columnas) && (fila+3<filas)){
         for(int i = 1;i<=3;i++){
               coincidencia = (tablero.getCasilla(fila, columna)==tablero.getCasilla(fila+i, columna+i)) && coincidencia;
         }
         return coincidencia;
     
     }else{
     
         return false;
     }
       
    }


    
    public static Boolean ComprobarMatriz(Tablero tablero){
        //Guardo el tamaño de la matriz
        Boolean coincidencia;
        int filas= tablero.getMatriz().length;
        int columnas = tablero.getMatriz()[0].length;
        coincidencia = false;
        //recorro la matriz
        for( int i =0; i<filas && !coincidencia;i++){
            for(int j=0; j<columnas && !coincidencia ;j++){
                //me fijo si en la matriz hay una ficha
                if (tablero.getCasilla(i,j)!=0){
                    coincidencia=( 
                            recorridoVerticalInferior(tablero,i,j) || 
                            recorridoVerticalSuperior(tablero,i,j) || 
                            recorridoHorizontalDerecho(tablero,i,j) ||
                            recorridoHorizontalIzquierdo(tablero,i,j) ||
                            recorridoDiagonalInferiorDerecho(tablero,i,j)||
                            recorridoDiagonalInferiorIzquierdo(tablero,i,j) ||
                            recorridoDiagonalSuperiorIzquierdo(tablero,i,j) ||
                            recorridoDiagonalSuperiorDerecho(tablero,i,j)
                    );
                    
                }
            }
        }
        return coincidencia;
    }  
}



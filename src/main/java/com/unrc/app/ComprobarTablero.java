
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
    recorridoDiagonalSuperiorDerecho:OK
    recorridoDiagonalInferiorDerecho:OK
    recorridoDiagonalSuperiorIzquierdo:OK
    recorridoDiagonalInferiorIzquierdo:OK
   */ 

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
 //    public static void toString(int[][] matriz){
 //      for (int x=0; x < matriz.length; x++) {
 //        System.out.print("F["+x+"]"+" |");
 //      for (int y=0; y < matriz[x].length; y++) {
 //        System.out.print (matriz[x][y]);
 //      if (y!=matriz[x].length-1) System.out.print("\t");
 //      }
 //    System.out.println("|");
 //    }
 //  }
 
 // /** método main para testeo
 //  * @param args 
 //  */
 //    public static void main(String[] args){
 //        int[][] matriz;
 //        matriz = new int[7][7];
 //        matriz[0][0]=1;//punto referencia
 //        matriz[1][1]=1;
 //        matriz[2][2]=1;
 //        matriz[3][3]=1;
 //        matriz[4][4]=1;
 //        matriz[5][5]=1;
 //        toString(matriz);
 //        for(int i = 0; i<matriz.length;i++){
 //          for(int j = 0; j<matriz[0].length;j++){
 //            if(recorridoDiagonalInferiorDerecho(matriz,i,j) && matriz[i][j]!=0){
 //              System.out.println("fila: "+i+" columna: "+j);

 //            }
 //         }
 //       }    
 //    }
  
}



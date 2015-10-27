
package com.unrc.app;

import com.unrc.app.Models.Board;
import java.util.List;

/**
 *
 * @author santiago
 */
public class BoardTools {
  /*
    Esta clase provee métodos para realizar todas las comprobaciones respecto al tablero de juego
    */

    
    /**isEmpty
 * 
 * @param board matriz sobre la cual se quiere razonar
 * @param row posicion y del punto referencia
 * @param column posicion x del punto referencia
 * @return devuelve true la posicion es 0
 */      
    
    
    
public static Boolean isEmpty(Board board,int row,int column){
    return board.getCell(row, column)==0;
}

public static Boolean move(Board board,int column,int player){
    board.setTurno(board.getTurno()+1);
    Boolean control=false;
    for(int i=board.getMatrix().length-1;i>=0 && !control;i--){
        if(board.getCell(i, column)==0){
               board.setCell(i, column, player);
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
private static Boolean leftHorizontalPath(Board board, int row, int column){
        Boolean coincidence;
        coincidence = true;
        if ((column-3)>=0){
         for (int i = 1; i<=3; i++){   
               coincidence = (board.getCell(row, column)==board.getCell(row,column-i)) && coincidence ;
            }
         return coincidence;
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
private static Boolean rightHorizontalPath(Board board, int row, int column){
        Boolean coincidence;
        coincidence = true;
        int columns=board.getMatrix()[0].length;
        if ((column+3)<columns){
         for (int i = 1; i<=3; i++){   
               coincidence = (board.getCell(row, column)==board.getCell(row, column+i)) && coincidence ;
            }
         return coincidence;
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
private static Boolean upperVerticalPath(Board board, int row, int column){
        Boolean coincidence;
        coincidence = true;
        if ((row-3)>=0){
         for (int i = 1; i<=3; i++){   
               coincidence = (board.getCell(row, column)==board.getCell(row-i, column)) && coincidence ;
            }
         return coincidence;
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
private static Boolean lowerVerticalPath(Board board, int row, int column){
        Boolean coincidence = true; 
        int rows = board.getMatrix().length;
        if ((row+3)>=rows){
            return false;
        }
        else{
            for (int i = 1; i<=3; i++){
                coincidence = (board.getCell(row, column)==board.getCell(row+i, column)) && coincidence ;
            }
            return coincidence;
        }
}
  /**recorridoDiagonalSuperiorDerecho
 * 
 * @param matriz matriz sobre la cual se quiere razonar
 * @param fila posicion y del punto referencia
 * @param columna posicion x del punto referencia
 * @return devuelve true si en diagonal del punto existen otros tres puntos iguales
 */  
 private static Boolean upperRightDiagonalPath(Board board, int row, int column){
     Boolean coincidence = true;
     int columns = board.getMatrix()[0].length;
     if((column+3<columns) && (row-3>=0)){
         for(int i = 1;i<=3;i++){
               coincidence = (board.getCell(row, column)==board.getCell(row-i, column+i)) && coincidence;
         }
         return coincidence;
     
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
 private static Boolean upperLeftDiagonalPath(Board board, int row, int column){
     Boolean coincidence = true;
     if((column-3>=0) && (row-3>=0)){
         for(int i = 1;i<=3;i++){
               coincidence = (board.getCell(row, column)==board.getCell(row-i, column-i)) && coincidence;
         }
         return coincidence;
     
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
 private static Boolean lowerLeftDiagonalPath(Board board, int row, int column){
     Boolean coincidence = true;
     int rows = board.getMatrix().length;
     if((column-3>=0) && (row+3<rows)){
         for(int i = 1;i<=3;i++){
               coincidence = (board.getCell(row, column)==board.getCell(row+i, column-i)) && coincidence;
         }
         return coincidence;
     
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
 private static Boolean lowerRightDiagonalPath(Board board, int row, int column){
     Boolean coincidence = true;
     int rows = board.getMatrix().length;
     int columns = board.getMatrix()[0].length;
     if((column+3<columns) && (row+3<rows)){
         for(int i = 1;i<=3;i++){
               coincidence = (board.getCell(row, column)==board.getCell(row+i, column+i)) && coincidence;
         }
         return coincidence;
     
     }else{
     
         return false;
     }
       
    }


    
    public static Boolean checkBoard(Board board){
        //Guardo el tamaño de la matriz
        Boolean coincidence;
        int rows= board.getMatrix().length;
        int columns = board.getMatrix()[0].length;
        coincidence = false;
        //recorro la matriz
        for( int i =0; i<rows && !coincidence;i++){
            for(int j=0; j<columns && !coincidence ;j++){
                //me fijo si en la matriz hay una ficha
                if (board.getCell(i,j)!=0){
                    coincidence=( 
                            lowerVerticalPath(board,i,j) || 
                            upperVerticalPath(board,i,j) ||
                            rightHorizontalPath(board,i,j) ||
                            leftHorizontalPath(board,i,j) ||
                           
                            lowerRightDiagonalPath(board,i,j)||
                            lowerLeftDiagonalPath(board,i,j) ||
                            upperLeftDiagonalPath(board,i,j) ||
                            upperRightDiagonalPath(board,i,j)
                    );
                    
                }
            }
        }
        return coincidence;
    }  
}



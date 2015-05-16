
package com.unrc.app;

/**
 *
 * @author santiago
 */
public class Board {
    private  int [][]matrix;
    //tablero personalizado
    public Board(int rows,int columns){
        matrix=new int[rows][columns];
        for(int i=0;i<rows;i++){
             for(int j=0;j<columns;j++){
                 matrix[i][j]=0;
            }
        }
    }
    //constructor por defecto
    public Board(){
        matrix=new int[7][6];
        for(int i=0;i<7;i++){
             for(int j=0;j<6;j++){
                 matrix[i][j]=0;
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }  
    public void setCell(int row,int column,int value){
        matrix[row][column]=value;
    }
    public int getCell(int row,int column){
        return matrix[row][column];
    }
    
}
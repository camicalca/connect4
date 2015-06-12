
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
    public int getRows(){
        return matrix.length;
    }
    public int getColumns(){
        return matrix[0].length;
    }
    
    public int getNumberOfCells(){
        return (matrix[0].length)*(matrix.length);
       
    
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
    private String returnImage(int number){
        if (number==0){
            return "<img scr";
        }else if(number==1){
            return "imagen jugador 1";
        
        }else if (number==2){
            return "imagen jugador 2";
            
        }else{
            return null;
        }
    
    
    }
    
    
    public String toStringB(){
     String tabla;
            tabla="<table><tr>\n" +		
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n"+
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "</tr>\n"+
                
                "<tr>\n" +		
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n"+
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "</tr>\n"+
                "<tr>\n" +		
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n"+
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "</tr>\n"+
                
                "<tr>\n" +		
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n"+
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "</tr>\n"+
                "<tr>\n" +		
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n"+
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "</tr>\n</table>"
                    
                    
                    
                    
                    
                    ;
                    
                   
            return tabla;
    }
    
}


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
            return "<img src='http://k30.kn3.net/E/3/4/5/3/C/4B3.png'>";
        }else if(number==1){
            return "<img src='http://k33.kn3.net/6/4/0/8/A/1/EBB.png'>";
        
        }else if (number==2){
            return "<img src='http://k33.kn3.net/B/C/D/2/E/D/7C9.png'>";
            
        }else{
            return null;
        }
    
    
    }
    
    
    public String toStringB(){
     String tabla;
            tabla="<table><tr>\n" +		
                "<td>"+returnImage(getCell(0,0))+"</td>\n" +
                "<td>"+returnImage(getCell(0,1))+"</td>\n" +
                "<td>"+returnImage(getCell(0,2))+"</td>\n" +
                "<td>"+returnImage(getCell(0,3))+"</td>\n" +
                "<td>"+returnImage(getCell(0,4))+"</td>\n" +
                "<td>"+returnImage(getCell(0,5))+"</td>\n" +
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

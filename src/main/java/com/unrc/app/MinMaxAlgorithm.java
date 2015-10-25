
package com.unrc.app;

import com.unrc.app.Models.Board;

/**
 *
 * @author santiago
 */
/*this class implements the minmax algorithm
    still doesnt work :'(   */
public class MinMaxAlgorithm {
    
    
    
    public int minMax(Board t){
        int mejor_mov = -1;
        int max, max_actual;
        max = Integer.MIN_VALUE; //el valor -inf va a ser max por el momento
        for(int i=0;i<t.getColumns();i++){
            if(BoardTools.move(t, i,2)){
                int tmp = i; //guardo pos donde se tiro la ficha
                //max_actual
            }
        }
                  return 0;
    }
    
    private int heuristic(Board t){
        return 0;
        
    }
}




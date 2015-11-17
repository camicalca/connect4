/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;

/**
 *
 * @author agustin
 */
public class online {
    private String [] enlinea;
    private int cant ;
    private String [][] jugando;
    private int canpareja;
    
    public boolean enjuego(String id1){
        if ((id1==jugando[canpareja][0]) || (id1==jugando[canpareja][1])){
                return true;
         }else{
            return false;
        }
    }
    
    public int idgame(String id1){
        int i=0;
        boolean exi=false;
        while(i<canpareja|| exi){
            if((id1!=jugando[i][0])||id1!=jugando[i][1]){
                i++;
            }else{
                exi=true;
                
            }
        }
        if (exi){
            return i;
        }else{
            return 0;
        }
    }
    
    public void jugando(String id1, String id2){
        jugando[canpareja][0]=id1;
        jugando[canpareja][1]=id2;
        canpareja++;
    }
    public void deletjugando(String id1,String id2){
        boolean exi=true;
        int i=0;
       
        while(exi){
            if (jugando[i][0]==id1){
                if(jugando[i][1]==id2){
                    exi=false;
                }else{
                 exi=true;
                 i++;
                
            }
        }
        if (exi==false){
            while(i<canpareja-1){
                jugando[i][0]=jugando[i][1];
                i++;
            }
        }
        canpareja--;
    }
    }
    
    public online(){
        enlinea = new String [100];
        jugando = new String [51][2];
        for(int i=0; i<100;i++){
            enlinea[i]="";
        }
        for(int i=0; i<51;i++){
            for(int j=0; j<2;j++){
            jugando[i][j]="";
            }
        }
        cant=0;
        canpareja=0;
    }
    public online(String id){
        enlinea = new String [100];
        for(int i=0; i<100;i++){
            enlinea[i]="";
        }
        cant=0;
    }
    
    /**
     *
     * @param id
     */
    public void agregar(String id){
        enlinea[cant]=id;
        cant++;
        
    } 
    
    public boolean existe(String id){
        boolean exi=false;
        int i=0;
        while(cant>i){
            if (enlinea[i]==id){
                exi=true;
                i=cant;
            }else{
                exi=false;
                i++;
            }
        }
        return exi;
    }
    
    public void delete(String id){
        boolean exi=true;
        int i=0;
        while(exi){
            if (enlinea[i]==id){
                exi=false;
            }else{
                exi=true;
                i++;
            }
        }
        if (exi==false){
            while(i<cant-1){
                enlinea[i]=enlinea[i+1];
                i++;
            }
        }
        
        
    }  
        
    public String [] list(){
        return enlinea;
    }
    
    public String toSting(int id){
        return enlinea[id];
    }
}

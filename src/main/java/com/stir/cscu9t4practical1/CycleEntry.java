/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

/**
 * "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n"
 * @author games
 */
public class CycleEntry extends Entry{
    private String terrain;
    private String tempo;
    
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String tern, String temp){
        super(n, d, m, y, h, min, s, dist);
        terrain = tern;
        tempo = temp;
    }
    
    public String getTerrain(){
    return terrain;
}
    
    public String getTempo(){
        return tempo;
    }
    
   @Override
   public String getEntry () {
   String result = getName()+" cycled " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+" on " +getTerrain()+ " at "+getTempo()+ " tempo\n";
   return result;
  } //getEntry
    
}

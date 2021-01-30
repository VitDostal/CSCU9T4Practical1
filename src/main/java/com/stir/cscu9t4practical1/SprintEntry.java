/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

/**
 * "Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n"
 * @author games
 */
public class SprintEntry extends Entry{
    private int repetition;
    private int recoveryMinutes;
    
    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int recMin){
        super(n, d, m, y, h, min, s, dist);
        repetition = rep;
        recoveryMinutes = recMin;
    }
    
    public int getRepetitions(){
        return repetition;
    }
    
    public int getRecovery(){
        return recoveryMinutes;
    }
    
    @Override
   public String getEntry () {
   String result = getName()+" sprinted " +getRepetitions()+"x"+ getDistance() + "m in "
             +getHour()+":"+getMin()+":"+ getSec() + " with " +getRecovery()+ " minutes recovery on "
             +getDay()+"/"+getMonth()+"/"+getYear()+ "\n";
   return result;
  } //getEntry
    
}

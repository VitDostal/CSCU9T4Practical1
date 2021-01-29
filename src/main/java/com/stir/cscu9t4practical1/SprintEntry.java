/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

/**
 *
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
    
    public int getRepetition(){
        return repetition;
    }
    
    public int getRecovery(){
        return recoveryMinutes;
    }
    
}

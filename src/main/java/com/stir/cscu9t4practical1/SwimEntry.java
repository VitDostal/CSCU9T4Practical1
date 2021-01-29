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
public class SwimEntry extends Entry{
    private String location;    
    
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String loc){
        super(n, d, m, y, h, min, s, dist);
        location = loc;        
    }
    
    public String getWhere(){
        return location;
    }
    
}

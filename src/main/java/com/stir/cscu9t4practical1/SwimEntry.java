/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

/**
 *"Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n";
 * @author games
 */
public class SwimEntry extends Entry{
    private String location;    
    
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String loc){
        super(n, d, m, y, h, min, s, dist);
        location = loc;        
    }
    
    public String getWhere(){
        if (location.equals("outdoors")){
            return "outdoors";
        }else{
            return "in a pool";
        }
        
    }
    
    @Override
   public String getEntry () {
   String result = getName()+" swam "+ getDistance() + " km "+getWhere()+ " in "
             +getHour()+":"+getMin()+":"+ getSec()+ " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+ "\n";
   return result;
  } //getEntry
}

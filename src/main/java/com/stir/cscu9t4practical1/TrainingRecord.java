// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   public void removeEntryIndex(int index){
       tr.remove(index);
   }
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
   public String findAllEntrys(int d, int m, int y){ // TESTSTSTSTSTSTS
       ListIterator<Entry> iter = tr.listIterator();
       ArrayList<String> results = new ArrayList<String>(); 
       String result = "";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             results.add(current.getEntry());
            }
       for (var i : results) {
      result += i;
    }
       if(results.isEmpty()){
           result = "Sorry couldn't find anything for this date";
       }
       return result;
   }   
   
   public String checkupEntry (String name,int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "Same entry not found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(name)) 
             result = "Same entry found";
            }
       return result;
   } 
   public String removeEntry (String name,int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       int index = -1;
       String result = "Entry not found";
       while (iter.hasNext()) {
          index ++;
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(name)){
             removeEntryIndex(index);
             System.out.println("Entry removed");
             result = "Entry removed";
          }             
             
            }
       return result;
   } 
   
   
   
} // TrainingRecord
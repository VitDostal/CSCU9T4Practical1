// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton removeR = new JButton("Remove");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton ("Find All By Date");

    private String entrys[] = {"Cycle", "Sprint", "Swim"}; 
    private JComboBox entryBox = new JComboBox(entrys);
    private JTextField addInfo1 = new JTextField(15);
    private JTextField addInfo2 = new JTextField(15);
    private JLabel labAddInfo1 = new JLabel(" Additional information:");    
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(entryBox);        
        entryBox.addActionListener(this);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(removeR);
        removeR.setEnabled(false);
        removeR.addActionListener(this);        
        add(lookUpByDate);
        lookUpByDate.setEnabled(false);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.setEnabled(false);
        findAllByDate.addActionListener(this);        
        add(labAddInfo1);
        add(addInfo1);
        addInfo1.setEditable(true);
        add(addInfo2);
        addInfo2.setEditable(true);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
            findAllByDate.setEnabled(true);
            lookUpByDate.setEnabled(true);
            removeR.setEnabled(true);
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate){
            message = findAllByDate();
        }
        if (event.getSource() == entryBox){
            String selected = (String)entryBox.getSelectedItem();
            if(selected.equals("Cycle")){
                addInfo1.setText("Enter terrain here");
                addInfo2.setText("Enter tempo here");
            }
            else if(selected.equals("Sprint")){
                addInfo1.setText("Enter repetition here");
                addInfo2.setText("Enter recovery here");
            }
            else{
                addInfo1.setText("Enter location here");
                addInfo2.setText("Enter nothing here");
            }
        }
        if(event.getSource() == removeR){
            message = removeEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String selected = (String)entryBox.getSelectedItem();
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        if(name.getText().trim().equals("")){
            return "Please add name.";
        }
        String n = name.getText();
        if (!isInteger(month.getText())){
        return "Please use only integeres to enter month.";
    }       
        int m = Integer.parseInt(month.getText());
        if (!isInteger(day.getText())){
        return "Please use only integeres to enter day.";
    } 
        int d = Integer.parseInt(day.getText());
        if (!isInteger(year.getText())){
        return "Please use only integeres to enter year.";
    } 
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        if (!isInteger(hours.getText())){
        return "Please use only integeres to enter hours.";
    } 
        int h = Integer.parseInt(hours.getText());
        if (!isInteger(mins.getText())){
        return "Please use only integeres to enter mins.";
    } 
        int mm = Integer.parseInt(mins.getText());
        if (!isInteger(secs.getText())){
        return "Please use only integeres to enter secs.";
    } 
        int s = Integer.parseInt(secs.getText());
        // String sameCheck = lookUpEntry(d,m,y);
        
        
        if(selected.equals("Cycle")){
            String t = addInfo1.getText();
            String te = addInfo2.getText();   
            CycleEntry e = new CycleEntry(n, d, m, y, h, mm, s, km, t, te);
            String sameCheck = myAthletes.checkupEntry(n, d, m, y);
            if(sameCheck.equals("Same entry found"))
                return "Entry already exists";
            myAthletes.addEntry(e);
            }
            else if(selected.equals("Sprint")){
            int r = Integer.parseInt(addInfo1.getText());
            int re = Integer.parseInt(addInfo2.getText());  
            SprintEntry e = new SprintEntry(n, d, m, y, h, mm, s, km, r, re);
            String sameCheck = myAthletes.checkupEntry(n, d, m, y);
            if((sameCheck.equals("Same entry found")))
                return "Entry already exists";
            myAthletes.addEntry(e);
            }
            else{
            String l = addInfo1.getText();                
            SwimEntry e = new SwimEntry(n, d, m, y, h, mm, s, km, l);
            String sameCheck = myAthletes.checkupEntry(n, d, m, y);
            if(sameCheck.equals("Same entry found"))
                return "Entry already exists";
            myAthletes.addEntry(e);
            }        
        
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }
    
    public String findAllByDate(){
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.findAllEntrys(d, m, y);
        return message;        
    }
    
    public static boolean isInteger(String str) {
    if (str == null) {
        return false;
    }
    int length = str.length();
    if (length == 0) {
        return false;
    }
    int i = 0;
    if (str.charAt(0) == '-') {
        if (length == 1) {
            return false;
        }
        i = 1;
    }
    for (; i < length; i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
}
    public String removeEntry(){        
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());               
        String message = myAthletes.removeEntry(n, d, m, y);
        return message;
    }

    
} // TrainingRecordGUI


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESC
 */
public class Game {
    String gamename;
    String gametype;
    String rate;
    String description;
    String category;
    int game_id;
    Account ac;
    Student student;
    ArrayList<Question>Qarr;
    Game(){
        
    }
    Game(String gametype,String gamename,String description , Account a,ArrayList<Question>arr,String category){        //Create game
        this.gamename = gamename;
        this.gametype = gametype;
        this.description = description;
        ac = a;
        this.Qarr=arr;
        this.category = category;
    }
    Game(String gamename){                  //Try Game
        this.gamename = gamename;
    }
    
    Game(String gamename,Student s){   // play
        this.gamename = gamename;
        this.student = s;
        
    }
    
    void setrate(String type,String rate){
        this.rate = rate;
    }
    String getrate(){
       return this.rate;
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.file.Files.find;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ESC
 */
public class Server {
    Game gameobject;
    Server(Game game){
        this.gameobject = game;
    }
    Server(){
        
    }
    boolean repeatedGame() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("games.txt"));
        
        while(br.ready()){
             if(gameobject.gamename.equals(br.readLine().split(",")[1])){

                return true;
            
            }
        }
        br.close();
        
        return false;
    }
    ArrayList<String> getGameWithCat() throws FileNotFoundException{
        File f= new File("games.txt");
        ArrayList<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(f);
        String temp = "";
        while(sc.hasNextLine()){
            String t = sc.nextLine();
            if(gameobject.category.equals(t.split(",")[4])){
                list.add(t.split(",")[1]);
            }
        }
        return list;
    }
   
    
    
     String getGameDisc() throws FileNotFoundException{
        File f= new File("games.txt");
        String desc="";
        Scanner sc = new Scanner(f);
        String temp = "";
        while(sc.hasNextLine()){
            String t = sc.nextLine();
            if(gameobject.gamename.equals(t.split(",")[1])){
                 return t.split(",")[5];
            }
        }
        return temp;
    }
static boolean emptyfile() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("games.txt"));
        
        if(br.readLine()!=null){  
            return false;
        }
        br.close();
        
        return true;
    }
    
    String getTeacherID() throws FileNotFoundException{
        File f= new File("database.txt");
        Scanner sc = new Scanner(f);
        String temp = "";
        while(sc.hasNextLine()){
            String t = sc.nextLine();
            if(gameobject.ac.name.equals(t.split(",")[2])&&(t.split(",")[1]).equals("T")){
                return t.split(",")[0];
            }
        }
        return temp;
    }

    
         boolean addgame() throws IOException{
       if(repeatedGame()){
           return false;
       } 
       
       
       
       String temp2 = "";
       ArrayList<String> strlist = new ArrayList<String>();
       File f = new File("games.txt");
       Scanner sc = new Scanner(f);
       
       String temp = "";
       while(sc.hasNextLine()){
           temp = sc.nextLine();
           strlist.add(temp);
       }
       boolean emp=false;
       if(emptyfile()){
           emp=true;
           
        }
       String[] str = temp.split(",");
       sc.close();
       
       PrintWriter p = new PrintWriter(f);
       for(int i=0;i<strlist.size();i++){
            p.print(strlist.get(i));
            p.println();
       }
       gameobject.ac.id =  Integer.parseInt(getTeacherID());
       String str2 = str[0];
       if(emp==true){
           str2="1";
           
        }
       else{
           
          // int x = Integer.parseInt(str2)+1;
        //   System.out.println(x + "-----------------");
           str2=Integer.toString(Integer.parseInt(str2)+1);
       }
       
       
       p.println( Integer.parseInt(str2)+","+gameobject.gamename+","+gameobject.gametype+","+gameobject.ac.id+","+gameobject.category+","+gameobject.description);
       p.close();
       
       
       
       //System.out.println("STR2 = "+str2);
       
       String cur="C:\\Users\\ESC1\\Documents\\NetBeansProjects\\GUI\\games\\";
       
       if(System.getProperty("os.name").startsWith("Windows")){
           cur = ".\\games\\";
       }else {
           cur = "./games/";
       }
       
       File f2 = new File(cur+ str2 +".txt");
       PrintWriter po=new PrintWriter(f2);
       for(int i=0;i<gameobject.Qarr.size();i++){
           po.print(gameobject.Qarr.get(i).Qnum+","+gameobject.Qarr.get(i).question+",");
           for(int j=0;j<gameobject.Qarr.get(i).results.size();j++){
               if(j==gameobject.Qarr.get(i).results.size()-1){
                   po.print(gameobject.Qarr.get(i).results.get(j));
               }
               else{
                   po.print(gameobject.Qarr.get(i).results.get(j)+",");
               }
           }
           po.println();
       }
       po.close();
       
       return true;
    }
    
    int getGameID() throws FileNotFoundException{
        File f= new File("games.txt");
        Scanner sc = new Scanner(f);
        String temp = "";
        while(sc.hasNextLine()){
            String t = sc.nextLine();
            if(gameobject.gamename.equals(t.split(",")[1])){
                return Integer.parseInt(t.split(",")[0]);
            }
        }
        return -1;
    }     
         
    void storeScore(String stud_name , int score) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("scores.txt"));
        
        ArrayList<String>arr = new ArrayList<String>();
        
        boolean find = false;
        
        while(br.ready()){  
            String h = br.readLine();
           
            String s [] = h.split(",");
            
            if(s[0].equals(stud_name) && s[1].equals(Integer.toString(getGameID()))){
                s[2] = Integer.toString(score);
                String h2 = s[0]+","+s[1]+","+s[2];
                arr.add(h2);
                find = true;
                continue;
            }
            arr.add(h);
        }
        br.close();
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt"));
        
        
        for(int i=0;i<arr.size();i++){
            bw.append(arr.get(i));
        }
        
        if(find == false){
            bw.append(stud_name+","+getGameID()+","+score);
        }
        
        bw.close();
        
    }
    
    int search() throws FileNotFoundException{
        File f= new File("games.txt");
        Scanner sc=new Scanner(f);
        
        String temp="";
        while(sc.hasNextLine()){
           String[] tmp = sc.nextLine().split(",");
            if(tmp[1].equals(this.gameobject.gamename)){
                int value = Integer.parseInt(tmp[0]);
                return value;
            }
            
        }
        return -1;           
    }
    
    
    
    
}

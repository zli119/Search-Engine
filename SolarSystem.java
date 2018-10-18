/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C006;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class SolarSystem {
		//private ArrayList<String> planets;
               
	static HashMap <String,String> Mercury=new HashMap<>();
		public SolarSystem() throws FileNotFoundException, IOException {
//			planets = new ArrayList<>();
//                         planets.add("earth");
                         
                        //planets.add(0, element);
                        FileReader fr=new FileReader("solarsystem2.dat");
                        BufferedReader bf=new BufferedReader(fr);
                        String ss [][]=new String[15][10];
                        String sss[]=new String[10];
                        for(int i=0;i<15;i++){
                            sss=bf.readLine().trim().split("\\s+");
                        for(int j=0;j<10;j++){                            
                        ss[i][j]=sss[j];                       
               //         System.out.println(ss[i][j]);
                        }   
                        }
//                        for(int i=0;i<15;i++){                          
                        for(int j=0;j<10;j++){ 
                            Mercury.put(ss[0][j],ss[1][j]);
                        }
}
//for(int k=0;k<2;k++){
//for(int j=0;j<6;j++){
//                        Mercury.put(ss[k][j],ss[k+1][j]);
//                        }
//                        Mercury.put(ss[0][0],ss[1][0]);
//                        for (String st:Mercury.keySet()){
//                            System.out.println(st+" : "+Mercury.get(st));
                      
			// open the file
			// read in create Panets
			// add to lista
		

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new SolarSystem();
        System.out.println(Mercury.get("Mass(kg)"));
        // TODO code application logic here
    }
      }
    
}
class Planet{
    private String Orbits;
    private String mass;
    
    
}

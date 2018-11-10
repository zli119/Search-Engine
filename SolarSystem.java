package C006;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class SolarSystem {
    int n=14;
    class Body{
    private String name;
    private String Orbits;
    private String Mass;
    private String Diam;	
    private String Perihelion;	
    private String Aphelion;	
    private String orbPeriod;	
    private String rotationalPeriod;	
    private String axialtilt; 
    private String orbinclin;
    Body(String name,String Orbits,String	Mass,String	Diam,String	Perihelion,String	Aphelion,String	orbPeriod,String	rotationalPeriod,String	axialtilt,String orbinclin){
    this.name=name;
    this.Orbits=Orbits;
    this.Mass=Mass;
    this.Diam=Diam;	
    this.Perihelion=Perihelion;	
    this.Aphelion=Aphelion;	
    this.orbPeriod=orbPeriod;	
    this.rotationalPeriod=rotationalPeriod;	
    this.axialtilt=axialtilt; 
    this.orbinclin=orbinclin;
    }
    }
//   private ArrayList<Double> al=new ArrayList<>(256);    
    public static void main(String[] args) throws FileNotFoundException, IOException{
    String [] name=new String[14];
    String [] Orbits=new String[14];
    String [] Mass=new String[14];
    String [] Diam=new String[14];
    String [] Perihelion=new String[14];
    String [] Aphelion=new String[14];
    String [] orbPeriod=new String[14];
    String [] rotationalPeriod=new String[14];
    String [] axialtilt=new String[14];
    String [] orbinclin=new String[14];
    BufferedReader br=new BufferedReader(new FileReader("solarsystem.dat"));
    String s="";
    int i=0;        
    br.readLine();
        while(i<14&&(s=br.readLine())!=null){
        String []line=s.split("\\s+");
        name[i]=line[0];
        Orbits[i]=line[1];
        Mass[i]=line[2];
        Diam[i]=line[3];
        Perihelion[i]=line[4];
        Aphelion[i]=line[5];
        orbPeriod[i]=line[6];
        rotationalPeriod[i]=line[7];
        axialtilt[i]=line[8];
        orbinclin[i]=line[9];    
        i++;
//        System.out.println(name[i]+"  i="+i);
    }
    br.close();
     SolarSystem bodyList=new SolarSystem();     
     bodyList.addValue(name,Orbits,Mass,Diam,Perihelion,Aphelion,orbPeriod,rotationalPeriod,axialtilt,orbinclin);        
    }
    void addValue(String [] name,String [] Orbits,String [] Mass,String [] Diam,String [] Perihelion,String [] Aphelion,String [] orbPeriod,String [] rotationalPeriod,String [] axialtilt,String [] orbinclin){
        ArrayList<Body> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Body(name[i],Orbits[i],Mass[i],Diam[i],Perihelion[i],Aphelion[i],orbPeriod[i],rotationalPeriod[i],axialtilt[i],orbinclin[i]));
        }
        print(list);
    }
    void print(ArrayList<Body> list){
         for(int i=0;i<n;i++){
             Body data=list.get(i);
         System.out.println(data.name+" "+data.Orbits+" "+data.Mass+" "+data.Diam+" "+data.Perihelion+" "+data.Aphelion+" "+data.orbPeriod+" "+data.rotationalPeriod+" "+data.axialtilt+" "+data.orbinclin);
         }
    }    
}

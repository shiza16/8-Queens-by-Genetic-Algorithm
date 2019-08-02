/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic8Queen;

/**
 *
 * @author Nageena
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Population p=new Population();
      int cost=0;
      boolean result=false;
      
      //performing all functions here
      
      p.Fitnessfunction();
      p.print();
      p.newpopulation();
      p.printnewchromosomes();
      p.Crossover();
      p.newfitnessfunction();
      p.Mutation();
      p.newfitnessfunction();
      p.printnewchromosomes();
   
      
    
      while (!result) 
      {
          p.Crossover();
          p.newfitnessfunction();
          p.Mutation();
          p.newfitnessfunction();
          p.printnewchromosomes();
          System.out.println(cost++);
          
          if(p.newchromo[0][8]<= 1 ||  p.newchromo[1][8]<=1 || p.newchromo[2][8]<=1)
        	  result=true;
      }
    
    }
    
}

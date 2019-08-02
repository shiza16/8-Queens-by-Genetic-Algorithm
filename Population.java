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
public class Population {
   int chromo[][] = new int[4][9];
    int newchromo[][] = new int[3][9];
    public Population() {
        innitialpopulation(chromo);
    }
    void Fitnessfunction() {
         
        int b,a = 0, x , d1, d2 = 0 ,hit= 0;
        boolean next= false;
        boolean diagonal1 = false , diagonal2 = false;
        
        while (a <= 3) {
            hit = 0;
            for (b = 0; b < 7; b++) {
                int queen = b;
                d2  = 0;
                for (int k = queen + 1; k < 8; k++) {
                    x= k - queen;
                    d1 = chromo[a][queen] - chromo[a][k];

                    if (d1 < 0) {
                        d2  = d1 * (-1);
                    }
                    if (d1 == 0 && next== false) {
                        next= true;
                        hit++;
                    }
                    if (x == d1 && diagonal1 == false) {
                        diagonal1 = true;
                        hit++;
                    }
                    if (x == d2  && diagonal2 == false) {
                        diagonal2 = true;
                        hit++;
                    }
                }
                next= false;
                diagonal1 = false;
                diagonal2 = false;
            }
            chromo[a][8] =hit;
            a++;


        }


    }

    void newpopulation() {
        int pop[] = {0, 0, 0, 0}, max = 0, a; 
        for (a = 0; a <=3; a++) {
            pop[a] = chromo[a][8];
        }

        for (a = 0; a <=3; a++) {

            if (pop[a] > max) max = pop[a];
        }
        int count = 0;
        for ( a = 0; a <=3; a++) {

            if (chromo[a][8] != max) {
                newchromo[count] = chromo[a];
                count++;
            }


        }
        if (count < 3) {
        	
            for (a = 0; a <=3; a++) {

                if (chromo[a][8] == max) {
                    newchromo[count] = chromo[a];
                    count++;
                }
                if (count == 3) {
                    break;
                }

            }
        }
    }


    void Mutation() {
      
        int k=0 , i=0 ,x=0 , u=1;
        int arr[] = new int[9];
        System.out.println("after mutation");
    
        while(k<=2 ){
            u= (int) (Math.random()*8+1);
            arr=newchromo[k];
            x=assignchoromosome(newchromo[k][u],k,arr);
            if(x>0){
                newchromo[k][i]=(u+5)%8+1;
                k++;
            }else{
                i++;

            }
            if(i>=7) break;

        }

    }
    int assignchoromosome(int t, int h ,int arr[]) {
         
    	int l,o = 0,f=-1;
    	
    	for (l = 0; l < 8; l++) {
            
            if (newchromo[h][l] == t) {
                o++;
            }
            if (o > 1) {
                return l;
            }

        }

       return f;


    }

    void innitialpopulation(int population[][]) {
        int a,b;
    	for (a=0;a<= 3;a++) {
            for (b=0; b<= 8;b++) {
                population[a][b] =(int)(Math.random()*8+1);
                if (b ==8) {
                    population[a][b] =0;
                }
            }
        }        
    }


    void newfitnessfunction() {
     
        int b,q,a = 0, x , d1, d2 = 0 ,hit= 0;
        boolean next= false;
        boolean diagonal1 = false , diagonal2 = false;
        
        while (a < 3) {
            hit= 0;
            for (b = 0; b < 7; b++) {
                int queen = b;
                d2 = 0;
                for (q = queen + 1; q <=7; q++) {
                    x= q - queen;
                    d1 = newchromo[a][queen] - newchromo[a][q];

                    if (d1 < 0) {
                        d2 = d1 * (-1);
                    }
                    if (d1 == 0 && next == false) {
                        next= true;
                        hit++;
                    }
                    if (x== d1 && diagonal1 == false) {
                        diagonal1 = true;
                        hit++;
                    }
                    if (x== d2 && diagonal2 == false) {
                        diagonal2 = true;
                        hit++;
                    }
                }
                next= false;
                diagonal1 = false;
                diagonal2 = false;
            }
            newchromo[a][8] =hit;
            a++;


        }

    }
    void Crossover() {
        int temp[] = new int[9];
        int i = 0,j;
        //crossovering from Half
        while (i <= 1) {
            int k = 0;
            for (j = 4; j < 8; j++) {
                temp[k] = newchromo[i][j];
                k++;
            }

            for (j = 4; j < 8; j++) {
                newchromo[i][j] = newchromo[i + 1][j];
            }
            k = 0;
            for (j = 4; j < 8; j++) {
                newchromo[i + 1][j] = temp[k];
                k++;
            }
            i++;

        }

    }
    

    void print() {
    	int a,b;
        for (a= 0; a< 4; a++) {
            for (b= 0; b<=8;b++) {
                System.out.print(chromo[a][b] + " ");
            }
            System.out.println();
        }        }


    void printnewchromosomes() {
        System.out.println("Results after performing crossover");
        int a,b;
        for (a= 0; a<3; a++) {
            for (b=0; b<=8; b++) {
                System.out.print(newchromo[a][b] + " ");
            }
            System.out.println();
        }
    }

}
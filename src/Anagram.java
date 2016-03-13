
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * This program calculates anagrams and outputs to a file.
 * It takes 2 command line arguments, the first the dict and then the output.
 */
/**
 * Joseph McCaffrey
 * @author Lenny
 */

// Fields
public class Anagram {
  static int count=0;
 static int largest =0;
  static int u = 0;
 
  public static void main(String[] args) throws FileNotFoundException{
    
        //Print writer takes second command argument
        PrintWriter out = new PrintWriter(args[1]);
        
        if(args.length >0){
                Scanner file;
       file = new Scanner(new FileReader(args[0]));
       //first scan to get the count of the file
         largest = 2500000 ;
       hashmap[] hashtable = new hashmap[largest];
       //fill the hash table with hashmap()
       
       for(int i = 0; i< largest ;i++){
         hashtable[i]= new hashmap();
      }
       System.out.println("initial");
       //walk through the file for each word
        while(file.hasNext()){
                String fresh = file.nextLine();
               //compute the product of the word
                long combo ;
               combo = product(fresh);
              //hash function, if the spot is empty add new word
               //combo % largest
               if(hashtable[getKey(combo)].size() == 0){
                 hashtable[getKey(combo)].add(fresh);
               }
               else{
                 // if the spot isnt empty check if the word matches
                if(combo == product(hashtable[getKey(combo)].get(1))){
                 
                hashtable[getKey(combo)].add(fresh);
                //chaining
                    }
                    else{
                    // if the spot doesnt match linear probe to find a new spot
                      int walk =1;
                      if(hashtable[getKey(combo)+walk].size() == 0){
                        hashtable[getKey(combo)+walk].add(fresh);
                      }
                      while(hashtable[getKey(combo)+walk].size() != 0){
                        // while linear probing if the spot matches add it
                          if(combo == product(hashtable[getKey(combo)+walk].get(1))){
                            
                            hashtable[getKey(combo)+walk].add(fresh);
                            break;
                          }
                          else{
                         walk =walk + 1;
                          }
                      }
         //if the spot never matches through the probe add to new spot
                      if(hashtable[getKey(combo)+walk].size()==0){
                      hashtable[getKey(combo)+walk].add(fresh);
                      }
                    }
                  }
        }
          // walk through the table for writing to file
        for(int h =0; h<largest; h++){
          
          //if the chain is longer than 1 we have an anagram class
          if(hashtable[h].size() >= 1){
            
            // walk thru the chain and print out to a single line
             for( int y =1; y<= hashtable[h].size() ;y ++){
               
                  out.print(hashtable[h].get(y) + " / ");     
          }
             // make a new line and count that as a class
             out.println("");
             u++;
          } 
        }
        System.out.println("Amount of classes: "+u);
        out.close();
        file.close();
       
      }
      else{
      System.out.println("File not found, I take 2 command line args");
      }   
  }
  // this computes the product for each word by walking thru string
  // and using a prime number for each letter to ensure that there
  // is no product collisions
  public static long product(String array){
    long one = 1;
    char chara ;
    long prime=0;
    for(int i = 0 ; i< array.length() ; i++){
        chara = array.charAt(i);
      switch(chara){
        case 'a':
          prime =2;
          break;
        case 'b':
          prime =3;
          break;
        case 'c':
          prime =5;
          break;
        case'd':
          prime =7;
          break;
        case 'e':
          prime = 11;
          break;
        case 'f':
          prime =13;
          break;
        case 'g':
          prime =17;
          break;
        case 'h':
          prime =19;
          break;
        case 'i':
          prime =23;
          break;
        case 'j':
          prime =29;
          break;
        case 'k':
          prime =31;
          break;
        case 'l':
          prime =37;
          break;
        case 'm':
          prime =41;
          break;
        case 'n':
          prime =43;
          break;
        case 'o':
          prime =47;
          break;
        case 'p':
          prime = 53;
          break;
        case 'q':
          prime = 59;
          break;
        case 'r':
          prime = 61;
          break;
        case 's':
          prime = 67;
          break;
        case 't':
          prime = 71;
          break;
        case 'u':
          prime = 73;
          break;
        case 'v':
          prime =79;
          break;
        case 'w':
          prime =83;
          break;
        case 'x':
          prime =89;
          break;
        case 'y':
          prime =97;
          break;
        case 'z':
          prime =101;
          break;  
      }
       one = prime*one ;               
    }
    
    return one;
  }
  
  public static int getKey(long n){
    
    int j = (int) Math.abs(n%largest);
    
    //System.out.println(j);
    return j;
  }
        }


 
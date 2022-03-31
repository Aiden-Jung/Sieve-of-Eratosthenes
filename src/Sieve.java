import java.util.Scanner;

/** 
 * implements an algorithm 
 * for generating prime numbers.
 * 
 * @author Aiden Hyunseok Jung
 * Email junghyun@grinnell.edu
 * Date September 15, 2020
 *
 * An object of the Sieve class models each sieve that filters out the
 * multiples of some specified number to generate prime numbers.
 */

public class Sieve {

    /* The source field stores a reference to the Sieve to which another
       Sieve sends its request.
       The factor field stores the number whose multiplies each Sieve is 
       trying to block.
     */

    private Sieve source;
    private int factor;

    /* The base Sieve constructor allocates storage for a new base Sieve,
       initializes source to null and factor to 2.
     */
    
    /**
     *  constructs a base Sieve. 
     */
    public Sieve() {
        this.source = null;
        this.factor = 2;
    }

    /* The Sieve constructor allocates storage for a new Sieve, takes divisor
       and predecessor as arguments, and initializes divisor to factor and
       predecessor to source.

       @param divisor prime number
       @param predecessor sieve
     */
       
    /** 
     * constructs a Sieve using a prime number
     * and a predecessor sieve 
     * @param divisor prime number.
     * @param predecessor sieve.
     */
    public Sieve(int divisor, Sieve predecessor) {
        this.factor = divisor;
        this.source = predecessor;
    }

    /* The next method returns the integers in ascending order, starting with
       2 in the case of the base Sieve.
       In the case of the non-base Sieve, the next method keeps asking the
       source Sieve for releasing candidate until the candidate is not 
       divisible by factor, and then returns it.
     */
    
    /**
     * returns the next integer in the ascending. 
     * order. This integer is either the next 
     * prime number or divisible by factor.
     * @return the next integer .
     */
    public int next() {
    	if(this.source == null) {

            return this.factor++;
    	} else {
            int candidate = source.next();
            
            while(candidate % factor == 0){
                candidate = source.next();
            }
            return candidate;
    	}
    }

    /* The main method use a Sieve to read an input integer n and print out the first n prime numbers,
       ten to a line, right-justifed in fields seven columns wide, and then
       stop.
     */

    public static void main(String[] args) {
    	
    	Scanner sc=new Scanner(System.in);  
    	
    	int n = sc.nextInt();
    	
        Sieve sifter = new Sieve();
        int prime;
        
        for(int count = 0; count < n; count++) {
            prime = sifter.next();
            System.out.print(String.format("%7s",Integer.toString(prime)));
            sifter = new Sieve(prime, sifter);	  
            if(count % 10 == 9) {
                System.out.println();
            }
        }
        
        sc.close();
    }
}

/* Copyright 2020 Shervin Hajiamini 
   I am indebted to my colleague, John Stone, for assistance with this file. 
*/

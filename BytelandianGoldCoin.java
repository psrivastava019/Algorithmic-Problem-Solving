/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/COINS
 */
public class BytelandianGoldCoin
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner in = new Scanner(System.in);
		while(in.hasNext()){
		  
		         long n=in.nextLong();
		         System.out.println(solution(n));
		}
	}
	public static long solution(long n){
	    if(n==0 || n==1){
	        return n;
	    }
	    long n1=n/2;
	    long n2=n/3;
	    long n3=n/4;
	    
	    if((n1+n2+n3)>n){
	        return solution(n1)+solution(n2)+solution(n3);
	    }
	    return n;
	    
	}
}

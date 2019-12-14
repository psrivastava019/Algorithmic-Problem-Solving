/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/MARBLES
 */
class Marbles
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++){
		    String[] s=br.readLine().split(" ");
		    long n=Long.parseLong(s[0]);
		    long k=Long.parseLong(s[1]);
		    System.out.println(findSolution(n-1,k-1));
		}
	}
	public static long findSolution(long N,long K){
	  long val=1;
	  	if(K>N-K) {
			K=N-K;
		}
	   for(int i=0;i<K;i++){
	       val=(N-i)*val/(i+1);
	   }
	   
	   
	    return val;
	}
	

}

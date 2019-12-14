/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/CULPRO
 */
public class CulturalPragramme
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   int T=Integer.parseInt(br.readLine());
	  int [] entry=new int[T];
	  int [] exit = new int[T];
	   for(int i=0;i<T;i++){
	        String[] s=br.readLine().split(" ");
	        entry[i]=Integer.parseInt(s[0]);
	        exit[i]=Integer.parseInt(s[1]);
	   }
	    System.out.println(solve(entry,exit,T));
	}
	
	public static int solve(int[] entry, int[] exit, int N){
	    Arrays.sort(entry);
	    Arrays.sort(exit);
	    int i=0;
	    int j=0;
	    int count=0;
	    int result=0;
	    while(i<N){
	        if(entry[i]<exit[j]){
	            count++;
	            result=Math.max(result,count);
	            i++;
	        }
	        else{
	            count--;
	            j++;
	        }
	    }
	    return result;
	}
}

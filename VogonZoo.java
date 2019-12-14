/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/VOGOZO
 */
public class VogonZoo
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   String [] s=br.readLine().split(" ");
	   int N=Integer.parseInt(s[0]);
	   int K=Integer.parseInt(s[1]);
	   String[] s1=br.readLine().split(" ");
	   int[] arr=new int[s1.length];
	   for(int i=0;i<s1.length;i++){
	       arr[i]=Integer.parseInt(s1[i]);
	   }
	   
	    System.out.println(solve(arr,K, N));
	}
	public static int solve(int[] arr,int K,int N){
	    Arrays.sort(arr);
	    int current=arr[0];
	    int count=1;
	    for(int i=1;i<N;i++){
	        if(arr[i]>=current+K){
	            count++;
	            current=arr[i];
	        }
	    }
	    return count;
	}
}

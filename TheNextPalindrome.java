/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/PALIN
 */
public class TheNextPalindrome
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++){
		    String num=br.readLine();
		    int[] N=new int[num.length()];
		    for(int j=0;j<num.length();j++){
		        N[j]=Integer.parseInt(num.charAt(j)+"");
		    }
		    solution(N);
		}
	}
	
	public static void solution(int[] N){
	   if(allNine(N)){
	       for(int i=0;i<N.length;i++){
	           if(i==0)
	           System.out.print("1");
	           else
	           System.out.print("0");
	       }
	       System.out.println("1");
	       return;
	   }
	   int n=N.length;
	   int m=n/2;
	   int i=m-1;
	   int j= (n%2==0)?m:m+1;
	  
	   while(i>=0 && N[i]==N[j]){
	       i--;
	       j++;
	   }
	   boolean flag=false;
	   if(i<0 || N[i]<N[j]){
	       flag=true;
	   }
	   while(i>=0){
	       N[j++]=N[i--];
	   }
	   if(flag){
	       int carry = 1; 
		
			if (n % 2 == 1) { 
				N[m] += 1; 
				carry = N[m] / 10; 
				N[m] %= 10; 
			} 
			i = m - 1; 
			j = (n % 2 == 0 ? m : m + 1); 
		
			while (i >= 0) 
			{ 
				N[i] = N[i] + carry; 
				carry = N[i] / 10; 
				N[i] %= 10; 
				N[j] = N[i];
				i--; 
				j++; 
			} 
	   }
	   
	   for(int k=0;k<N.length;k++){
	       System.out.print(N[k]);
	   }
	   System.out.println("");
	}
    
    public static boolean allNine(int[] N){
        boolean flag=true;
        for(int i=0;i<N.length;i++){
            if(N[i]!=9){
                flag=false;
            }
        }
        return flag;
    }
    
}

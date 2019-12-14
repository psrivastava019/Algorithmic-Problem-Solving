/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/ORDERS
 */
public class OrderingSoldiers
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++){
		    int N=Integer.parseInt(br.readLine());
		    int[] inp=new int[N];
		    int[] pos=new int[N];
		    
		    
		    String[] s= br.readLine().split(" ");
		    for(int j=0;j<N;j++){
		        inp[j]=Integer.parseInt(s[j]);
		    }
		    for(int j=0;j<N;j++){
		        pos[j]=j+1;
		    }
		    solution(inp,pos,N);
		    for(int j = 0; j < N; j++) {
    			System.out.print(pos[j] + " ");
    		}
    		System.out.println();
		}
	}
	
	public static void solution(int[] inp,int[] pos,int N){
	   for(int i=N-1;i>=0;i--){
	       int replaceRank=i-inp[i];
	       int replaceTo=i;
	       if(replaceRank!=replaceTo){
	           int tempVal = pos[replaceRank];
            	    for(int j = replaceRank+1; j <= replaceTo; j++) {
            	        pos[j-1] = pos[j];
            	    }
            	    pos[replaceTo] = tempVal;
	       }
	   }
	}
	
	public static int findZero(int[] pos,int num){
	    int index=0;
	    while(num!=0){
	        if(pos[index]!=0){
	            index++;
	            continue;
	        }
	        else{
	            num--;
	            index++;
	        }
	    }
	    pos[index-1]=1;
	   // System.out.println(num+"th"+" "+index);
	    return index;
	}
}

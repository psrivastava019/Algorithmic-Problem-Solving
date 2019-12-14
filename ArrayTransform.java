/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/ARRAYTRM
 */
public class ArrayTransform
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++){
		    String[] s=br.readLine().split(" ");
		    int N=Integer.parseInt(s[0]);
		    int K=Integer.parseInt(s[1]);
		    int[] arr=new int[N];
		    String[] s1=br.readLine().split(" ");
		    for(int j=0;j<N;j++){
		        arr[j]=Integer.parseInt(s1[j]);
		    }
		    solution(arr,K,N);
		}
	}
	
	public static void solution(int[] arr,int K,int N){
	    boolean flag=false;
	    int[] rec=new int[K+1];
	    for(int i=0;i<N;i++){
	        rec[arr[i]%(K+1)]++;
	    }
	    
	    for(int j=0;j<rec.length;j++){
	        if(rec[j]>=N-1){
	            System.out.println("YES");
	            flag=true;
	            break;
	        }
	    }
	    if(!flag){
	        System.out.println("NO");
	    }
	    
	    
	}
}

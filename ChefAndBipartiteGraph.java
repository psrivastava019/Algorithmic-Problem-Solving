/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/ICPC16F
 */
public class ChefAndBipartiteGraph
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   int T=Integer.parseInt(br.readLine());
	   for(int i=0;i<T;i++){
	       String[] s=br.readLine().split(" ");
	       int n=Integer.parseInt(s[0]);
	       int m=Integer.parseInt(s[1]);
	       int d=Integer.parseInt(s[2]);
	       int D=Integer.parseInt(s[3]);
	       
	       if(m<n*d || m>n*D){
	           System.out.println("-1");
	           continue;
	       }
	 solution(n,m,d,D);
	    
	 }
	       
}
	public static void solution(int n,int m,int d,int D){
	    int index=1;
	    int total=0;
	    int vertexNo=1;
       while(m!=0){
          if(total<n*D){
              System.out.println(index+" "+vertexNo);
              total++;
              index++;
              m--;
              vertexNo++;
              if(index>n){
                  index=index%n;
                vertexNo--;
                if(vertexNo==0){
                    vertexNo=n;
                }
                continue;
              }
              if(vertexNo>n){
                  vertexNo=vertexNo%n;
              }
          }
      
       }
	}
}

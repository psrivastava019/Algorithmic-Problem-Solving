/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/TADELIVE
 */
public class DeliveryMan
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   String[] s=br.readLine().split(" ");
	   int N=Integer.parseInt(s[0]);
	   int X=Integer.parseInt(s[1]);
	   int Y=Integer.parseInt(s[2]);
	   String[] s1=br.readLine().split(" ");
	   int[] A=new int[N];
	   for(int i=0;i<s1.length;i++){
	       A[i]=Integer.parseInt(s1[i]);
	   }
	   String[] s2=br.readLine().split(" ");
	   int[] B=new int[N];
	   for(int i=0;i<s2.length;i++){
	       B[i]=Integer.parseInt(s2[i]);
	   }
	   System.out.println(solution(N,X,Y,A,B));
	}
	public static int solution(int N,int X, int Y,int[] A,int[] B){
	 Map<Integer,Integer> tMap=new HashMap<>();
	    for(int i=0;i<N;i++){
	        tMap.put(i,Math.abs(A[i]-B[i]));
	    }
	 List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(tMap.entrySet()); 
	
	 Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
	
	HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
	
	int sum=0;   
	for(Integer i:temp.keySet()){
	    if(A[i]>B[i]){
	        if(X!=0){
	            X--;
	            sum+=A[i];
	        }
	        else{
	            Y--;
	            sum+=B[i];
	        }
	    }
	    else if(B[i]>A[i]){
	        if(Y!=0){
	            Y--;
	            sum+=B[i];
	        }
	        else{
	            X--;
	            sum+=A[i];
	        }
	        
	    }
	    else{
	        if(X!=0){
	            X--;
	            sum+=A[i];
	        }
	        else{
	            Y--;
	            sum+=B[i];
	        }
	    }
	}
    return sum;	    
 }

}

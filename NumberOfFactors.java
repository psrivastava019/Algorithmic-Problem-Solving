/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.codechef.com/problems/NUMFACT
 */
public class NumberOfFactors
{
    private static final Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
	 
	 while(scanner.hasNext()){
	     int T = scanner.nextInt();
         for (int TItr = 0; TItr < T; TItr++) {
            
            int N = scanner.nextInt();
            int [] num=new int[N];
            for(int i=0;i<N;i++){
                num[i]=scanner.nextInt();
            }
        
            int res = calcFactors(num);
            System.out.println(res);
        }
	}
   // calcFactors(new int[]{5,5});
}
	
	public static int calcFactors(int [] num){
	    Map<Integer,Integer> map=new HashMap<>();
	    for(int i=0;i<num.length;i++){
	        int index=num[i];
	        if(index>0){
	            int s=findPrimeFactors(map,index);
	            while(s!=index){
	            index=index/s;
	            s=findPrimeFactors(map,index);
	            }
	        }
	        else{
	            return 0;
	        }
	       
	    }
	    int count=1;
	    for(Map.Entry<Integer,Integer> e:map.entrySet()){
	        count*=e.getValue()+1;
	    }
	    return count;
	}
	
	public static int findPrimeFactors(Map<Integer,Integer> map,int val){
	  for(int i=2;i<=val;i++){
	      if(val%i==0){
	          if(map.get(i)!=null){
	              int pow=map.get(i);
	              map.put(i,pow+1);
	             
	          }
	          else{
	              map.put(i,1);
	          }
	           return i;
	      }
	    
	    }
	    return val;
    }
}

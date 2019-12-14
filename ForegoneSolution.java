import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/0000000000088231
 */
public class ForegoneSolution{
	
    public static void main(String args[]) throws NumberFormatException, IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int T= Integer.parseInt(br.readLine());
    	for(int i=1;i<=T;i++){
    	    String a=br.readLine();
    	    StringBuilder sb1=new StringBuilder();
    	    StringBuilder sb2=new StringBuilder();
    	    for(int j=0;j<a.length();j++){
    	        if(a.charAt(j)=='4'){
    	            sb1.append('2');
    	            sb2.append('2');
    	        }
    	        else{
    	            sb1.append(a.charAt(j));
    	            sb2.append('0');
    	        }
    	    }
    	    System.out.println("Case #"+i+": "+sb1.toString()+" "+sb2.toString());
    	    
    	}
 
    }

}
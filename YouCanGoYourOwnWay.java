import java.io.BufferedReader;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881da
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class YouCanGoYourOwnWay{
	
    public static void main(String args[]) throws NumberFormatException, IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int T= Integer.parseInt(br.readLine());
    	for(int j=1;j<=T;j++){
    	    int a=Integer.parseInt(br.readLine());
    	    String s=br.readLine();
    	    StringBuilder sb=new StringBuilder();
    	    for(int i=0;i<s.length();i++){
    	        if(s.charAt(i)=='E'){
    	            sb.append('S');
    	        }
    	        else{
    	            sb.append('E');
    	        }
    	    }
    	    System.out.println("Case #"+j+": "+sb.toString());
    	    
    	}
 
    }

}
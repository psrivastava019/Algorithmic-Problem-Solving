import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://codingcompetitions.withgoogle.com/codejam/round/00000000000516b9/0000000000134c90
 */
public class RobotProgrammingStrategy{
	
	static String result="";
    public static void main(String args[]) throws NumberFormatException, IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int T= Integer.parseInt(br.readLine());
    	for(int i=1;i<=T;i++){
    	    int V=Integer.parseInt(br.readLine());
    	    result="";
    	    List<String> list=new ArrayList<>();
    	    for(int j=0;j<V;j++){
    	        list.add(br.readLine());
    	    }
    	    Set<Integer> set=new HashSet<>();
    	    int val=solve(0,"",list,set,V);
    	    if(val>0) {
    	    	System.out.println("Case #"+i+": "+result);
    	    }
    	    else {
    	    	System.out.println("Case #"+i+": "+"IMPOSSIBLE");
    	    }
    	    
    	}
    }
    public static int solve(int index,String ans,List<String> list,Set<Integer> skip,int n) {
    	Set<Character> chrSet=new HashSet<>();
    	if(index>1000) {
    		result=ans;
    		return 0;
    	}
    	for(int i=0;i<n;i++) {
    		if(skip.contains(i)) {
    			continue;
    		}
    		if(index<list.get(i).length()) {
    			chrSet.add(list.get(i).charAt(index));
    		}
    		else {
    			chrSet.add(list.get(i).charAt(index%list.get(i).length()));
    		}
    	}
    	
    	if(chrSet.size()==0) {
    		return 0;
    	}
    	if(chrSet.size()==3) {
    		return 0;
    	}
    	if(chrSet.size()==1) {
    		if(chrSet.contains('P')) {
    			ans+="S";
    		}
    		else if(chrSet.contains('R')) {
    			ans+="P";
    		}
    		else if(chrSet.contains('S')) {
    			ans+="R";
    		}
    		result=ans;
    		return 1;
    	}
    	
    	
    	StringBuilder sb=new StringBuilder();
    	for(Character c:chrSet) {
    		sb.append(c);
    	}
    	
    	String newStr=sb.toString();
    	if(newStr.compareTo("PR") == 0){
    	    for (int i = 0; i < n; i++) {
    	 
    	      if (list.get(i).charAt(index%list.get(i).length()) == 'R') {
    	        skip.add(i);
    	      }
    	    }
    	    return solve(index + 1, ans + "P", list,skip,n);
    	  }
    	
    	if(newStr.compareTo("RS") == 0){
    	    for (int i = 0; i < n; i++) {
    	 
    	      if (list.get(i).charAt(index%list.get(i).length()) == 'S') {
    	        skip.add(i);
    	      }
    	    }
    	    return solve(index + 1, ans + "R", list,skip,n);
    	  }
    	
    	if(newStr.compareTo("PS") == 0){
    	    for (int i = 0; i < n; i++) {
    	 
    	      if (list.get(i).charAt(index%list.get(i).length()) == 'P') {
    	        skip.add(i);
    	      }
    	    }
    	    return solve(index + 1, ans + "S", list,skip,n);
    	  }
    	
    	return 0;
    }
   
}


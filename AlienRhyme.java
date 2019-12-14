import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/** 
 * Author: Priyanshu Srivastava
 * Source: https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104e05
 */
public class AlienRhyme{
	
	
    public static void main(String args[]) throws NumberFormatException, IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int T= Integer.parseInt(br.readLine());
    	for(int i=1;i<=T;i++){
    	    int V=Integer.parseInt(br.readLine());
    	    String[] str=new String[V];
    	    for(int j=0;j<V;j++){
    	        str[j]=br.readLine();
    	    }
    	    State root=sol(str);
    	    int val=traverse(root);
    	    System.out.println("Case #"+i+": "+(str.length-val));
    	}
    }
    
    public static State sol(String[] str){
        State root=new State();
        root.isRoot=true;
        for(int i=0;i<str.length;i++){
        	StringBuilder s1=new StringBuilder();
        	s1.append(str[i].toLowerCase());
        	s1=s1.reverse();
            root.buildTree(s1.toString());
        }
        return root;
        
    }
    	
    public static int traverse(State root){
    	if(countChildren(root)==0){
    		return root.fVal;
    	}
    	int temp=0;
    	for(int i=0;i<root.children.length;i++){
    			if(root.children[i]!=null){
    				 temp += traverse(root.children[i]);
    			}
    	}
    	if(root.marker){
    	
    		temp=temp+1;
    	}
    	if(temp>=2 && root.isRoot==false){
    		temp=temp-2;
    	}
    	return temp;
    }
    
    public static int countChildren(State root){
    	int count=0;
    	for(int i=0;i<26;i++){
    		if(root.children[i]!=null){
    			count++;
    		}
    	}
    	return count;
    }
}

class State{
    State[] children=new State[26];
    boolean marker;
    int fVal;
    boolean isRoot=false;
    State(){
         for (int i = 0; i < 26; i++) 
                children[i] = null; 
         this.marker=false;
         this.fVal=0;
    }
    
    public void buildTree(String s){
        if(s.length()>0){
            int index=(s.charAt(0)-'a');
            if(children[index]==null){
                children[index]=new State();
            }
            children[index].buildTree(s.substring(1));
            if(s.substring(1).length()==0){
            	children[index].marker=true;
            	children[index].fVal=1;
            }
        }
    }
}
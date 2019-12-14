import java.util.*;
import java.lang.*;
import java.io.*;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://codingcompetitions.withgoogle.com/codejam/round/00000000000000cb/00000000000079cb
 */
 class TroubleSort{
    public static void main(String args[]) throws java.lang.Exception{
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int valueCount = scanner.nextInt();
                int[] values = new int[valueCount];
                for (int i = 0; i < valueCount; i++) values[i] = scanner.nextInt();
                int result = solve(values);
                System.out.println("Case #" + testNumber + ": " + (result >= 0 ? result : "OK"));
            }
        }
    }
     private static int solve(int[] values) {
        int[] evenArray = new int[(values.length + 1) / 2];
        int[] oddArray = new int[values.length / 2];
        for (int i = 0; i < values.length; i += 2) {
        	evenArray[i / 2] = values[i];
        }
        for (int i = 1; i < values.length; i += 2) {
        	oddArray[i / 2] = values[i];
        }
        Arrays.sort(evenArray);
        Arrays.sort(oddArray);
        int last = evenArray[0];
        for (int i = 1; i < values.length; i++) {
            int curr = i % 2 == 0 ? evenArray[i / 2] : oddArray[i / 2];
            if (curr < last) return i - 1;
            last = curr;
        }
        return -1;
    }
    public static void solution(int[] V,int n, int caseNum){
        int i=1;
        int j=n-1;
        
        if(j%2!=0){
            j--;
        }
        
        while(i<j){
            swap(V,i,j);
            i+=2;
            j-=2;
        }
        
        Arrays.sort(V,0,(n+1)/2);
        Arrays.sort(V,(n+1)/2,n);
        
        int temp1=0;
        int temp2=(n+1)/2;
        boolean flag=false;
        int wrongIndex=0;
        while(temp1!=((n+1)/2)-1 && temp2!=n){
            if(V[temp1]<V[temp2] && V[temp2]<V[temp1+1]){
                temp1++;
                temp2++;
            }
            else{
                flag=true;
                if(V[temp1]>V[temp2])
                wrongIndex=temp1*2;
                else
                	wrongIndex=temp1*2+1;
                break;
                
            }
            
        }
        if(flag){
            System.out.println("Case #"+caseNum+": "+wrongIndex);
        }
        else{
             System.out.println("Case #"+caseNum+": OK");
        }
        
    }
    
    public static void solution1(int[] V,int caseNum){
    
    	while(true){
    		boolean done=true;
    		for(int i=0;i<V.length-2;i++){
    			if(V[i]>V[i+2]){
    				done=false;
    				swap(V,i,i+2);
    			}
    		}
    		 if (done) break;
    	}
    	boolean flag=false;
    	for(int j=0;j<V.length-1;j++){
    		if(V[j]>V[j+1]){
    			flag=true;
    			System.out.println("Case #"+caseNum+": "+j);
    		}
    	}
    	if(!flag){
    		System.out.println("Case #"+caseNum+": OK");
    	}
    }
    
    public static void swap(int[] V,int i,int j){
        int temp=0;
        temp =V[i];
        V[i]=V[j];
        V[j]=temp;
    }
}
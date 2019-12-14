import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/** 
 * Author: Priyanshu Srivastava
 * Source:https://www.hackerrank.com/challenges/kmp-problem/problem
 */
public class YetAnotherKmpProblem {

    /*
     * Complete the kmp function below.
     */
    static String kmp(int[] x) {
        int small=Integer.MAX_VALUE;
        int index=-1;
        int count=0;
        int second=0;
        int secondIndex=0;
        for(int i=0;i<x.length;i++) {
            if(x[i]!=0 && x[i]<small) {
                small=x[i];
                index=i;
            }
            if(x[i]!=0){
                count++;
                if(count==2){
                    second=x[i];
                    secondIndex=i;
                }
            }

        }
        StringBuilder br=new StringBuilder();
        br.append((char)(index+'a'));
        x[index]=x[index]-1;
        if(x[index]!=0){
            if(((char)(index+'a'))<((char)(secondIndex+'a'))){
                br.append(new String(new char[x[index]]).replace("\0",Character.toString((char)(index+'a')) + Character.toString((char)(secondIndex+'a'))));
                x[secondIndex]=x[secondIndex]-x[index];
                x[index]=x[index]-x[index];
            }
        }

        for(int i=0;i<x.length;i++) {
         
                int freq=x[i];
                while(freq!=0) {
                    br.append((char)(i+'a'));
                    freq--;
                }
            
        }
        return br.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.in));

        int[] x = new int[26];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int xItr = 0; xItr < 26; xItr++) {
            int xItem = Integer.parseInt(xItems[xItr]);
            x[xItr] = xItem;
        }

        String result = kmp(x);

		/*
		 * bufferedWriter.write(result); bufferedWriter.newLine();
		 */

        //bufferedWriter.close();

        scanner.close();
    }
}
